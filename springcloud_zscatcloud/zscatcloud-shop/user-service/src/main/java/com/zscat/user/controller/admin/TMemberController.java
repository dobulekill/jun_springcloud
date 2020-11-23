package com.zscat.user.controller.admin;


import com.alibaba.druid.pool.DruidDataSource;
import com.zscat.user.entity.TMemberDO;
import com.zscat.user.service.TMemberService;
import com.zscatcloud.base.dto.PageUtils;
import com.zscatcloud.base.dto.Query;
import com.zscatcloud.base.dto.R;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Wujun
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */

@Controller
@RequestMapping("/shop/tMember")
public class TMemberController {
    @Resource
    private TMemberService tMemberService;

    @GetMapping()
    String TMember() {
        return "shop/tMember/tMember";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<TMemberDO> tMemberList = tMemberService.list(query);
        int total = tMemberService.count(query);
        PageUtils pageUtils = new PageUtils(tMemberList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add() {
        return "shop/tMember/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        TMemberDO tMember = tMemberService.get(id);
        model.addAttribute("tMember", tMember);
        return "shop/tMember/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(TMemberDO tMember) {
        if (tMemberService.save(tMember) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(TMemberDO tMember) {
        DruidDataSource s;
        tMemberService.update(tMember);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (tMemberService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tMemberService.batchRemove(ids);
        return R.ok();
    }

}
