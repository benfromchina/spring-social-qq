package org.springframework.social.qq.config.boot;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.qq.connect.QQConnectionFactory;
import org.springframework.social.qq.support.QQConnectedView;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.web.servlet.View;

/**
 * Spring Boot 项目中自动化配置 QQ OAuth2 。
 * @author Ben
 * @since 1.0.0
 * @version 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.social.qq", name = { "app-id", "app-secret" })
@EnableConfigurationProperties(QQProperties.class)
public class QQAutoConfiguration extends SocialAutoConfigurerAdapter {
	
	@Autowired
	private QQProperties qqProperties;
	
	@Autowired(required = false)
	private ConnectionSignUp connectionSignUp;
	
	@Value("${spring.social.table-prefix:}")
	private String tablePrefix;
	
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		return new QQConnectionFactory(qqProperties.getProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
	}
	
	@Bean
	@ConditionalOnMissingBean(SpringSocialConfigurer.class)
	@Description("社交登录拦截器")
	public SpringSocialConfigurer springSocialConfigurer() {
		return new SpringSocialConfigurer();
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "spring.social.qq", name = "users-connection-repository", havingValue = "true", matchIfMissing = true)
	@ConditionalOnBean({ DataSource.class, ConnectionFactoryLocator.class })
	@Description("社交连接工厂，用于社交账户的增删改查")
	public UsersConnectionRepository usersConnectionRepository(DataSource dataSource, ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
		// 支持静默注册
		if (connectionSignUp != null) {
			jdbcUsersConnectionRepository.setConnectionSignUp(connectionSignUp);
		}
		// 支持自定义表前缀
		if (!StringUtils.isBlank(tablePrefix)) {
			jdbcUsersConnectionRepository.setTablePrefix(tablePrefix);
		} else if (!StringUtils.isBlank(qqProperties.getTablePrefix())) {
			jdbcUsersConnectionRepository.setTablePrefix(qqProperties.getTablePrefix());
		}
		return jdbcUsersConnectionRepository;
	}
	
	@Bean
	@ConditionalOnMissingBean(ProviderSignInUtils.class)
	@ConditionalOnBean({ ConnectionFactoryLocator.class, UsersConnectionRepository.class })
	@Description("从 session 中获取社交用户信息、保存社交用户到数据库")
	public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository) {
		return new ProviderSignInUtils(connectionFactoryLocator, usersConnectionRepository);
	}
	
	@Bean("/connect/qqConnected")
	@ConditionalOnMissingBean(name = "qqConnectedView")
	@Description("QQ 登录绑定成功视图")
	public View qqConnectedView() {
		return new QQConnectedView();
	}
	
}
