package com.raceco.apii;

import com.raceco.apii.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        // retrieve builder from httpSecurity
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
     @Autowired
     private MyUserDetailsService myUserDetailsService;

      @Autowired
      AuthenticationProvider authenticationProvider;

     @Autowired
    private JwtRequestFilter jwtRequestFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
               .csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(auth-> auth
                       .requestMatchers("/auth")
                       .permitAll()
                       .anyRequest().authenticated())
               .sessionManagement(sess-> sess.sessionCreationPolicy((SessionCreationPolicy.STATELESS) ))
               .authenticationProvider(authenticationProvider).addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);

       return http.build();

   }












}