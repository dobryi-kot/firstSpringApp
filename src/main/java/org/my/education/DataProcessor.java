package org.my.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessor {

    @Autowired
//    @Qualifier("file")
    private DataReceiver dataReceiver;

    // Почему то на этих двух полях IDEA подсказывает, что инекция полей это ай-ай-яй
    @Autowired
    private DataWriter dataWriter;

    // А здесь и вовсе непонятное мне Access can be package-private
    public void proccessData() {
        dataReceiver.loadData();
        /*
        Здесь будет логика обработки данных с помощью Drools
         */
        dataWriter.uploadData();
    }
}
