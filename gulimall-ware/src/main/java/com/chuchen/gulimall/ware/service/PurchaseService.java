package com.chuchen.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chuchen.common.utils.PageUtils;
import com.chuchen.gulimall.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 11:56:44
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

