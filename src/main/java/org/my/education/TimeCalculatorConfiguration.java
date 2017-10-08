package org.my.education;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeCalculatorConfiguration {

    @Bean
    DataReceiver getDataReceiver() {
        return new DataReceiverFromFile();
    }

    @Bean
    DataWriter getDataWriter() {
        return new DataWriterToFile();
    }

    @Bean
    DataProcessor getDataProcessor() {
        return new DataProcessor();
    }

}
