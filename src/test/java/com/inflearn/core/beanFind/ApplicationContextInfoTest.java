package com.inflearn.core.beanFind;

import com.inflearn.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void display_all_beans() {
        String[] beanDefinitionNames = appCtx.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = appCtx.getBean(beanDefinitionName);
            System.out.println(String.format("name: %s; object: %s", beanDefinitionName, bean));
        }
    }

    @Test
    void display_application_beans() {
        String[] beanDefinitionNames = appCtx.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            if (appCtx.getBeanDefinition(beanDefinitionName).getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = appCtx.getBean(beanDefinitionName);
                System.out.println(String.format("name: %s; object: %s", beanDefinitionName, bean));
            }
        }
    }

    @Test
    void display_internal_beans() {
        String[] beanDefinitionNames = appCtx.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            if (appCtx.getBeanDefinition(beanDefinitionName).getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = appCtx.getBean(beanDefinitionName);
                System.out.println(String.format("name: %s; object: %s", beanDefinitionName, bean));
            }
        }
    }
}
