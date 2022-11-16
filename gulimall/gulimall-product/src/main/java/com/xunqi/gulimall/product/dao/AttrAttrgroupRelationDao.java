package com.xunqi.gulimall.product.dao;

import com.xunqi.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性&属性分组关联
 * 通过mabattis组件实现dao层---声明了AttrAttrgroupRelationEntity是需要和数据库进行交互的
 * 基本的增删改查的功能是通过组件完成的---进一步的功能通过具体的声明deleteBatchRelation完成
 * 相应的SQL实现在mapper文件中完成
 * 
 * @author 夏沫止水
 * @email HeJieLin@gulimall.com
 * @date 2020-05-22 19:00:18
 */
@Mapper
public interface AttrAttrgroupRelationDao extends BaseMapper<AttrAttrgroupRelationEntity> {

    void deleteBatchRelation(@Param("entities") List<AttrAttrgroupRelationEntity> entities);
}
