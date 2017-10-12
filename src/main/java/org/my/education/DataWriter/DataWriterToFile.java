package org.my.education.DataWriter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("toFile")
public class DataWriterToFile implements DataWriter {
    public boolean uploadData() {
        /*
       Здесь будет находиться логика сохранения обработанной информации
         */
        System.out.println("Здесь будет находиться логика сохранения обработанной информации");
        return true;
    }
}
