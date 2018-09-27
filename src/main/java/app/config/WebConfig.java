package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("app")
public class WebConfig implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("/WEB-INF/views/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
        registry.addResourceHandler("/jpg/**").addResourceLocations("/WEB-INF/views/images/");
        registry.addResourceHandler("/gif/**").addResourceLocations("/WEB-INF/views/images/");
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/WEB-INF/views/content/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/views/js/");
        registry.addResourceHandler("/font/**").addResourceLocations("/WEB-INF/views/font/");
      //  registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".html");
        viewResolver.setContentType("text/html; charset=utf-8");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    // для велком листа
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }


}
