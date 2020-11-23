package com.zscat.goods.controller.admin;


import com.zscat.goods.entity.TGoodsTypeDO;
import com.zscat.goods.service.TGoodsTypeService;
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
@RequestMapping("/shop/tGoodsType")
public class TGoodsTypeController {
    @Resource
    private TGoodsTypeService tGoodsTypeService;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    R list(@RequestParam Map<String, Object> params) {
        R r = new R();
        // 查询列表数据
        Query query = new Query(params);
        List<TGoodsTypeDO> list = tGoodsTypeService.list(query);
        int total = tGoodsTypeService.count(query);
        r.put("rows", list);
        r.put("total", total);
        return r;
    }

    /**
     * 详情
     *
     * @param model
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/detail")
    R detail(Model model, Long id) {
        R r = new R();
        TGoodsTypeDO sysDept = tGoodsTypeService.get(id);
        r.put("entity", sysDept);
        return r;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(@RequestBody TGoodsTypeDO entity) {

        if (entity.getId() == null) {
            if (tGoodsTypeService.save(entity) > 0) {
                return R.ok();
            }
        } else {
            if (tGoodsTypeService.update(entity) > 0) {
                return R.ok();
            }
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    // @RequiresPermissions("shop:tGoodsType:edit")
    public R update(TGoodsTypeDO tGoodsType) {
        tGoodsTypeService.update(tGoodsType);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    // @RequiresPermissions("shop:tGoodsType:remove")
    public R remove(Long id) {
        if (tGoodsTypeService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    // @RequiresPermissions("shop:tGoodsType:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tGoodsTypeService.batchRemove(ids);
        return R.ok();
    }

}
