package org.my.education.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public String inboxPath;
    public String outboxPath;

    public PropertyReader(String propertyPath) {
        FileInputStream propertyFile = null;

        try {
            // Попытка открытия файлов
            propertyFile = new FileInputStream(propertyPath);
            Properties properties = new Properties();
            properties.load(propertyFile);
            inboxPath = properties.getProperty("inbox");
            outboxPath = properties.getProperty("outbox");
            System.out.println("Inbox path: " + inboxPath);
            System.out.println("Outbox path: " + outboxPath);
        } catch (IOException e) {
            System.out.println("Oшибкa ввода-вывода: " + e.getMessage());
        } finally {
            try {
                if (propertyFile != null) propertyFile.close();
            } catch (IOException e) {
                System.out.println("Oшибкa при закрытии выходного файла: " + e.getMessage());
            }
        }

    }

}
