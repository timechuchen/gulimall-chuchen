package com.chuchen.gulimall.order.dao;

import com.chuchen.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 11:50:35
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
