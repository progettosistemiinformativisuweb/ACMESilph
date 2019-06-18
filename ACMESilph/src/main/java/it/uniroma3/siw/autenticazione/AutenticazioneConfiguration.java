package it.uniroma3.siw.autenticazione;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The AuthConfiguration is a Spring Security Configuration.
 * It extends WebSecurityConfigurerAdapter, meaning that it provides the settings for Web security.
 */
@Configuration
@EnableWebSecurity
public class AutenticazioneConfiguration extends WebSecurityConfigurerAdapter {

    
   

    /**
     * The configure method is the main method in the AuthConfiguration.
     * it
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http
				// authorization paragraph: we are going to define here WHO can access WHAT
				// pages
				.authorizeRequests()


				// everyone (authenticated or not) can access the home page
				.antMatchers(HttpMethod.GET, "/", "/index", "/galleriaFoto", "/getFoto/{id}", "/fotografi",
						"/fotografo/{id}", "/getFotografoAvatar/{id}")
				.permitAll()

				// only admin can access the admin page
				// .antMatchers(HttpMethod.GET, "/admin").hasAnyAuthority("ADMIN")

				// all authenticated users can access all the other pages (that is, welcome)
				.anyRequest().authenticated()

				// login paragraph: we are going to define here how to login
				// use formlogin protocol to perform login
				.and().formLogin().loginPage("/getLogin").permitAll()

				// NOTE: we are using the default configuration for login,
				// meaning that the /login url is automatically mapped to auto-generated page.
				// for our own page, we would need to use loginPage()
				// and write a method for accessing it with GET method (but Spring would still
				// handle the POST automatically)

				// logout paragraph: we are going to define here how to logout
				.and().logout().permitAll();
    }
    
    /**
     * Ignoriamo le richieste ai fogli di stile
     */
    @Override
	public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/images/**");
    }

  

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
