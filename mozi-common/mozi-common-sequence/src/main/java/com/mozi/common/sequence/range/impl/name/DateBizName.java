package com.mozi.common.sequence.range.impl.name;

import cn.hutool.core.date.DateUtil;
import com.mozi.common.sequence.range.BizName;

/**
 * @author
 * @date
 * <p>
 * 根据时间重置bizname
 */
public class DateBizName implements BizName {
	private String bizName;

	/**
	 * 生成空间名称
	 */
	@Override
	public String create() {
		return bizName + DateUtil.today();
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public DateBizName(String bizName) {
		this.bizName = bizName;
	}

	public DateBizName() {
	}

}