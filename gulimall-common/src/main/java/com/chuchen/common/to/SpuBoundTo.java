package com.chuchen.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author chuchen
 * @Date 2022/9/17
 * @Description 模块间用于传输优惠券的对象模型
 */
@Data
public class SpuBoundTo {

    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;

}
