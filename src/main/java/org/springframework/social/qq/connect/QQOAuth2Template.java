package org.springframework.social.qq.connect;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * QQ 的 OAuth2 请求模板。 
 * <p>由于 QQ 获取 accessToken 时，返回的结果不是 json 格式，而是 html ，需做如下处理：
 * <ul>
 * <li>创建 {@link RestTemplate} 时添加 text/html 响应的解析器 {@link StringHttpMessageConverter} ；</li>
 * <li>自行解析响应结果中的参数，并根据参数创建新的 {@link AccessGrant} 。</li>
 * </ul>
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
public class QQOAuth2Template extends OAuth2Template {
	
	public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
		// 设置请求时附带 client_id 和 client_secret 参数
		this.setUseParametersForClientAuthentication(true);
	}
	
	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = super.createRestTemplate();
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return restTemplate;
	}
	
	@Override
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		String paramStr = this.getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
		String[] params = paramStr.split("&");
		String accessToken = StringUtils.substringAfter(params[0], "=");
		Long expiresIn = Long.parseLong(StringUtils.substringAfter(params[1], "="));
		String refreshToken = StringUtils.substringAfter(params[2], "=");
		
		AccessGrant accessGrant = new AccessGrant(accessToken, null, refreshToken, expiresIn);
		return accessGrant;
	}
	
}
