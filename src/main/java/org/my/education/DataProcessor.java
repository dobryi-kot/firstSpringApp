package org.my.education;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.my.education.DataReceiver.DataReceiver;
import org.my.education.DataWriter.DataWriter;
import org.my.education.Domain.Client;
import org.my.education.util.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.logging.Logger;

@Service
public class DataProcessor {

    private Logger log = Logger.getLogger(DataProcessor.class.getName());

    @Autowired
//    @Qualifier("file")
    private DataReceiver dataReceiver;

    // For this two fields IDEA says, that field injection is not good. I don't understand this (((
    @Autowired
    private DataWriter dataWriter;

    private ArrayList<Client> clients = new ArrayList<>();

    private void applyRules() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("clientCalculator");

        for (Client client: clients) {
            kieSession.insert(client);
        }

        kieSession.fireAllRules();
    }

    void processData(Settings settings) {
        if ( !dataReceiver.loadData(clients, settings) ) {
            log.info("Error loading data from inbox path!");
            return;
        }
        log.info("Loaded " + clients.size() + " clients");
        applyRules();
        //TODO: remove files
        if ( !dataWriter.uploadData(clients, settings) ) {
            log.info("Error writing data into outbox path!");
        }
    }
}
