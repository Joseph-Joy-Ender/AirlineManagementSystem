//package com.example.airlineproject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder){
////        UserDetails admin = User.withUsername("Joseph")
////                .password(encoder.encode("Password"))
////                .roles("ADMIN")
////                .build();
////
////        UserDetails user = User.withUsername("Joy")
////                .password(encoder.encode("Joy123"))
////                .roles("USER")
////                .build();
//
//        return new PassengerUserDetailsService();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//            http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//            http.formLogin(withDefaults());
//            http.httpBasic(withDefaults());
//            return http.build();
//
////      http.csrf().disable()
////              .authorizeHttpRequests()
////              .requestMatchers("/api/v1/user/").permitAll()
////              .and()
////              .authorizeHttpRequests().requestMatchers("/api/v1/flight/**").authenticated()
////              .and().formLogin()
////              .and().build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//}
