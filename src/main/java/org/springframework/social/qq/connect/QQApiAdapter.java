package org.springframework.social.qq.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.qq.api.QQApi;
import org.springframework.social.qq.api.QQUserInfo;

/**
 * QQ 接口适配器。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
public class QQApiAdapter implements ApiAdapter<QQApi> {

	@Override
	public boolean test(QQApi api) {
		return true;
	}

	@Override
	public void setConnectionValues(QQApi api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();
		
		values.setProviderUserId(userInfo.getOpenId());
		values.setDisplayName(userInfo.getNickname());
		values.setProfileUrl(null);
		values.setImageUrl(userInfo.getFigureurl_qq_1());
	}

	@Override
	public UserProfile fetchUserProfile(QQApi api) {
		return null;
	}

	@Override
	public void updateStatus(QQApi api, String message) {
		// do nothing
	}

}
