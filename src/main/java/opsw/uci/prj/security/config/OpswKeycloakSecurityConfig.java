/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.security.config;

import opsw.uci.prj.logging.OpswLogger;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 *
 * @author oulis
 */
//@KeycloakConfiguration
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class OpswKeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter
{
// Submits the KeycloakAuthenticationProvider to the AuthenticationManager

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    super.configure(http);
    http
            .httpBasic().disable()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/home", "/resources/**", "/static/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            ;
  }

  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy()
  {
    return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
  {
    KeycloakAuthenticationProvider keycloakAuthenticationProvider
            = keycloakAuthenticationProvider();
    keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());

    auth.authenticationProvider(keycloakAuthenticationProvider);
  }

}
