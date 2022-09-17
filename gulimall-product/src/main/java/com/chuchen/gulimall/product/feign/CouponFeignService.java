package com.chuchen.gulimall.product.feign;

import com.chuchen.common.to.SkuReductionTo;
import com.chuchen.common.to.SpuBoundTo;
import com.chuchen.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author chuchen
 * @Date 2022/9/17
 * @Description 远程调用优惠券模块
 */

@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @PostMapping("coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
