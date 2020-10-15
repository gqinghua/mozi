package com.mozi.NacosConsumer.config;

import cn.hutool.core.date.DateUtil;
import com.mozi.common.sequence.builder.DbSeqBuilder;
import com.mozi.common.sequence.builder.RedisSeqBuilder;
import com.mozi.common.sequence.builder.SnowflakeSeqBuilder;
import com.mozi.common.sequence.properties.SequenceDbProperties;
import com.mozi.common.sequence.properties.SequenceRedisProperties;
import com.mozi.common.sequence.properties.SequenceSnowflakeProperties;
import com.mozi.common.sequence.range.impl.name.DateBizName;
import com.mozi.common.sequence.sequence.Sequence;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**

 * @date 2019-05-26
 * <p>
 * 设置发号器生成规则
 */
@Configuration
public class SequenceConfig {

//	/**
//	 * 订单流水号发号器
//	 *
//	 * @param dataSource
//	 * @param properties
//	 * @return
//	 */
//	@Bean
//	public Sequence dbSequence(DataSource dataSource,
//								SequenceDbProperties properties) {
//		return DbSeqBuilder
//				.create()
//				.bizName(() -> String.format("pay_%s_%s"), TenantContextHolder.getTenantId(), DateUtil.today())
//				.dataSource(dataSource)
//				.step(properties.getStep())
//				.retryTimes(properties.getRetryTimes())
//				.tableName(properties.getTableName())
//				.build();
//	}

	@Bean
	public Sequence paySequence(DataSource dataSource,
								SequenceDbProperties properties) {
		return DbSeqBuilder
				.create()
				.bizName(() -> String.format("pay_%s_%s", TenantContextHolder.getTenantId(), DateUtil.today()))
				.dataSource(dataSource)
				.step(properties.getStep())
				.retryTimes(properties.getRetryTimes())
				.tableName(properties.getTableName())
				.build();
	}

	@Bean
	public Sequence channelSequence(DataSource dataSource,
									SequenceDbProperties properties) {
		return DbSeqBuilder
				.create()
				.bizName(() -> String.format("channel_%s"))
				.dataSource(dataSource)
				.step(properties.getStep())
				.retryTimes(properties.getRetryTimes())
				.tableName(properties.getTableName())
				.build();
	}

	/**
	 * 通道编号发号器
	 *
	 * @param dataSource
	 * @param properties
	 * @return
	 */
	/**
	 * Redis 作为发号器的存储介质
	 *
	 * @param redisProperties
	 * @param properties
	 * @return
	 */
	@Bean
	public Sequence redisSequence(RedisProperties redisProperties,
								  SequenceRedisProperties properties) {
		return RedisSeqBuilder
				.create()
				.bizName(new DateBizName(properties.getBizName()))
				.ip(redisProperties.getHost())
				.port(redisProperties.getPort())
				.auth(redisProperties.getPassword())
				.step(properties.getStep())
				.build();
	}

	@Bean
	public Sequence snowflakeSequence(SequenceSnowflakeProperties properties) {
		return SnowflakeSeqBuilder
				.create()
				.datacenterId(properties.getDatacenterId())
				.workerId(properties.getWorkerId())
				.build();
	}
}
