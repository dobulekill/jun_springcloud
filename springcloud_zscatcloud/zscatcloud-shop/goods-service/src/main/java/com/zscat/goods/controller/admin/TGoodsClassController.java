package com.zscat.goods.controller.admin;


import com.zscat.goods.entity.TGoodsClassDO;
import com.zscat.goods.service.TGoodsClassService;
import com.zscatcloud.base.dto.Query;
import com.zscatcloud.base.dto.R;
import com.zscatcloud.base.dto.Tree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 *
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-10-15 15:07:36
 */

@Controller
@RequestMapping("/shop/tGoodsClass")
public class TGoodsClassController {
    @Resource
    private TGoodsClassService tGoodsClassService;


    @GetMapping("/tree")
    @ResponseBody
    public Tree<TGoodsClassDO> tree() {
        Tree<TGoodsClassDO> tree = new Tree<TGoodsClassDO>();
        tree = tGoodsClassService.getTree();
        return tree;
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
        List<TGoodsClassDO> list = tGoodsClassService.list(query);
        int total = tGoodsClassService.count(query);
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
        TGoodsClassDO sysDept = tGoodsClassService.get(id);
        r.put("entity", sysDept);
        return r;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(@RequestBody TGoodsClassDO entity) {

        if (entity.getId() == null) {
            if (tGoodsClassService.save(entity) > 0) {
                return R.ok();
            }
        } else {
            if (tGoodsClassService.update(entity) > 0) {
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
    // @RequiresPermissions("shop:tGoodsClass:edit")
    public R update(TGoodsClassDO tGoodsClass) {
        tGoodsClassService.update(tGoodsClass);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    // @RequiresPermissions("shop:tGoodsClass:remove")
    public R remove(Long id) {
        if (tGoodsClassService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    // @RequiresPermissions("shop:tGoodsClass:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        tGoodsClassService.batchRemove(ids);
        return R.ok();
    }

}
