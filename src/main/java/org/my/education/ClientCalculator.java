package org.my.education;

import org.apache.commons.cli.*;
import org.my.education.util.JsonGenerator;
import org.my.education.util.Settings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientCalculator {
    private static Logger log = Logger.getLogger(ClientCalculator.class.getName());
    private static int generateNumber = -1;

    public static void main(String args[]) {

        // Create properties configuration
        Settings settings = new Settings();
        String propertiesPath = "./config.properties";

        // create the command line parser
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("p", "properties-path", true, "path to custom properties file");
        options.addOption("g", "generate", true, "generate <arg> count of JSON files for test");
        options.addOption("h", "help", false, "print this help information");
        try {
            CommandLine line = parser.parse(options, args);
            if ( line.hasOption('p') & line.hasOption("properties-path"))
                propertiesPath = line.getOptionValue('p');
            if ( line.hasOption('g') & line.hasOption("generate") ) {
                try {
                    generateNumber = Integer.parseInt(line.getOptionValue('g'));
                }
                catch (NumberFormatException exp) {
                    log.info( "Strange value for generated files number: " + exp.getMessage() );
                    return;
                }
            }
            if ( line.hasOption('h') & line.hasOption("help") ) {
                // automatically generate the help statement
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "clientCalculator", options );
                return;
            }
        }
        catch( ParseException exp ) {
            log.info( "Exception while parsing command line arguments:" + exp.getMessage() );
        }

        settings.load(propertiesPath);

        if ( generateNumber > 0 ) {
            JsonGenerator jsonGenerator = new JsonGenerator();
            if ( jsonGenerator.generateJson(generateNumber, settings.getValue(Settings.PROPERTY.INBOXPATH)) )
                log.info(generateNumber + " files was successfully generated!");
            else
                log.info("error occurs while generating files...");
            return;
        }

        // Вариант загрузки контекста из xml-файла
        //ClassPathXmlApplicationContext is load all beans in the application
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Вариант загрузки контекста с помощью конфигуратора
        ApplicationContext context = new AnnotationConfigApplicationContext(ClientCalculatorConfiguration.class);

        DataProcessor dataProcessor = context.getBean(DataProcessor.class);
        dataProcessor.processData(settings);
    }

}
