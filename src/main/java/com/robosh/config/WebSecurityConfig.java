package com.robosh.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/taxi-kyiv")
                .permitAll()
                .antMatchers("/taxi-kyiv/register-client").anonymous()
                .antMatchers("/taxi-kyiv/client-account/**").hasAuthority("CLIENT")
                .antMatchers("/taxi-kyiv/driver-account/**").hasAuthority("DRIVER")
                .antMatchers("/*")
                .authenticated()
                    .and()
                .csrf().disable()
                .formLogin()
                .loginPage("/taxi-kyiv/login")
                .defaultSuccessUrl("/taxi-kyiv", true)
                .failureUrl("/taxi-kyiv/login?error=true")
                .permitAll()
                    .and()
                .logout()
                .logoutSuccessUrl("/taxi-kyiv")
                    .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/taxi-kyiv/access-denied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select phone_number, password, true from person where phone_number=?")
                .authoritiesByUsernameQuery("select phone_number, role from person where phone_number=?");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web
            .ignoring()
            .antMatchers("/css/**", "/img/**", "/js/**", "/errors/**");
    }
}
