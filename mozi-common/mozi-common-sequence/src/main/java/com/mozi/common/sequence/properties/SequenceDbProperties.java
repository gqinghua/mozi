package com.mozi.common.sequence.properties;

/**

 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * <p>
 * 发号器DB配置属性
 */

@Component
@ConfigurationProperties(prefix = "mozi.xsequence.db")
public class SequenceDbProperties extends BaseSequenceProperties {
	/**
	 * 表名称
	 */
	private String tableName;
	/**
	 * 重试次数
	 */
	private int retryTimes;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}
}