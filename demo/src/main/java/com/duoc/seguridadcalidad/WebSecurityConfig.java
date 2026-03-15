package com.duoc.seguridadcalidad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Description;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                                .authorizeHttpRequests(auth -> auth

                                                // rutas públicas
                                                .requestMatchers("/", "/login", "/css/**").permitAll()

                                                // rutas privadas
                                                .requestMatchers("/pacientes/**").authenticated()
                                                .requestMatchers("/citas/**").authenticated()

                                                // registros médicos (solo veterinario o admin)
                                                .requestMatchers("/registros/**").hasAnyRole("VETERINARIO", "ADMIN")

                                                // facturación (recepción o admin)
                                                .requestMatchers("/facturas/**").hasAnyRole("RECEPCION", "ADMIN")

                                                .anyRequest().authenticated())

                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .permitAll())

                                .logout(logout -> logout.permitAll());

                return http.build();
        }

        @Bean
        @Description("In memory Userdetails service registered since DB doesn't have user table ")
        public UserDetailsService users() {
                // The builder will ensure the passwords are encoded before saving in memory
                UserDetails user = User.builder()
                                .username("user")
                                .password(passwordEncoder().encode("password"))
                                .roles("USER")
                                .build();
                UserDetails admin = User.builder()
                                .username("admin")
                                .password(passwordEncoder().encode("password"))
                                .roles("USER", "ADMIN")
                                .build();
                UserDetails vet = User.builder()
                                .username("vet")
                                .password(passwordEncoder().encode("password"))
                                .roles("VET")
                                .build();
                return new InMemoryUserDetailsManager(user, admin, vet);
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

}