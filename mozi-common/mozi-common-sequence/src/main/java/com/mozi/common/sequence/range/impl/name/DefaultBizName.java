package com.mozi.common.sequence.range.impl.name;

import com.mozi.common.sequence.range.BizName;

/**
 * @author
 * @date
 * 根据传入返回bizname
 */

public class DefaultBizName implements BizName {

	private String bizName;

	/**
	 * 生成空间名称
	 */
	@Override
	public String create() {
		return bizName;
	}

	public DefaultBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
}
