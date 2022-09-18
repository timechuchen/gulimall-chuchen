package com.chuchen.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.chuchen.gulimall.product.entity.ProductAttrValueEntity;
import com.chuchen.gulimall.product.service.ProductAttrValueService;
import com.chuchen.gulimall.product.vo.AttrGroupRelationVo;
import com.chuchen.gulimall.product.vo.AttrRespVo;
import com.chuchen.gulimall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chuchen.gulimall.product.entity.AttrEntity;
import com.chuchen.gulimall.product.service.AttrService;
import com.chuchen.common.utils.PageUtils;
import com.chuchen.common.utils.R;

import javax.annotation.PostConstruct;


/**
 * 商品属性
 *
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 10:26:55
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;
    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 查出商品的规格参数
     */
    @GetMapping("/base/listforspu/{spuId}")
    public R listforspu(@PathVariable("spuId") Long spuId) {
        List<ProductAttrValueEntity> entities = productAttrValueService.listforspu(spuId);
        return R.ok().put("data",entities);
    }

    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String, Object> params,@PathVariable("catelogId") Long catelogId,@PathVariable("attrType") String type) {
        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,type);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
        //AttrEntity attr = attrService.getById(attrId);

        AttrRespVo respVo = attrService.getAttrInfo(attrId);

        return R.ok().put("attr", respVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return R.ok();
    }

    @PostMapping("/update/{spuId}")
    //@RequiresPermissions("product:attr:update")
    public R updateSpuAttr(@PathVariable("spuId") Long spuId,@RequestBody List<ProductAttrValueEntity> entities){
        productAttrValueService.updateSpuAttr(spuId,entities);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
