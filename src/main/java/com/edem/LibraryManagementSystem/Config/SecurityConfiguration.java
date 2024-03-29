//package com.edem.LibraryManagementSystem.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
////    @Bean
////    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
////        http
////                .authorizeHttpRequests((requests)->requests
////                        .requestMatchers("/login").permitAll()
////                        .anyRequest().authenticated()
////                )
////                .formLogin((form)->form
////                        .loginPage("/login")
////                        .permitAll()
////                )
////                .logout((logout)-> logout.permitAll());
////        return http.build();
////    }
////
////
////    @Bean
////    public UserDetailsService userDetailsService(){
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("admin")
////                        .password("1234")
////                        .roles("ADMIN")
////                        .build();
////
////        return new InMemoryUserDetailsManager(user);
////    }
//
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
//                .formLogin().loginPage("/login")
//                .permitAll();
//    }
//
//
//}
