package com.mozii.server;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mall
 */
public interface ISysUserService extends IService<SysUser> {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	SysUser selectByUsername(String username);
//	/**
//	 * 根据手机号查询用户
//	 * @param mobile
//	 * @return
//	 */
//	SysUser selectByMobile(String mobile);
//	/**
//	 * 根据openId查询用户
//	 * @param openId
//	 * @return
//	 */
//	SysUser selectByOpenId(String openId);
//
//	/**
//	 * 用户分配角色
//	 * @param id
//	 * @param roleIds
//	 */
//	void setRoleToUser(Long id, Set<Long> roleIds);
//
//
//
//
//	/**
//	 * 保存用户
//	 *
//	 * @param users
//	 */
//	void saveUsers(List<SysUser> users);
//
//	boolean saves(SysUser entity);
//
//	boolean updates(Long id, SysUser admin);
}
