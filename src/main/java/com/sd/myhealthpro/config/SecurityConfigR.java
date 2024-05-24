package com.sd.myhealthpro.config;

import com.sd.myhealthpro.auth.enums.Authorities;
import com.sd.myhealthpro.auth.service.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Set;


//@Configuration
public class SecurityConfigR {

    private static final Set<Authorities> ONLY_USER_AUTHORITY = Set.of(Authorities.ROLE_USER);

    private static final String[] ANONYMOUS_URL_PATTERNS = {
            "auth/**"
    };

//    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
    AuthenticationManager passwordAuthenticationManager(HttpSecurity httpSecurity, CustomUserDetailsService customUserDetailsService) throws Exception {
        var authenticationBuilder =httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationBuilder.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationBuilder.build();
    }

    private Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> authorizationManagerCustomizer(){
        return auth -> auth.anyRequest().permitAll();
//                .requestMatchers("/**")
//                .authenticated();
    }

//    @Bean
    SecurityFilterChain customFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizationManagerCustomizer())
                .authenticationManager(authenticationManager);
        return httpSecurity.build();
    }

//    @Bean
//    List<RequestMatcher> anonymousRequestMatchers(){
//        HandlerMappingIntrospector introspector = context.getBean("mvcHandlerMappingIntrospector", HandlerMappingIntrospector.class);
//        List<RequestMatcher> anonymousRequestMatchers =new ArrayList<>(ANONYMOUS_URL_PATTERNS.length);
//        for (String anonymousUrl: ANONYMOUS_URL_PATTERNS){
//            anonymousRequestMatchers.add(new MvcRequestMatcher(introspector,anonymousUrl));
//        }
//        return anonymousRequestMatchers;
//    }

//    @Bean
    CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*"); // TODO
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
