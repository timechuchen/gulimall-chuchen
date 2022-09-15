package com.chuchen.gulimall.product.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author chuchen
 * @Date 2022/9/15
 * @Description 属性响应类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVo extends AttrVo{
    /**
     * 分类名
     */
    private String catelogName;

    /**
     * 分组名字
     */
    private String groupName;

    /**
     * 路径
     */
    private Long[] catelogPath;
}
