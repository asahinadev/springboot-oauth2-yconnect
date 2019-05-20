package com.example.spring.yconnect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.spring.yconnect.oauth2.users.CustomOidcUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguig
		extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomOidcUserService customOidcUserService;

	@Override
	protected void configure(HttpSecurity http)
			throws Exception {
		super.configure(http);

		http.authorizeRequests()

				// no authorize area
				.antMatchers("/signin/**").permitAll()
				.antMatchers("/error/**").permitAll()
				.antMatchers("/login/**").permitAll()
				.antMatchers("/oauth2/**").permitAll()

				// css and javascript files
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/**/*.js").permitAll()
				.antMatchers("/**/*.css").permitAll()
				.antMatchers("/**/*.map").permitAll()

				// images files
				.antMatchers("/**/*.png").permitAll()
				.antMatchers("/**/*.gif").permitAll()
				.antMatchers("/**/*.jpg").permitAll()

				// sound files
				.antMatchers("/**/*.wav").permitAll()
				.antMatchers("/**/*.mp3").permitAll()
				.antMatchers("/**/*.m4a").permitAll()
				.antMatchers("/**/*.ogg").permitAll()

				// favicon.ico files
				.antMatchers("/favicon.ico").permitAll()
				.antMatchers("/**/*.ico").permitAll()

				// web fonts files
				.antMatchers("/**/*.otf").permitAll()
				.antMatchers("/**/*.ttf").permitAll()
				.antMatchers("/**/*.woff").permitAll()
				.antMatchers("/**/*.woff2").permitAll()
				.antMatchers("/**/*.eot").permitAll()
				.antMatchers("/**/*.svg").permitAll()

				.anyRequest().authenticated();

		http.formLogin().disable();
		http.logout().disable();

		http.httpBasic().disable();

		http.csrf().disable();

		http.oauth2Login()

				// 認証エンドポイント
				.authorizationEndpoint()
				.and()

				// リダイレクトエンドポイント
				.redirectionEndpoint()
				.and()

				// アクセストークンエンドポイント
				.tokenEndpoint()
				.and()

				// ユーザー情報エンドポイント
				.userInfoEndpoint()
				.oidcUserService(customOidcUserService)
				.and()

				.defaultSuccessUrl("/", true)
				.failureUrl("/error?oauth");

		;

	}

}
