package com.chuchen.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chuchen.common.utils.PageUtils;
import com.chuchen.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 09:55:01
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);
}

