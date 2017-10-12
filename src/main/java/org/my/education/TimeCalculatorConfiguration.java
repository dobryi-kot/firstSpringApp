package org.my.education;

import org.my.education.DataReceiver.DataReceiver;
import org.my.education.DataReceiver.DataReceiverFromFile;
import org.my.education.DataWriter.DataWriter;
import org.my.education.DataWriter.DataWriterToFile;
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
