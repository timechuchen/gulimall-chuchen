package com.chuchen.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author chuchen
 * @email 2665300871@qq.com
 * @date 2022-09-07 09:55:01
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */

	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名必须提交") //该字段必须是一个非空格字符
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty
	@URL(message = "logo必须是一个合法的地址")
	private String logo;
	/**
	 * 介绍
	 */
	@NotEmpty
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty
	@Pattern(regexp = "/^[a-zA-Z]$/",message = "检索首字母必须是一个字母")
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull
	@Min(value = 0,message = "排序必须等于大于零")
	private Integer sort;

}
