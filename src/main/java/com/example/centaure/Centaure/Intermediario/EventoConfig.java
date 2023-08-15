package com.example.centaure.Centaure.Intermediario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class EventoConfig implements WebMvcConfigurer {

    @Autowired
    private EventoBloq interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptor).addPathPatterns(new String[] {"/evento", "/evento/**"});
    }
}
