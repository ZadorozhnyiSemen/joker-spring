package com.epam.spring.listener;

import com.epam.spring.annotations.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    final
    ConfigurableListableBeanFactory factory;

    @Autowired
    public PostProxyInvokerContextListener(ConfigurableListableBeanFactory factory) {
        this.factory = factory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(bean);
            String beanOriginalClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(beanOriginalClassName);
                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        Object contextBean = context.getBean(bean);
                        Method currentMethod = contextBean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        currentMethod.invoke(contextBean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
