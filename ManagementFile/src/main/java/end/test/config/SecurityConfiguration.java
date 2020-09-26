package end.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import end.test.service.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http        	
        .csrf().disable()
    	.headers()
    		.frameOptions().sameOrigin()
    		.and()
                .authorizeRequests()
                    .antMatchers(
                            "/registration**",
                            "/js/**",
                            "/css/**",
                            "/img/**",
                            "/webjars/**",
                            "/assets/**").permitAll()
                    //.antMatchers(HttpMethod.GET, "/api/user/**").hasRole("USER")
                    //.antMatchers(HttpMethod.POST, "/api/user/**").hasRole("USER").antMatchers(HttpMethod.PUT, "/api/user/**")
    				//.hasRole("USER").antMatchers(HttpMethod.PATCH, "/api/user/**").hasRole("USER")
    				//.antMatchers(HttpMethod.DELETE, "/api/user/**").hasRole("USER").and().csrf().disable().formLogin()
                  .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                            .permitAll()
                            . usernameParameter("username")
                            . passwordParameter("password")
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
