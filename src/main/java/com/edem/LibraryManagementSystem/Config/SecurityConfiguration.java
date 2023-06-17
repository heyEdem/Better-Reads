package com.edem.LibraryManagementSystem.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user_admin").password("{{noop}}1234").roles(UserRole.ADMIN.name())
                .and().withUser("user_publisher").password("{{noop}}123").roles(UserRole.PUBLISHER.name())
                .and().withUser("user_read_only").password("{{noop}}123").roles(UserRole.READ_ONLY.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
