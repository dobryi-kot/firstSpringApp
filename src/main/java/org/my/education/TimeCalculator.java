package org.my.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TimeCalculator {

    public static void main(String args[]) {
        //ClassPathXmlApplicationContext is load all beans in the application
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        DataProcessor dataProcessor = (DataProcessor) context.getBean("data_Processor");
        dataProcessor.proccessData();

//        DataReceiver dataReceiver = (DataReceiver) context.getBean("data_ReceiverFromFile");
//        dataReceiver.loadData();
    }

}
