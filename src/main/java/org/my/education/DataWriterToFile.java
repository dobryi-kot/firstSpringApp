package org.my.education;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("toFile")
public class DataWriterToFile implements DataWriter {
    public boolean uploadData() {
        /*
       Здесь будет находиться логика сохранения обработанной информации
         */
        return true;
    }
}
