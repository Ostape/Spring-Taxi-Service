package com.robosh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/css/**", "/img/**", "/taxi-kyiv",
                            "/taxi-kyiv/register-client", "?lang=ua", "?lang=en").permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/taxi-kyiv/login")
                    .loginProcessingUrl("/taxi-kyiv/perform_login")
                    .defaultSuccessUrl("/taxi-kyiv/driver-account",true)
                    .defaultSuccessUrl("/taxi-kyiv/client-account",true)
                    .failureUrl("/taxi-kyiv/login?error=true")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/taxi-kyiv")
                    .permitAll();
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select username, password,");
//        //todo
//    }
//}
@Bean
@Override
public UserDetailsService userDetailsService() {
    UserDetails user =
            User.withDefaultPasswordEncoder()
                    .username("u")
                    .password("p")
                    .roles("USER")
                    .build();

    return new InMemoryUserDetailsManager(user);
}
}