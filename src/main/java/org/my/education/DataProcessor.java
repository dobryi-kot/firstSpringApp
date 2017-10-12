package org.my.education;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.my.education.DataReceiver.DataReceiver;
import org.my.education.DataWriter.DataWriter;
import org.my.education.SubjectArea.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataProcessor {

    @Autowired
//    @Qualifier("file")
    private DataReceiver dataReceiver;

    // Почему то на этих двух полях IDEA подсказывает, что инекция полей это ай-ай-яй
    @Autowired
    private DataWriter dataWriter;

    private ArrayList<Client> clients = new ArrayList<>();

    private void applyRules() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("timeCalculator");

        for (Client client: clients) {
            kieSession.insert(client);
        }

        kieSession.fireAllRules();
    }

    // А здесь и вовсе непонятное мне ругательство - Access can be package-private
    public void proccessData() {
        dataReceiver.loadData();
        applyRules();
        dataWriter.uploadData();
    }
}
