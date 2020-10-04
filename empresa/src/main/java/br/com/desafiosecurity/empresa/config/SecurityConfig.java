package br.com.desafiosecurity.empresa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		        .usersByUsernameQuery("select usuario, senha, habilitado from usuarios where usuario = ?")
		        .authoritiesByUsernameQuery("select usuario, papel from usuarios where usuario = ?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/clientes/**").permitAll()
		        .antMatchers(HttpMethod.POST, "/clientes/**").hasAnyRole("FUNC", "GERN")
		        .antMatchers(HttpMethod.PUT, "/clientes/**").hasAnyRole("FUNC", "GERN")
		        .antMatchers(HttpMethod.DELETE, "/clientes/**").hasAnyRole("FUNC", "GERN").antMatchers("/pedidos/**")
		        .hasAnyRole("FUNC", "GERN").antMatchers(HttpMethod.GET, "/ponto/**").hasAnyRole("FUNC", "GERN")
		        .antMatchers(HttpMethod.POST, "/ponto").hasAnyRole("FUNC", "GERN")
		        .antMatchers(HttpMethod.GET, "/produtos/**").permitAll().antMatchers(HttpMethod.POST, "/produtos/**")
		        .hasAnyRole("FUNC", "GERN").antMatchers(HttpMethod.PUT, "/produtos/**").hasAnyRole("FUNC", "GERN")
		        .antMatchers(HttpMethod.DELETE, "/produtos/**").hasAnyRole("FUNC", "GERN")
		        .antMatchers(HttpMethod.GET, "/funcionarios/**").hasAnyRole("FUNC", "GERN")
		        .antMatchers(HttpMethod.POST, "/funcionarios/**").hasRole("GERN")
		        .antMatchers(HttpMethod.PUT, "/funcionarios/**").hasRole("GERN")
		        .antMatchers(HttpMethod.DELETE, "/funcionarios/**").hasRole("GERN").and().httpBasic();
		super.configure(http);
	}
}