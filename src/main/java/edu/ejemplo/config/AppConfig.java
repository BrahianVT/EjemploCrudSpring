package edu.ejemplo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"edu.ejemplo","com.ejemplo"})
public class AppConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registy){
		registy.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		System.out.println("entro");
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("WEB-INF/jsp/");
		view.setSuffix(".jsp");
		return view;
	}
}
