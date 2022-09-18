package com.chuchen.gulimall.ware.vo;

import lombok.Data;

/**
 * @Author chuchen
 * @Date 2022/9/18
 * @Description 采购完成信息
 */
@Data
public class PurchaseItemDoneVo {
    private Long itemId;
    private Integer status;
    private String reason;
}
