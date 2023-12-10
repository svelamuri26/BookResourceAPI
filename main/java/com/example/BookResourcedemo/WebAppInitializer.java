package com.example.BookResourcedemo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class}; // Your main configuration class
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // Leave it null or define a configuration class for the servlet if needed
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

