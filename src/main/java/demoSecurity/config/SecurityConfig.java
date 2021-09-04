package demoSecurity.config;

import demoSecurity.service.ApUserServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    ApUserServie apUserServie;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home").permitAll()
                .and()
//                .authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
                .authorizeRequests().antMatchers("/admin").hasAnyAuthority("ROLE_ADMIN")
                .and()
//                .authorizeRequests().antMatchers("/user").hasRole("USER")
                .authorizeRequests().antMatchers("/user").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .and()
                .formLogin().successHandler(new SuccessHandler())
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(apUserServie).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
