package com.chuchen.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chuchen.common.utils.PageUtils;
import com.chuchen.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 09:55:01
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

