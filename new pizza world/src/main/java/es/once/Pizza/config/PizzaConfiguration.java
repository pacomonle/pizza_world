package es.once.Pizza.config;




import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class PizzaConfiguration extends WebSecurityConfigurerAdapter {
 
 /*    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    } */
 
/*     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("admin").password("1234")
          .authorities("ROLE_USER");
    } */
 
 /*    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    } */
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*         http
          .authorizeRequests()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic(); */

          http.csrf().disable();
    }
}