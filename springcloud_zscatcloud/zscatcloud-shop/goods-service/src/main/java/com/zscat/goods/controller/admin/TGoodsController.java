package com.zscat.goods.controller.admin;


import com.zscat.goods.entity.TGoodsDO;
import com.zscat.goods.service.*;
import com.zscatcloud.base.dto.Query;
import com.zscatcloud.base.dto.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */

@Controller
@RequestMapping("/shop/tGoods")
public class TGoodsController {
     @Resource
    private TBrandService tBrandService;
     @Resource
    private TGoodsTypeService tGoodsTypeService;
     @Resource
    private TGoodsService tGoodsService;
     @Resource
    private TGoodsClassService tGoodsClassService;
     @Resource
    private TStoreService tStoreService;

    @GetMapping()
        // @RequiresPermissions("shop:tGoods:tGoods")
    String TGoods() {
        return "shop/tGoods/tGoods";
    }

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
        List<TGoodsDO> list = tGoodsService.list(query);
        int total = tGoodsService.count(query);
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
        TGoodsDO sysDept = tGoodsService.get(id);
        r.put("entity", sysDept);
        return r;
    }


    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    // @RequiresPermissions("shop:tGoods:add")
    public R save(TGoodsDO tGoods, HttpServletRequest request) {
        tGoods.setClickhit(0);
        tGoods.setReplyhit(0);
        tGoods.setSellhit(0);
        tGoods.setCreateDate(new Date());
     //   tGoods.setCreateBy(UserUtils.getLoginUser(request).getUserId());
        String imgMore = tGoods.getImg();
        if (StringUtils.isNoneBlank(tGoods.getImg1())) {
            imgMore = imgMore + "," + tGoods.getImg1();
        }
        if (StringUtils.isNoneBlank(tGoods.getImg2())) {
            imgMore = imgMore + "," + tGoods.getImg2();
        }
        tGoods.setImgmore(imgMore);
        if (tGoodsService.save(tGoods) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    // @RequiresPermissions("shop:tGoods:edit")
    public R update(TGoodsDO tGoods) {
        tGoodsService.update(tGoods);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    // @RequiresPermissions("shop:tGoods:remove")
    public R remove(Long id) {
        if (tGoodsService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    // @RequiresPermissions("shop:tGoods:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tGoodsService.batchRemove(ids);
        return R.ok();
    }

}
