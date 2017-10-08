package org.my.education;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("fromFile")
public class DataReceiverFromFile implements DataReceiver {
    public boolean loadData() {
        /*
        В данном методе будет описана логика загрузки данных из файлов в файловой системе
         */
        System.out.println("Здесь будет описана загрузка данных из файловой системы");
        return true;
    }
}
