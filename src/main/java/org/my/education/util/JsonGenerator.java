package org.my.education.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.my.education.Domain.Client;
import org.my.education.Domain.ClientSerializerGenerate;
import org.my.education.Domain.Subscriber;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

public class JsonGenerator {

    private Logger log = Logger.getLogger(JsonGenerator.class.getName());

    public boolean generateJson(int count, String generatePath) {

        log.info("Generating " + count + " testing JSONs in " + generatePath);

        File inboxDir = new File(generatePath);
        if ( !inboxDir.exists() )
            if ( inboxDir.mkdir() )
                log.info("Creating input directory.");
            else {
                log.info("Fail to creating input directory");
                return false;
            }
        else if ( !inboxDir.isDirectory() ) {
            log.info("Inbox path from parameters is not a directory!");
            return false;
        }

        final Random subscribersCount = new Random();
        final Random subscriberSpent = new Random();

        for (int clientId = 1; clientId < count + 1; clientId++) {
            long subscs = subscribersCount.nextInt(200) + 1;

            Client client = new Client();
            client.setId(clientId);
            for (long subscriberId = 1; subscriberId < subscs + 1; subscriberId++) {
                Subscriber subscriber = new Subscriber();
                subscriber.setId(subscriberId);
                subscriber.setSpent(subscriberSpent.nextInt(100));
                client.addSubscriber(subscriber);
            }

            Gson gson = new GsonBuilder()
                                    .setPrettyPrinting()
                                    .registerTypeAdapter(Client.class, new ClientSerializerGenerate())
                                    .create();
            String json = gson.toJson(client);

            try (FileOutputStream outputFile =
                         new FileOutputStream(generatePath + File.separator + clientId + ".json"))
            {
                // Попытка открытия файла
                outputFile.write(json.getBytes());
            } catch (IOException e) {
                log.info("Input/output error: " + e.getMessage());
                return false;
            }
        }
        return true;
    }
}
