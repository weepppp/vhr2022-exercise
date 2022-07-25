package com.qfedu.vhr.framework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.vhr.framework.entity.Hr;
import com.qfedu.vhr.framework.entity.RespBean;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.security.auth.message.AuthException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author weepppp 2022/7/22 15:50
 **/
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler((req, resp, auth) -> {
                    resp.setContentType("application/json; charset=UTF-8");
                    Hr hr = (Hr) auth.getPrincipal();
                    hr.setPassword(null);
                    RespBean respBean = RespBean.ok("登录成功", hr);
                    String s = new ObjectMapper().writeValueAsString(respBean);
                    resp.getWriter().write(s);
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json; charset=UTF-8");
                    RespBean respBean = RespBean.error("登录失败");
                    if (e instanceof BadCredentialsException) {
                        respBean.setMsg("账号或者密码输入错误");
                    } else if (e instanceof DisabledException) {
                        respBean.setMsg("账户被禁用");
                    }
                    String s = new ObjectMapper().writeValueAsString(respBean);
                    resp.getWriter().write(s);
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req,resp,auth) ->{
                    resp.setContentType("application/json; charset=UTF-8");
                    RespBean respBean = RespBean.ok("注销成功");
                    String s = new ObjectMapper().writeValueAsString(respBean);
                    resp.getWriter().write(s);
                })
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint((req, resp, e) -> {
                    resp.setStatus(HttpStatus.UNAUTHORIZED.value());
            resp.setContentType("application/json; charset=UTF-8");
            RespBean respBean = RespBean.error("尚未登录请登录");
            String s = new ObjectMapper().writeValueAsString(respBean);
            resp.getWriter().write(s);
        });
        return http.build();
    }
}
