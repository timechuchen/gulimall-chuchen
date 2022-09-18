package com.chuchen.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author chuchen
 * @Date 2022/9/18
 * @Description 合并采购单数据
 */
@Data
public class MergeVo {
    private Long purchaseId;
    private List<Long> items;
}
