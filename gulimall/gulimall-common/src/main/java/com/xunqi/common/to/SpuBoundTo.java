package com.xunqi.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-01 08:45
 **/

@Data
public class SpuBoundTo {
    //相应的传输数据组成

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;

}
