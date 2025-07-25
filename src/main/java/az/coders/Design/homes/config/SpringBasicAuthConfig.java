package az.coders.Design.homes.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringBasicAuthConfig {
    @Autowired
    JwtFilter jwtFilter;
@Bean
BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
}
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        List<UserDetails> users = new ArrayList<>();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        users.add(new User("user", "password", authorities));
//        return new InMemoryUserDetailsManager(new User("guest", "{noop}123", Collections.EMPTY_LIST),
//                new User("user", "{noop}1234", authorities),
//                new User("admin", "{noop}12345", List.of(new SimpleGrantedAuthority("ROLE_USER"),new SimpleGrantedAuthority("ROLE_ADMIN"))));
//    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
        csrf(AbstractHttpConfigurer::disable)
                . authorizeHttpRequests(auth->auth.requestMatchers("/public/**", "/auth/**", "/swagger-ui/**","/v3/api-docs/**", "/swagger-ui.html").permitAll()
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/medias").permitAll()
                .anyRequest().authenticated())
                .formLogin(AbstractHttpConfigurer::disable)
                //.formLogin(Customizer.withDefaults())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
       // http.apply(jwtFilterConfigurerAdapter);


    return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
return authenticationConfiguration.getAuthenticationManager();

  }

}
