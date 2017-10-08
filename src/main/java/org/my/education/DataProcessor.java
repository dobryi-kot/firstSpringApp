package org.my.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataProcessor {

    @Autowired
//    @Qualifier("file")
    private DataReceiver dataReceiver;

    public void proccessData() {
        dataReceiver.loadData();
    }
}
