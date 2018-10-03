package app.config;

import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx
                = new AnnotationConfigWebApplicationContext();
        ctx.scan(VaadinConfiguration.class.getPackage().getName());
        servletContext.addListener(new ContextLoaderListener(ctx));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "vaadin", SpringVaadinServlet.class);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/UI/*");
        dispatcher.addMapping("/VAADIN/*");

    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
