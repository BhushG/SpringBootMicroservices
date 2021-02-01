package com.security.springboot.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //this tells spring that this is web security configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

    /**
     * AuthenticationManagerBuilder is used to configure authentication mechanism
     *
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication().withUser("bhush").password("pass").roles("USER");
    }

    /**
     *Expose Bean of type PasswordEncoder to Spring Boot so that it will encode passwords using this bean
     */
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Authorization implementation based on roles
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeRequests().antMatchers("/").hasRole("USER");
        httpSecurity.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");
        httpSecurity.authorizeRequests().antMatchers("/user").hasRole("USER");
    }
}
