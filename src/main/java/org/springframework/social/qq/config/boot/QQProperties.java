package org.springframework.social.qq.config.boot;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * QQ 的 OAuth2 配置项。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "spring.social.qq")
public class QQProperties extends SocialProperties {
	
	/**
	 * 服务提供商标识
	 */
	private String providerId = "qq";
	
	/**
	 * UserConnection 表前缀
	 */
	private String tablePrefix;
	
	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getTablePrefix() {
		return tablePrefix;
	}

	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}
	
}
