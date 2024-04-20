package fams.config;

import fams.config.filters.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private String[] swaggerAntPatterns = { "/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
            "/configuration/security", "/swagger-ui.html", "/webjars/**" };

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(swaggerAntPatterns);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/user/update-user","/api/user/**","/api/user/create","/api/userPermission/**","/api/syllabus/**","/upload","/trainingProgram/**" ).permitAll()
                .antMatchers("/product/*", "/department/*").hasAnyAuthority("SUPPER ADMIN")
                .antMatchers("/product/getall", "/product/get/*", "/department/getall", "/department/get/*")
                .hasAnyAuthority("CUSTOMER")
                // Need authentication.
                .anyRequest().authenticated().and()
                //
                // Add Filter - JWTAuthenticationFilter
                //
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
