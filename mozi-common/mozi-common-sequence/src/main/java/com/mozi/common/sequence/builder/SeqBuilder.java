package com.mozi.common.sequence.builder;


import com.mozi.common.sequence.sequence.Sequence;

/**
 * 序列号生成器构建者
 * @author
 */
public interface SeqBuilder {

	/**
	 * 构建一个序列号生成器
	 *
	 * @return 序列号生成器
	 */
	Sequence build();

}
