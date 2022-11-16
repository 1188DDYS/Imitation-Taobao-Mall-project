package com.xunqi.gulimall.member.feign;

import com.xunqi.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-05-30 15:23
 * 调用远程接口@FeignClient()
 * ("gulimall-coupon")调用哪个远程接口
 *
 *
 *     @RequestMapping("/coupon/coupon/member/list")
 *     public R membercoupons();
 * 就是引入相应的方法名称----相应请求的方法（哪个远程服务的哪个请求）---请求的地址写全
 * 从而当前的模块下也能使用相应的membercoupons();方法
 **/



@FeignClient("gulimall-coupon")
//是远程哪里的服务
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    //路径写全
    //调用远程模块中的哪个功能
    //public R membercoupons();是方法的远程签名---就是原方法名
    //CouponFeignService
    //从而未来的模块中可以通过CouponFeignService.membercoupons()的方法来调用该路径方法
    public R membercoupons();

}
