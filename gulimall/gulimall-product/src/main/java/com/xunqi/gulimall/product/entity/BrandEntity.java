package com.xunqi.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xunqi.common.valid.AddGroup;
import com.xunqi.common.valid.ListValue;
import com.xunqi.common.valid.UpdateGroup;
import com.xunqi.common.valid.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:00:18
 *
 * import javax.validation.constraints.*;
 * 专门进行校验的包
 * 无论是前端还是后端，都需要数据的审查，确保任何途径得到的数据是正确的
 * 在相应的控制器方法中也需要表明是需要检验的---因为这个注解是默认不启动的
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 *使用各种检验的注解
	 * message = "修改必须指定品牌id"
	 * message中说明检验错误所返回的信息
	 * groups声明从属于哪个校验，由于不同的业务逻辑的检验方法是不一致的
	 * groups类型的数组，元素是接口，接口的实现在
	 * D:\workspace\gulimall\gulimall-common\src\main\java\com\xunqi\common\valid\AddGroup.java
	 */
	//修改的时候---UpdateGroup.class---什么情况下需要校验---只是一个空接口(不用实现)
	@NotNull(message = "修改必须指定品牌id",groups = {UpdateGroup.class})
	//新增的时候
	@Null(message = "新增不能指定id",groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 * @NotBlank
	 * 至少一个非空字段
	 *
	 * message = "品牌名必须提交"提示的信息
	 */
	@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(groups = {AddGroup.class})
	@URL(message = "logo必须是一个合法的url地址",groups={AddGroup.class,UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 * 自定义检验功能
	 * 1自定义校验注解
	 * 2自定义校验器
	 * 3关联自定义注解和自定义校验器
	 */
//	@Pattern()
	@NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
	//自定义校验注解@ListValue
	//自定义校验器ListValue---地址在
	//D:\workspace\gulimall\gulimall-common\src\main\java\com\xunqi\common\valid\ListValue.java
	@ListValue(vals={0,1},groups = {AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 * 自己定义的firstLetter可以用特殊的regexp="^[a-zA-Z]$"正则表达式来检验---@Pattern
	 */
	@NotEmpty(groups={AddGroup.class})
	@Pattern(regexp="^[a-zA-Z]$",message = "检索首字母必须是一个字母",groups={AddGroup.class,UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups={AddGroup.class})
	@Min(value = 0,message = "排序必须大于等于0",groups={AddGroup.class,UpdateGroup.class})
	private Integer sort;

}
