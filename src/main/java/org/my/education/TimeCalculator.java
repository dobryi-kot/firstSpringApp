package org.my.education;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.my.education.util.JsonGenerator;
import org.my.education.util.PropertyReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TimeCalculator {

    public static void main(String args[])
        throws Exception {
        // Reading properties configuration
        PropertyReader properties = new PropertyReader("src/main/resources/config.properties");

        // Ловим параметры коммандной строки
        // create the command line parser
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("g", "generate", true, "generate N count of JSON files for test");
        JsonGenerator jsonGenerator = new JsonGenerator();
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption('g') && line.hasOption("generate")) {
                jsonGenerator.generateJson(Integer.parseInt(line.getOptionValue('g')), properties.inboxPath);
            }
        }
        catch( Exception e ) {
            System.out.println( "Exception while reading command line arguments:" + e.getMessage() );
        }

        // Вариант загрузки контекста из xml-файла
        //ClassPathXmlApplicationContext is load all beans in the application
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Вариант загрузки контекста с помощью конфигуратора
        ApplicationContext context = new AnnotationConfigApplicationContext(TimeCalculatorConfiguration.class);

        DataProcessor dataProcessor = context.getBean(DataProcessor.class);
        dataProcessor.proccessData();
    }

}
