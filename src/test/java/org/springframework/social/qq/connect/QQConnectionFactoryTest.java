package org.springframework.social.qq.connect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.qq.api.QQUserInfo;

public class QQConnectionFactoryTest {
	
	private static final String APP_ID = "{YOUR APPLICATION APP_ID}";
	
	private static final String APP_SECRET = "{YOUR APPLICATION APP_KEY}";
	
	private static final String CODE = "{YOUR AUTHORIZATION_CODE}";
	
	private static final String REDIRECT_URL = "{YOUR REDIRECT_URL}";
	
	@Test
	public void testQQConnectionFactory() {
		QQConnectionFactory connectionFactory = new QQConnectionFactory("qq", APP_ID, APP_SECRET);
		AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(CODE, REDIRECT_URL, null);
		
		QQUserInfo userInfo = connectionFactory.createConnection(accessGrant).getApi().getUserInfo();
		assertEquals(0, userInfo.getRet().intValue());
	}

}
