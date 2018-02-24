package br.com.igtecnologia;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	
	private static final String WEBJARS_LOCATION = "/webjars/**";
	private static final String CLASSPATH_WEBJARS_LOCATION = "classpath:/META-INF/resources/webjars/";
	private static final String STATIC_RESOURCE_LOCATION = "/static/**";
	private static final String CLASSPATH_STATIC_RESOURCE_LOCATION = "classpath:/static/";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern(WEBJARS_LOCATION)) {
			registry.addResourceHandler(WEBJARS_LOCATION)
					.addResourceLocations(CLASSPATH_WEBJARS_LOCATION);
		}
		if (!registry.hasMappingForPattern(STATIC_RESOURCE_LOCATION)) {
			registry.addResourceHandler(STATIC_RESOURCE_LOCATION)
			.addResourceLocations(CLASSPATH_STATIC_RESOURCE_LOCATION);
		}
	}
}
