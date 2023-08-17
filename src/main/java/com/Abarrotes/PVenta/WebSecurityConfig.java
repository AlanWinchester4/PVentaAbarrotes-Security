package com.Abarrotes.PVenta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Abarrotes.PVenta.Services.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig
{

   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(Customizer.withDefaults()).authorizeHttpRequests(authorize -> authorize
        		
        		.requestMatchers("/views/productos/").permitAll()
        		.requestMatchers("/views/productos/VCrear").hasRole("ADMIN")        		
        		
        		.anyRequest().authenticated())
        
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());
        
        return http.build();
    }
    @Bean
    UserDetailsServiceImpl userDetailsService()
    {
    	return new UserDetailsServiceImpl();
    }
    @Bean 
    PasswordEncoder passwordEncoder()
    {
    	return new BCryptPasswordEncoder();
    }
	/*@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated());
		http.formLogin(WithDefaults());
		http.httpBasic();
		
		return http.build();
	}*/
	/*@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector).servletPath("/path");
        http
            .authorizeHttpRequests((authz) -> authz
            	.requestMatchers(mvcMatcherBuilder.pattern("/views/productos")).permitAll()
                .requestMatchers(mvcMatcherBuilder.pattern("/user")).hasRole("USER")
                .requestMatchers(mvcMatcherBuilder.pattern("/views/productos/VCrear")).hasRole("ADMIN")
                .anyRequest().authenticated()
            );
        return http.build();
	
	/*@Autowired
	public void ConfigurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception
	{
			builder.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passEncoder)
			.usersByUsernameQuery("SELECT nom_user,pass_user, enabled FROM usuarios WHERE nom_user=?")
			.authoritiesByUsernameQuery("SELECT u.nom_user,r.nom_rol FROM roles r INNER JOIN usuarios u ON r.user_id WHERE u.nom_user=?");

	}*/

}
