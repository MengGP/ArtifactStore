package com.menggp.artifactstore.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурация MCV
 *      для "клиентской" части
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/createArtifactPage").setViewName("createArtifactPage");
        registry.addViewController("/editArtifactPage").setViewName("editArtifactPage");
        registry.addViewController("/delArtifactPage").setViewName("delArtifactPage");
        registry.addViewController("/commentPage").setViewName("commentPage");
        registry.addViewController("/editCommentPage").setViewName("editCommentPage");
        registry.addViewController("/delCommentPage").setViewName("delCommentPage");
        registry.addViewController("/artHistPage").setViewName("artHistPage");

        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/login").setViewName("login");

    }

}
