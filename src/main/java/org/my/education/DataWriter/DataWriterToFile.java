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
import java.util.logging.Logger;

@Service
@Qualifier("toFile")
public class DataWriterToFile implements DataWriter {

    private Logger log = Logger.getLogger(DataWriter.class.getName());

    public boolean uploadData(ArrayList<Client> clients, Settings settings) {

        File outboxDir = new File(settings.getValue(Settings.PROPERTY.OUTBOXPATH));
        if ( !outboxDir.exists() )
            if ( outboxDir.mkdir() )
                log.info("Creating output directory.");
            else {
                log.info("Fail to creating output directory");
                return false;
            }
        else if ( !outboxDir.isDirectory() ) {
                log.info("Outbox path from parameters is not a directory!");
                return false;
        }

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
                log.info("Input/output error: " + exp.getMessage());
                return false;
            }
        }
        return true;
    }
}
