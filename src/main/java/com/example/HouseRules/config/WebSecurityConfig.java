//package com.example.HouseRules.config;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.HouseRules.repository.UserRepository;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.*;
//
//
//
//@Configuration
//@EnableWebSecurity
//class WebSecurityConfig extends GlobalAuthenticationConfigurerAdapter {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService());
//    }
//
//
//    protected void configure(HttpSecurity http) throws Exception {
//
//
//                http.csrf().disable();
//    }
//
//    protected void configure(WebSecurity web, HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        web.ignoring().antMatchers("/api/user/new");
//    }
//
//    @Bean
//    UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                com.example.HouseRules.model.User user = userRepository.findByUsername(username);
//                if(user != null) {
//                    return new User(user.getUsername(), user.getPassword(), true, true, true, true,
//                            AuthorityUtils.createAuthorityList("USER"));
//                } else {
//                    throw new UsernameNotFoundException("could not find the user '"
//                            + username + "'");
//                }
//            }
//
//
//        };
//    }
//}

