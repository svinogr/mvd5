package app.config;

import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
@ComponentScan({"app.*"})

@PropertySource(value = {"classpath:auth.properties"})


public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    // конфиг этого бина находится в hibernate config
    @Autowired
    UserDetailsService userDetailsService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }



    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BasicAuthenticationEntryPoint basicAuthEntryPoint(){
        return new BasicAuthEntryPoint();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/administration/**").access("hasRole('ADMIN')")
                // .antMatchers("/api/**").access("hasRole('USER')")
                .antMatchers("/api/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/api/user/**").access("hasRole('ADMIN')") // спорный момент
                .antMatchers("/api/user/**").access("hasRole('USER')") // спорный момент

                .and().httpBasic().authenticationEntryPoint(basicAuthEntryPoint()).and().csrf().disable()
                .logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies();

        //  .and().csrf().disable()
               // .sessionManagement().maximumSessions(100).sessionRegistry(sessionRegistry()).and()
               // .and().logout()
               // .logoutUrl("/logout").logoutSuccessUrl("/")
               // .invalidateHttpSession(true).deleteCookies();



    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
