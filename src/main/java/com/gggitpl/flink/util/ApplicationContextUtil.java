package com.gggitpl.flink.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ApplicationContextUtil implements ApplicationContextAware, Serializable {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(@SuppressWarnings("NullableProblems") ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }
}
