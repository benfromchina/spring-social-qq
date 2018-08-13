package org.springframework.social.qq.api.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.social.qq.api.QQApi;
import org.springframework.social.qq.api.QQUserInfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * QQ 的 OAuth2 接口实现。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
public class QQApiImpl extends AbstractOAuth2ApiBinding implements QQApi {
	
	private static final String OPENID_URL = "https://graph.qq.com/oauth2.0/me?access_token=%s";
	
	private static final String USERINFO_URL = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	
	private String appId;
	
	private String openId;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public QQApiImpl(String accessToken, String appId) {
		super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
		
		this.appId = appId;
		this.openId = getOpenId(accessToken);
		
	}

	@Override
	public QQUserInfo getUserInfo() {
		String url = String.format(USERINFO_URL, appId, openId);
		String result = this.getRestTemplate().getForObject(url, String.class);
		
		try {
			QQUserInfo userInfo = objectMapper.readValue(result, QQUserInfo.class);
			userInfo.setOpenId(openId);
			return userInfo;
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息失败", e);
		}
	}
	
	private String getOpenId(String accessToken) {
		String url = String.format(OPENID_URL, accessToken);
		String result = this.getRestTemplate().getForObject(url, String.class);
		String jsonCallback = "{" + StringUtils.substringBetween(result, "{", "}") + "}";
		try {
			JsonNode json = objectMapper.readTree(jsonCallback);
			String openId = json.get("openid").asText();
			return openId;
		} catch (Exception e) {
			throw new RuntimeException("获取 openid 失败", e);
		}
	}
	
}
