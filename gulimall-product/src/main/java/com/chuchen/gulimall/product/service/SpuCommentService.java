package com.chuchen.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chuchen.common.utils.PageUtils;
import com.chuchen.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 09:55:01
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

