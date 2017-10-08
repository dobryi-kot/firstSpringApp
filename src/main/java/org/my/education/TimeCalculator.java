package org.my.education;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

//import org.springframework.context.support.ClassPathXmlApplicationContext;

@Component
public class TimeCalculator {

    public static void main(String args[]) {
        // Вариант загрузки контекста из xml-файла
        //ClassPathXmlApplicationContext is load all beans in the application
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Вариант загрузки контекста с помощью конфигуратора
        ApplicationContext context = new AnnotationConfigApplicationContext(TimeCalculatorConfiguration.class);

        DataProcessor dataProcessor = context.getBean(DataProcessor.class);
        dataProcessor.proccessData();
    }

}
