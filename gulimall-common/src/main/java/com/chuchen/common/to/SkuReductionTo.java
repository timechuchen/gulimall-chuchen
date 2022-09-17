package com.chuchen.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author chuchen
 * @Date 2022/9/17
 * @Description sku 优惠信息
 */
@Data
public class SkuReductionTo {

    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;

    private List<com.chuchen.common.to.MemberPrice> memberPrice;

}
