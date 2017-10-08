package org.my.education;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("file")
public class DataReceiverFromFile implements DataReceiver {
    public boolean loadData() {
        System.out.println("Ебать-копать, у меня получилось!!!");
        return true;
    }
}
