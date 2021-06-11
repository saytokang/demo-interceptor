package com.example.demointerceptor.config;

import com.example.demointerceptor.interceptor.AccessAuthorityInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    
    private final AccessAuthorityInterceptor accessAuthorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessAuthorityInterceptor)
        .addPathPatterns("/home/deny");
    }
}
