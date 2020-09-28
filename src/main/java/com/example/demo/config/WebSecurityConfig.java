package com.example.demo.config;

import com.example.demo.entity.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //Pages do not require login
        http.authorizeRequests().antMatchers("/", "/signup", "login", "logout").permitAll();

        http.authorizeRequests().antMatchers("/userinfo").access("hasRole('" + AppRole.ROLE_USER + "')");
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin").access("hasRole('" + AppRole.ROLE_ADMIN + "')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

//    Form login config
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/userInfo")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password");

//        Logout Config
        http.authorizeRequests()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

        http.apply(new SpringSocialConfigurer())
                .signupUrl("/signup");

    }
//    This bean is load the user specific data when form login is used
    @Override
    public UserDetailsService userDetailsService(){
        return userDetailsService;
    }
}
