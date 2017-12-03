package com.epam.spring.config;

import com.epam.spring.screensaver.ColorFrame;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.screensaver")
public class ScreenSaverConfig {
    @Bean
    @Scope("prototype")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);
        while (true) {
            configApplicationContext.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(200);
        }
    }
}
