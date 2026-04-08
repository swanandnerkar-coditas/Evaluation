package com.week6.EmployeeManagementSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/register", "/login").permitAll()
                        .anyRequest().authenticated()
//                        .anyRequest().permitAll()
        );

        http
            .csrf(csrf -> csrf.disable())
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//        http.userDetailsService(userDetailsService);

        // disable Cross Site Request Forgery (CSRF)
//        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration){
        return configuration.getAuthenticationManager();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(){
//
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        /* AuthenticationProvider implemented by DaoAuthenticationProvider
            and DaoAuthenticationProvider requires UserDetailsService interface in constructor
                UserDetailService is interface so instead of implicitly implemented classes create service class ( entity : User ) & implements UserDetailsService

         */
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        provider.setUserDetailsService(userDetailsService);   // check here : in new updates they make constructor of UserDetailsService as private & make everything static to access
        return provider;
    }


    // Role Hierarchy bean
//    @Bean
//    public RoleHierarchy roleHierarchy(){
//        return RoleHierarchyImpl.fromHierarchy("""
//                ADMIN > MANAGER
//                MANAGER > EMPLOYEE
//                """);
//    }
//
//    @Bean
//    public MethodSecurityExpressionHandler methodSecurityExpressionHandler() {
//        DefaultMethodSecurityExpressionHandler handler =
//                new DefaultMethodSecurityExpressionHandler();
//        handler.setRoleHierarchy(roleHierarchy());
//        return handler;
//    }


    // InMemoryUserDetailsManager

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails swanand = User.builder()
//                .username("swanand")
//                .password("{noop}swanand123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails vijay = User.builder()
//                .username("vijay")
////                .password("{noop}vijay123")
//                .password("{noop}vijay123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails raj = User.builder()
//                .username("raj")
//                .password("{noop}raj123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(swanand, vijay, raj);
//    }
}
