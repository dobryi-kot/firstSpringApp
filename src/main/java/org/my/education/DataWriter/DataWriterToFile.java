package org.my.education.DataWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.my.education.Domain.Client;
import org.my.education.Domain.ClientSerializerOutput;
import org.my.education.util.Settings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Qualifier("toFile")
public class DataWriterToFile implements DataWriter {
    public boolean uploadData(ArrayList<Client> clients, Settings settings) {

        for ( Client client : clients ) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Client.class, new ClientSerializerOutput())
                    .create();
            String json = gson.toJson(client);

            try (FileOutputStream outputFile =
                 new FileOutputStream(settings.getValue(Settings.PROPERTY.OUTBOXPATH)
                                             + File.separator
                                             + client.getId()
                                             + ".json"))
            {
                outputFile.write(json.getBytes());
            } catch (IOException exp) {
                System.out.println("Input/output error: " + exp.getMessage());
                return false;
            }
        }
        return true;
    }
}