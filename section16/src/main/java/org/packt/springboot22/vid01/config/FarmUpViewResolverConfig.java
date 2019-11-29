package org.packt.springboot22.vid01.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.groovy.GroovyMarkupConfigurer;
import org.springframework.web.servlet.view.groovy.GroovyMarkupViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class FarmUpViewResolverConfig {
	
	// Freemarker ViewResolver Configuration
    
    @Bean(name = "ftlViewResolver")
    public ViewResolver ftlViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
 
        viewResolver.setCache(true);
        viewResolver.setPrefix("/freemarker/");
        viewResolver.setSuffix(".ftl");
        viewResolver.setOrder(0);
        viewResolver.setViewNames(new String[] { "ftl_*" });
        return viewResolver;
    }
 
    @Bean(name = "freemarkerConfig")
    public FreeMarkerConfigurer ftlFreemarkerConfig() {
        FreeMarkerConfigurer config = new FreeMarkerConfigurer();
        config.setTemplateLoaderPath("classpath:/templates");
        return config;
    }
    
	
	// Thymeleaf ViewResolver Configuration
	
	@Bean
    public ViewResolver thymeleafViewResolver() {
 
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
 
        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[] { "th_*" });
 
        return viewResolver;
    }
 
    // Thymeleaf template engine with Spring 5 integration
    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
 
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        
        return templateEngine;
    }
 
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        return new SpringResourceTemplateResolver();
    }
 
    // Thymeleaf template resolver serving HTML 5
    @Bean
    public ITemplateResolver thymeleafTemplateResolver() {
 
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        
        templateResolver.setPrefix("/templates/thymeleaf/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
 
        return templateResolver;
    }
	
	
	// Mustache ViewResolver Configuration
    @Bean
    public ViewResolver mstViewResolver(ResourceLoader resourceLoader) {
        MustacheViewResolver mustacheViewResolver
          = new MustacheViewResolver();
        mustacheViewResolver.setPrefix("classpath:/templates/mustache/");
        mustacheViewResolver.setSuffix(".mustache");
        mustacheViewResolver.setViewNames(new String[] { "mst_*" });
        mustacheViewResolver.setOrder(2);
        return mustacheViewResolver;
    }
    
    // Groovy ViewResolver
    @Bean
    public GroovyMarkupConfigurer groovyMarkupConfigurer() {
        GroovyMarkupConfigurer configurer = new GroovyMarkupConfigurer();
        configurer.setResourceLoaderPath("classpath:/templates/groovy/");
        return configurer;
    }

    @Bean
    public GroovyMarkupViewResolver groovyViewResolver() {
        GroovyMarkupViewResolver viewResolver = new GroovyMarkupViewResolver();
        viewResolver.setSuffix(".tpl");
        viewResolver.setViewNames(new String[] { "tpl_*" });
        viewResolver.setOrder(3);
        return viewResolver;
    }

}
