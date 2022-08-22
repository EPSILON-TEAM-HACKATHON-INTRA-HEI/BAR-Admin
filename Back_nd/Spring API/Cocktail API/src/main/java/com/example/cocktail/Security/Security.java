package com.example.cocktail.Security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@Slf4j

public class Security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers( HttpMethod.GET ,"/cocktails/").permitAll()
                .antMatchers(HttpMethod.GET, "categories/**").hasRole("admin")
                .antMatchers(HttpMethod.GET,"drinks/**").hasRole("admin")
                .antMatchers(HttpMethod.GET,"compositions/**").hasRole("admin")
                .antMatchers(HttpMethod.POST,"**/**").hasRole("admin")
                .antMatchers(HttpMethod.PATCH,"**/**").hasRole("admin")
                .antMatchers(HttpMethod.DELETE,"**/**").hasRole("admin")
                .and()
                .formLogin()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(getPasswordEncoder().encode("admin"))
                .roles("admin")
                .build();


        log.info("Admin with Bcrypt : "+admin.getPassword());
        return new InMemoryUserDetailsManager(admin);
    }
}
