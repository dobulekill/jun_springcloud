package com.wujunshen.web.vo.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User:frankwoo(吴峻申) <br>
 * Date:2016-11-3 <br>
 * Time:15:50 <br>
 * Mail:frank_wjs@hotmail.com <br>
 */
@Data
@ConfigurationProperties(prefix = "audience")
@Component
@ApiModel(value = "JWT")
public class Audience {
    @ApiModelProperty(value = "传入的客户端id，相当于微信的openID", required = true)
    private String clientId;
    @ApiModelProperty(value = "64位公钥", required = true)
    private String base64Secret;
    @ApiModelProperty(value = "令牌发行者姓名", required = true)
    private String name;
    @ApiModelProperty(value = "令牌有效时间，单位为秒", required = true)
    private int expiresSecond;
}