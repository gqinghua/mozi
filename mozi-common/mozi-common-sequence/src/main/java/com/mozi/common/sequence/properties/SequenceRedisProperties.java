package com.mozi.common.sequence.properties;

/**
 *
 */


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @
 * <p>
 * 发号器Redis配置属性
 */

@Component
@ConfigurationProperties(prefix = "mozi.xsequence.redis")
public class SequenceRedisProperties extends BaseSequenceProperties {

}