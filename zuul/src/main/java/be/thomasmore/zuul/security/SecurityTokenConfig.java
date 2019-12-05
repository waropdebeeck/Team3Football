package be.thomasmore.zuul.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtConfig jwtConfig;
    @Override

    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()

                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                // handle an authorized attempts

                .exceptionHandling().authenticationEntryPoint((request, response, e) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(String.format("{\"message\": \"%s\"}", e.getMessage()));
        })
                .and()
                // Add a filter to validate the tokens with every request
                .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)

                .authorizeRequests()
                // authorization requests config



                // allow all who are accessing "auth" service

                .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()

                // must be an admin if trying to access admin area (authentication is also required here)
                .antMatchers(HttpMethod.POST, "/auth/**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/users/create").permitAll()

                // Any other request must be authenticated

                .anyRequest().permitAll();


    }



    @Bean

    public JwtConfig jwtConfig() {

        return new JwtConfig();

    }
}
