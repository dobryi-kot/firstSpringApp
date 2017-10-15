package org.my.education.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Properties;
import java.util.logging.Logger;

public class Settings {

    // Fields can be converted to a local variable, but in case of expand this program it can be
    // need as member of class...
    final private String defualtInboxPath = "./inbox";
    final private String defualtOutboxPath = "./outbox";

    // This enum can be expand for more properties
    public enum PROPERTY {
        INBOXPATH, OUTBOXPATH
    }

    // java.util.Properties instance can be used
    // EnumMap used in the aim of knowing java collections
    private EnumMap<PROPERTY, String> settings = new EnumMap<>(PROPERTY.class);

    private Logger log = Logger.getLogger(Settings.class.getName());

    public void setValue(PROPERTY key, String value) {
        settings.put(key, value);
    }

    public String getValue(PROPERTY key) {
       return settings.getOrDefault(key, null);
    }

    public void load(String propertyPath) {
        log.info("Trying to load config file: " + propertyPath);
        try (FileInputStream propertyFile = new FileInputStream(propertyPath)) {
            Properties properties = new Properties();
            properties.load(propertyFile);
            setValue(PROPERTY.INBOXPATH, properties.getProperty("inbox"));
            setValue(PROPERTY.OUTBOXPATH, properties.getProperty("outbox"));
        } catch (IOException exp) {
            log.info("Error loading property file: " + exp.getMessage());
            log.info("Loading default settings...");
        }

        log.info("Inbox path: " + getValue(PROPERTY.INBOXPATH));
        log.info("Outbox path: " + getValue(PROPERTY.OUTBOXPATH));
    }

    public Settings() {
        // set default settings
        settings.put(PROPERTY.INBOXPATH, defualtInboxPath);
        settings.put(PROPERTY.OUTBOXPATH, defualtOutboxPath);
    }

}
