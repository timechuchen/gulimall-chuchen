package com.chuchen.gulimall.member.feign;

import com.chuchen.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author chuchen
 * @Date 2022/9/7
 * @Description 远程调用接口
 */

@FeignClient("gulimall-coupon") //要调用那个功能
public interface CouponFeignService {
    @RequestMapping("coupon/coupon/member/list")
    R membercoupons();
}
