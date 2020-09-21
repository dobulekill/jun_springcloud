package com.zscat.goods.controller.admin;


import com.zscat.goods.entity.TFloorGoodsDO;
import com.zscat.goods.service.TFloorGoodsService;
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
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */

@Controller
@RequestMapping("/shop/tFloorGoods")
public class TFloorGoodsController {
    @Resource
    private TFloorGoodsService tFloorGoodsService;

    @GetMapping()
        // @RequiresPermissions("shop:tFloorGoods:tFloorGoods")
    String TFloorGoods() {
        return "shop/tFloorGoods/tFloorGoods";
    }

    @ResponseBody
    @GetMapping("/list")
    // @RequiresPermissions("shop:tFloorGoods:tFloorGoods")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<TFloorGoodsDO> tFloorGoodsList = tFloorGoodsService.list(query);
        int total = tFloorGoodsService.count(query);
        PageUtils pageUtils = new PageUtils(tFloorGoodsList, total);
        return pageUtils;
    }

    @GetMapping("/add")
        // @RequiresPermissions("shop:tFloorGoods:add")
    String add() {
        return "shop/tFloorGoods/add";
    }

    @GetMapping("/edit/{id}")
        // @RequiresPermissions("shop:tFloorGoods:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        TFloorGoodsDO tFloorGoods = tFloorGoodsService.get(id);
        model.addAttribute("tFloorGoods", tFloorGoods);
        return "shop/tFloorGoods/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    // @RequiresPermissions("shop:tFloorGoods:add")
    public R save(TFloorGoodsDO tFloorGoods) {
        if (tFloorGoodsService.save(tFloorGoods) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    // @RequiresPermissions("shop:tFloorGoods:edit")
    public R update(TFloorGoodsDO tFloorGoods) {
        tFloorGoodsService.update(tFloorGoods);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    // @RequiresPermissions("shop:tFloorGoods:remove")
    public R remove(Long id) {
        if (tFloorGoodsService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    // @RequiresPermissions("shop:tFloorGoods:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tFloorGoodsService.batchRemove(ids);
        return R.ok();
    }

}
