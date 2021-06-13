package org.sakhnyasha.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebServletConfiguration implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.setConfigLocation("org.sakhnyasha.config");
        webCtx.register(SpringConfig.class);
        webCtx.setServletContext(servletContext);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher",
                new DispatcherServlet(webCtx));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
        servletContext.addFilter("securityFilter",
                new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/*");
    }
}
