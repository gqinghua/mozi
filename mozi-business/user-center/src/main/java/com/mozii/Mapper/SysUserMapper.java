package com.mozii.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper 接口
 *
 * @author mall
 * @data 2018-10-29
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
//    List<SysUser> findList(Page<SysUser> page, @Param("u") Map<String, Object> params);
}
