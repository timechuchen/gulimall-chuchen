package com.chuchen.gulimall.product.dao;

import com.chuchen.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 09:55:01
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
