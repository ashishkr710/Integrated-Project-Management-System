package IPMS.Integrated.Project.Management.System.Configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;


@Component
@EnableWebSecurity
public class SecurityConfig extends SecurityConfigurerAdapter<Void, HttpSecurity> {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Configure HTTP security settings here
        http.authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/private/**").authenticated()
                .and()
                .formLogin()
                .and()
                .logout();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//    }
}
