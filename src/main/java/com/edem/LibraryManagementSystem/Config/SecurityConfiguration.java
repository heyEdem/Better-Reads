package com.edem.LibraryManagementSystem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((requests)->requests
                        .requestMatchers("/", "/api/books/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form)->form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout)-> logout.permitAll());
        return http.build();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("{noop}1234").roles(UserRole.ADMIN.name())
//                .and().withUser("publisher").password("{noop}123").roles(UserRole.PUBLISHER.name())
//                .and().withUser("user").password("{noop}12").roles(UserRole.READ_ONLY.name());
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/delete").hasRole(UserRole.ADMIN.name())
//                .antMatchers("/edit").hasAnyRole(UserRole.ADMIN.name(), UserRole.PUBLISHER.name())
//                .antMatchers("/actuator/**").hasRole(UserRole.ADMIN.name())
//                .antMatchers("/api/books/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }


}
