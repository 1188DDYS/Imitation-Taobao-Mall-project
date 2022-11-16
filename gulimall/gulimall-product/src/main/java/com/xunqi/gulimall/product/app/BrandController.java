package com.xunqi.gulimall.product.app;

import com.xunqi.common.utils.PageUtils;
import com.xunqi.common.utils.R;
import com.xunqi.common.valid.AddGroup;
import com.xunqi.common.valid.UpdateGroup;
import com.xunqi.common.valid.UpdateStatusGroup;
import com.xunqi.gulimall.product.entity.BrandEntity;
import com.xunqi.gulimall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 品牌
 *
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:00:18
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    //@Validated({AddGroup.class})说明开启相应的校验功能
    //AddGroup.class检验谁，就是被识别的操作
    //BindingResult result会封装错误的信息
    //如果没有写BindingResult result，错误的信息会被抛出去，
    //从而被controlleradvice接收然后统一进行异常处理
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand
            //, BindingResult result
    ){

        //以下是详细的内容----controlleradvice可以提供统一的异常处理---从而代码解耦化---方便
        // Map<String,String> map = new HashMap<>();
        //
        // if (result.hasErrors()) {
        //     //获取效验错误结果---每一个
        //     result.getFieldErrors().forEach((item)-> {
        //         //获取到错误提示
        //         String message = item.getDefaultMessage();
        //         //获取错误的属性的名字
        //         String field = item.getField();
        //         map.put(field,message);
        //         key-value的形式
        //     });
        //     return R.error(400,"提交的数据不合法").put("data",map);
        // } else {
        //
        // }


        //此时的主题内容只考虑正常的业务逻辑
        //抛出的异常被controlleradvice处理
        brandService.save(brand);


        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody BrandEntity brand){
		brandService.updateDetail(brand);

        return R.ok();
    }

    /**
     * 修改状态
     */
    @RequestMapping("/update/status")
    //@RequiresPermissions("product:brand:update")
    public R updateStatus(@Validated(UpdateStatusGroup.class) @RequestBody BrandEntity brand){
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
