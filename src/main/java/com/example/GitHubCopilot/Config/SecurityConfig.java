package com.example.GitHubCopilot.Config;

/*import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;*/

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

/*    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails manager= User.withUsername("rocky") // User.builder().username("abc").password("abc")
                .password(encoder.encode("pass1"))
                .roles("ADMIN")
                .build();

        UserDetails employee = User.withUsername("anu")
                .password(encoder.encode("pass2"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(manager,employee);
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf-> csrf.disable())
                .cors(cor->cor.disable())
                .authorizeRequests(auth ->auth.requestMatchers())

        return null;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }*/
}
