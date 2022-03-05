package com.example.hello.filter;

import com.example.hello.Utils.JwtTokenUtils;
import com.example.hello.pojo.LoginUser;
import com.example.hello.service.LoginUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private LoginUserService loginUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }
        String userid =null;
        try{
            Claims claims = JwtTokenUtils.parseToken(token);
            userid = (String) claims.get("userid");
        }catch (Exception e){
            throw new RuntimeException("token is illegal");
        }
        if(userid==null){
            throw new RuntimeException("token is illegal");
        }
        LoginUser loginUser = loginUserService.getUserById(Integer.parseInt(userid));
        List<String> permission = Arrays.asList(loginUser.getPermission(), loginUser.getRole());
        List<SimpleGrantedAuthority> authorities = permission.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}
