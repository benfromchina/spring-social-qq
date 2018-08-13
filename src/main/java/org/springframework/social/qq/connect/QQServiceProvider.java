package org.springframework.social.qq.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.qq.api.QQApi;
import org.springframework.social.qq.api.impl.QQApiImpl;

/**
 * QQ 的 OAuth2 服务提供商实现。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQApi> {

	private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize";

	private static final String ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";

	private String appId;
	
	public QQServiceProvider(String appId, String appSecret) {
		super(new QQOAuth2Template(appId, appSecret, AUTHORIZE_URL, ACCESS_TOKEN_URL));
		this.appId = appId;
	}

	@Override
	public QQApi getApi(String accessToken) {
		return new QQApiImpl(accessToken, appId);
	}

}
