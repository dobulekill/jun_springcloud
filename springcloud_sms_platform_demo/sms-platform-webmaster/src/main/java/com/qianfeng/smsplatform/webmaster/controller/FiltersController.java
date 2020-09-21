package com.qianfeng.smsplatform.webmaster.controller;


import com.qianfeng.smsplatform.webmaster.pojo.TFilters;
import com.qianfeng.smsplatform.webmaster.service.FiltersService;
import com.qianfeng.smsplatform.webmaster.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:zouningsss
 * date:Created in 2020/3/17 17:31
 * description:
 */

@RestController
public class FiltersController {
    @Autowired
    private FiltersService filtersService;

    /**
     * 修改某个分组的过滤器的顺序
     *
     * @param filterOrder 过滤器的分组id
     * @param filters     过滤器
     * @return
     */
    @RequestMapping("/sys/filters/update")
    public R updateFilters(String filterOrder, String filters) {
        try {
            int updateFilters = filtersService.updateFilters(filterOrder, filters);
            if (updateFilters == 1) {
                return R.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }


    /**
     * 添加一个过滤器的分组
     *
     * @param filter 过滤器
     * @return
     */
    @RequestMapping("/sys/filters/add")
    public R addFilters(TFilters filter) {
        try {
            filtersService.addFilters(filter);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error();
    }
}
