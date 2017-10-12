package org.my.education.DataWriter;

import org.my.education.DataReceiver.DataReceiver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
   Данный класс реализован исключительно в целях понимания механизмов работы Spring
   и не несет в себе никакой другой смысловой нагрузки
 */
@Service
@Qualifier("toDB")
public class DataWriterToDB implements DataReceiver {
    public boolean loadData() {
        System.out.println("Метод класса DataWriterToDB не требует реализации в рамках поставленной задачи");
        return true;
    }
}
