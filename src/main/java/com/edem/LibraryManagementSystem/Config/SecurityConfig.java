//package com.edem.LibraryManagementSystem.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//import javax.xml.crypto.Data;
//
//import static org.springframework.security.config.Customizer.*;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Bean
//    EmbeddedDatabase dataSource(){
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .setName("dashboard")
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }
//
//    @Bean
//    JdbcUserDetailsManager users(DataSource dataSource, PasswordEncoder encoder){
//        UserDetails admin = User.builder()
//                .username("Admin")
//                .password(encoder.encode("password"))
//                .roles("ADMIN")
//                .build();
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.createUser(admin);
//        return jdbcUserDetailsManager;
//    }
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf->csrf.ignoringAntMatchers("/h2-console/**"))
//                .authorizeRequests( auth -> auth
//                        .antMatchers("/h2-console/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .headers(headers->headers.frameOptions().sameOrigin())
//                .formLogin(withDefaults())
//                .build();
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
