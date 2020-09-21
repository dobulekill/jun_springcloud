package com.itqf.smsplatform.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itqf.smsplatform.api.exception.SmsInterfaceException;
import com.itqf.smsplatform.api.feign.CacheService;
import com.itqf.smsplatform.api.service.PushSubmitToQueueService;
import com.itqf.smsplatform.api.service.SmsCheckService;
import com.itqf.smsplatform.common.constants.CacheConstants;
import com.itqf.smsplatform.common.constants.InterfaceExceptionDict;
import com.itqf.smsplatform.common.model.Standard_Submit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * author:zouningsss
 * date:Created in 2020/3/16 14:22
 * description:
 */

@Service
public class SmsCheckServiceImpl implements SmsCheckService {

    private Logger LOGGER = LoggerFactory.getLogger(SmsCheckServiceImpl.class);

    @Autowired
    private CacheService cacheService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PushSubmitToQueueService pushSubmitToQueueService;

    @Override
    public void checkSms(String clientId, String pwd, String srcID, String ip, String content, String mobile) throws Exception {
        //首先要校验数据

        //我们一旦遇到如何判断,如何知道,如何 xxx 的时候肯定是有一个地方会保存数据的,无非就是保存在什么地方,保存在什么地方没有限制
        //保存在数据库,文件,redis,jvm 中都可以,只要能找到这个数据就行了,然后再考虑所谓性能问题
        Integer id;//客户端 id,此处用 int 的原因是你做梦都不敢梦到你有几十亿的客户
        Long sourceId;//下行编号,此处用 long 的 原因是因为短信可能会非常多,会超出 int 的最大值

        LOGGER.error("IP是:{}", ip);
        try {
            id = Integer.parseInt(clientId);
        } catch (Exception e) {
//          e.printStackTrace();
            //代表传递的 id 不合法,需要返回错误信息给用户
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_CLIENTID_ERROR, "客户id错误");
        }

        try {
            sourceId = Long.parseLong(srcID);
        } catch (Exception e) {
            // e.printStackTrace();
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_SRCID_ERROR, "SRCID 错误");

        }
        //1获取真正的数据,我们的数据是在 redis 中保存的,所以需要从 redis 中获取,那我们需要确定保存的数据格式和 key 的格式什么
        //key 的格式是 CacheConstants.CACHE_PREFIX_CLIENT+id,数据的格式是一个 hash
        Map clientInfoMap = cacheService.hmget(CacheConstants.CACHE_PREFIX_CLIENT + id);
        if (clientInfoMap == null || clientInfoMap.size() == 0) {
            //代表没有这个用户,我们应该抛出异常告诉客户端
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_CLIENTID_ERROR, "没有这个客户id");
        }

        if (StringUtils.isEmpty(ip) || !ip.equalsIgnoreCase((String) clientInfoMap.get("ipaddress"))) {
            //代码传递的 ip 不符合
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_IP_ERROR, "IP地址非法");
        }

        // String md5DigestAsHex = DigestUtils.md5DigestAsHex(pwd.getBytes());//获取传递的密码的 md5 值

        // LOGGER.error("传递的密码的 MD5:{}", md5DigestAsHex);

        if (StringUtils.isEmpty(pwd) || !DigestUtils.md5DigestAsHex(pwd.getBytes()).equalsIgnoreCase((String) clientInfoMap.get("pwd"))) {
            //代码传递的 ip 不符合
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_PWD_ERROR, "密码错误");
        }
        if (StringUtils.isEmpty(content) || content.length() > 500) {
            //短信的内容不符合
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_MESSAGE_ERROR, "内容长度不符合要求");
        }
        if (StringUtils.isEmpty(mobile)) {
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_MOBILE_ERROR, "手机号为空");
        }

        //如果校验失败,返回失败信息给用户


        //如果校验成功,是不是应该要发送短信
        //短信要怎么发
        //还要判断短信的各种内容,比如内容是不是合法的,比如手机号是不是一个黑名单,比如有没有钱等等
        //所以我们的发送实际上是交给下一个流程去处理这个信息
        //如果交给下一个流程,如何传递数据过去
        //我们的下一个流程理论上肯定是在另外一个服务,另外一个服务理论上肯定在另外一个 tomcat,那么我们的请求方式就只有一种,网络请求
        //网络请求分为同步请求和异步请求,那我们这里到底使用同步还是异步
        //同步和异步的区别就是同步一直可以等到结果返回给用户,异步无法直接等待结果
        //我们当前的操作需要不需要立刻给用户一个准确的结果,如果需要,就用同步,如果不需要就用异步

        //按照流程,我们的客户的用户在客户的页面上点击了发送短信,客户的服务器会收到他的用户的请求,然后再来请求我们的这个接口来发送短信
        //我们的响应实际上是给客户的服务器,不会直接给那个点击发送短信的人,然后我们知道短信的发送结果实际上是以用户最终有没有收到短信来判断的
        //而不是通过客户的服务器告诉那个人,所以我们发现没有必要等着拿最终的发送结果告诉用户,只需要先告诉他正在发送就行了,最后等我们有结果了再回来告诉客户的服务器即可
        //所以我们发现我们后面的操作是可以异步的,不需要等待结果
        //如何去异步

        //按照我们的文档说明,用户可以一次性最多发送一个账号,所以我们需要判断当前传递过来的手机号是不是有很多个,当用户传递多个手机号的时候,我们要求用户使用,来分割

        String[] mobiles = mobile.split(",");//拿到传递的所有的手机号
        if (mobiles.length > 100) {
            //超出了发送号码的最大上限,其实这个上限是可以定义的,每个用户可能都不一样,所以实际开发中是有默认值,可以用单个用户单独定义的,可以保存在 redis 中
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_MOBILE_ERROR, "手机号数量超出限制");
        }

        Map<String, List<String>> checkMobile = checkMobile(mobiles);//校验手机号后得到的 map

        //我们知道可能会有失败的手机号,也有成功的,一定要注意,失败的应该是最后才判断
        List<String> success = checkMobile.get("success");
        List<Standard_Submit> standard_submits = new ArrayList<>();//用于封装短信相关数据的对象集合,用于将正常的手机和内容封装起来
        for (String mobilenumer : success) {
            Standard_Submit standard_submit = new Standard_Submit();
            //保持信息
            standard_submit.setClientID(id);
            standard_submit.setSrcSequenceId(sourceId);
            standard_submit.setDestMobile(mobilenumer);
            standard_submit.setMessageContent(content);
            standard_submit.setSendTime(new Date());
            standard_submits.add(standard_submit);
            int usertype = (int) clientInfoMap.get("usertype");//获取用户的类型,1为 http,2 为 web 模式
            standard_submit.setSource(usertype);//将用户的类型保存到消息中,后面发送状态报告的时候需要
        }
        //发送数据到下一个流程
        LOGGER.error("发送到下个流程的手机号是:{}", standard_submits);

        pushSubmitToQueueService.sendSmsSubitToQueue(standard_submits);//将这些数据发送到 mq


        //判断有没有需要返回的数据(错误的手机号)
        List<String> fail = checkMobile.get("fail");
        if (fail.size() > 0) {
            //有不符合要求的电话号码
            //将这些电话号码返回给用户
            throw new SmsInterfaceException(InterfaceExceptionDict.RETURN_STATUS_MOBILE_ERROR, objectMapper.writeValueAsString(fail));

        }
    }


    /**
     * 校验手机号,合法的保存到 success 这个 key,不合法的保存到 fail 这个 key
     *
     * @param mobiles
     * @return
     */
    private Map<String, List<String>> checkMobile(String[] mobiles) {
        //我们要判断传递过来的手机号是不是一个合法的手机号
        List<String> success = new ArrayList<>();//保存校验成功的手机号的集合
        List<String> fail = new ArrayList<>();//保存校验失败的手机号的集合
        Map<String, List<String>> result = new HashMap<>();
        result.put("success", success);
        result.put("fail", fail);
        //如果不是合法的手机号怎么处理?正常来说 应该是正常的手机号继续发送短信,非法的手机号最终给用户返回一个接口告诉他这些手机号是有问题的
        String regex = "^((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(166)|(17[0135678])|(18[0-9])|(19[8|9]))\\d{8}$";
        for (String mobile : mobiles) {
            boolean matches = mobile.matches(regex);//判断手机号是否合法
            if (matches) {
                success.add(mobile);
            } else {
                fail.add(mobile);
            }
        }


        return result;

    }

}
