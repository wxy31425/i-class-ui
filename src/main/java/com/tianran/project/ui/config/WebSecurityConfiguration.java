package com.tianran.project.ui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/service/fileserves/**").permitAll()
                .antMatchers("/service/discipline/**").permitAll()
                .antMatchers("/service/business/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/styles/**").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/workspace/**").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionFixation().migrateSession()
                .maximumSessions(1).expiredUrl("/login").sessionRegistry(sessionRegistry()).and()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and().logout().logoutUrl("/signout").permitAll();

    }

    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

}

