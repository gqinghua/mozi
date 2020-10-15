package com.mozii.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mozii.Mapper.SysUserMapper;
import com.mozii.server.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: mozi
 * @ClassName ISysUserServiceImpl
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-07-09 18:32
 **/
@Service
public class ISysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectByUsername(String username) {
        return sysUserMapper.selectById(1);
    }
}
