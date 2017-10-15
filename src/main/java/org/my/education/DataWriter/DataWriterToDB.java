package org.my.education.DataWriter;

import org.my.education.DataReceiver.DataReceiver;
import org.my.education.Domain.Client;
import org.my.education.util.Settings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

/*
    This class written exclusively for understanding Spring mechanics
    and does not carry any other meaning
 */
@Service
@Qualifier("toDB")
public class DataWriterToDB implements DataReceiver {
    private Logger log = Logger.getLogger(DataWriterToDB.class.getName());

    public boolean loadData(ArrayList<Client> clients, Settings settings) {
        log.info("This method DataWriterToDB should not be implemented in the framework of the task");
        return true;
    }
}
