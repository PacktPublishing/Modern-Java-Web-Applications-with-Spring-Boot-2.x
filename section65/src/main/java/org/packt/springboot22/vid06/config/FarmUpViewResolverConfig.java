package org.packt.springboot22.vid06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringWebFluxTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.reactive.ThymeleafReactiveViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class FarmUpViewResolverConfig {
	
	
	@Bean
	public SpringWebFluxTemplateEngine thymeleafTemplateEngine() {
		SpringWebFluxTemplateEngine templateEngine = new SpringWebFluxTemplateEngine();
		templateEngine.setTemplateResolver(thymeleafTemplateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	@Bean
	public SpringResourceTemplateResolver springResourceTemplateResolver() {
		return new SpringResourceTemplateResolver();
	}

	@Bean
	public ThymeleafReactiveViewResolver thymeleafChunkedAndDataDrivenViewResolver() {
		final ThymeleafReactiveViewResolver viewResolver = new ThymeleafReactiveViewResolver();
		viewResolver.setTemplateEngine(thymeleafTemplateEngine());
		viewResolver.setOrder(1);
		viewResolver.setResponseMaxChunkSizeBytes(8192); // OUTPUT BUFFER size limit
		viewResolver.setViewNames(new String[] { "th_*" });
		return viewResolver;
	}

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

}
