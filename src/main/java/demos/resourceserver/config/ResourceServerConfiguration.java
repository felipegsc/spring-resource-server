package demos.resourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration {

	@Bean
	public ResourceServerTokenServices tokenService(@Value("${oauth2.client-id}") String clientId,
			@Value("${oauth2.client-secret}") String clientSecret,
			@Value("${oauth2.check-token-endpoint}") String checkTokenEndpoint) {
		RemoteTokenServices service = new RemoteTokenServices();
		service.setClientId(clientId);
		service.setClientSecret(clientSecret);
		service.setCheckTokenEndpointUrl(checkTokenEndpoint);
		return service;
	}

	@Bean
	public ResourceServerConfigurer resourceServerConfigurer() {
		return new ResourceServerConfigurerAdapter() {

			@Override
			public void configure(HttpSecurity http) throws Exception {
				http
					.authorizeRequests()
						.antMatchers("/hello-admin").hasRole("ADMIN")
						.antMatchers("/hello-user").hasAnyRole("ADMIN", "USER")
					.anyRequest()
						.authenticated();
			}

		};
	}

}
