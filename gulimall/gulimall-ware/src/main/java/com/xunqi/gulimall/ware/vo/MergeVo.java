package com.xunqi.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description:  一些网站的交互数据
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-01 17:04
 **/

@Data
public class MergeVo {

    private Long purchaseId;

    private List<Long> items;

}
