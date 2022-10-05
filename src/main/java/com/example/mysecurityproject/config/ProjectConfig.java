package com.example.mysecurityproject.config;

import com.example.mysecurityproject.security.AppUserDetailsManager;
import com.example.mysecurityproject.security.PlainTextPasswordEncoder;
import com.example.mysecurityproject.security.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PlainTextPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(){
        AppUserDetailsManager manager = new AppUserDetailsManager();
        manager.createUser(new User("test","test"));
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
