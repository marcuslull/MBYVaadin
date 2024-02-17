package com.marcuslull.mbyvaadin.config;

import com.marcuslull.mbyvaadin.view.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends VaadinWebSecurity {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Spring security config with Vaadin integration
        http.authorizeHttpRequests(auth -> auth.requestMatchers(AntPathRequestMatcher
                .antMatcher(HttpMethod.GET, "/images/*.png")).permitAll());
        super.configure(http);
        setLoginView(http, LoginView.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
