package org.springframework.social.qq.api;

/**
 * QQ 的 OAuth2 接口。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
public interface QQApi {
	
	/**
	 * 获取 QQ 用户信息。
	 * @return QQ 用户信息。
	 */
	QQUserInfo getUserInfo();
	
}
