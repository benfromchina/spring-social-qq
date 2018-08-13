package org.springframework.social.qq.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.qq.api.QQApi;

/**
 * QQ 的 OAuth2 连接工厂。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQApi> {

	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQApiAdapter());
	}

}
