package org.my.education.DataReceiver;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
   Данный класс реализован исключительно в целях понимания механизмов работы Spring
   и не несет в себе никакой другой смысловой нагрузки
 */
@Service
@Qualifier("fromDB")
public class DataReceiverFromDB implements DataReceiver {
    public boolean loadData() {
        System.out.println("Метод класса DataReceiverFromDB не требует реализации в рамках поставленной задачи");
        return true;
    }
}
