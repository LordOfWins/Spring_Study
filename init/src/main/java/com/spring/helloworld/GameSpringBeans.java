package com.spring.helloworld;

import com.spring.init.Console;
import com.spring.init.Runner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameSpringBeans {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguation.class)) {
            context.getBean(Console.class).up();
            context.getBean(Runner.class).run();
        }
    }
}
 