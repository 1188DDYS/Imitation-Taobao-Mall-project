package com.xunqi.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description: 自定义注解规则JSR303
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-05-27 17:48
 **/

@Documented
@Constraint(validatedBy = { ListValueConstraintValidator.class })
//这个组件的实现就在这个文件的下方---产生注解和校验器的关联
//可以使用多个校验器进行检验
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
//说明可以标记在哪里
@Retention(RUNTIME)
//有效范围
public @interface ListValue {

    //错误信息从哪里获得---就是提示的错误message
    String message() default "{com.xunqi.common.valid.ListValue.message}";
    //D:\workspace\gulimall\gulimall-common\src\main\resources\ValidationMessages.properties

    //分组信息
    Class<?>[] groups() default { };

    //负载信息
    Class<? extends Payload>[] payload() default { };

    //以上是自定义校验器的基本组件

    int[] vals() default { };

}
