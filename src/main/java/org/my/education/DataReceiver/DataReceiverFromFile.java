package org.my.education.DataReceiver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.my.education.Domain.Client;
import org.my.education.Domain.ClientDeserializer;
import org.my.education.util.Settings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
@Qualifier("fromFile")
@Primary
public class DataReceiverFromFile implements DataReceiver {
    public boolean loadData(ArrayList<Client> clients, Settings settings) {
        File inboxPath = new File(settings.getValue(Settings.PROPERTY.INBOXPATH));
        if ( !inboxPath.exists() )
            return false;

        String[] files = inboxPath.list();

        if (files != null)
            for (String clientFileName : files) {

                try {
                    Gson gson = new GsonBuilder()
                            .setPrettyPrinting()
                            .registerTypeAdapter(Client.class, new ClientDeserializer())
                            .create();
                    String jsonFileData = new String(Files.readAllBytes(Paths.get(inboxPath + File.separator + clientFileName)));
                    Client client = gson.fromJson(jsonFileData, Client.class);
                    clients.add(client);
                } catch (IOException exp) {
                    System.out.println("Input/output error: " + exp.getMessage());
                    return false;
                }
            }

        return true;
    }
}
