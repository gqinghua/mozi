package com.mozi.common.sequence.properties;


/**

 * <p>
 * 发号器通用属性
 */

class BaseSequenceProperties {
	/**
	 * 获取range步长[可选，默认：1000]
	 */
	private int step = 1000;

	/**
	 * 序列号分配起始值[可选：默认：0]
	 */
	private long stepStart = 0;

	/**
	 * 业务名称
	 */
	private String bizName = "mozi";

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public long getStepStart() {
		return stepStart;
	}

	public void setStepStart(long stepStart) {
		this.stepStart = stepStart;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
}
