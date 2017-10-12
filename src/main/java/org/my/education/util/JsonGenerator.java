package org.my.education.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.my.education.SubjectArea.Client;
import org.my.education.SubjectArea.ClientSerializer;
import org.my.education.SubjectArea.Subscriber;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class JsonGenerator {

    public boolean generateJson(int count, String generatePath) {
        System.out.println("Generating " + count + " testing JSONs in " + generatePath);

        final Random subscribersCount = new Random();
        final Random subscriberSpent = new Random();

        for (int clientId = 1; clientId < count + 1; clientId++) {
            int subscs = subscribersCount.nextInt(1000) + 1;

            Client client = new Client();
            client.setId(clientId);
            for (int subscriberId = 1; subscriberId < subscs + 1; subscriberId++) {
                Subscriber subscriber = new Subscriber();
                subscriber.setId(subscriberId);
                subscriber.setSpent(subscriberSpent.nextInt(10000));
                client.addSubscriber(subscriber);
            }

            Gson gson = new GsonBuilder()
                                    .setPrettyPrinting()
                                    .registerTypeAdapter(Client.class, new ClientSerializer())
                                    .create();
            String json = gson.toJson(client);

            try (FileOutputStream outputFile = new FileOutputStream(generatePath + "/client_" + clientId + ".json")) {
                // Попытка открытия файла
                outputFile.write(json.getBytes());
            } catch (IOException e) {
                System.out.println("Oшибкa ввода-вывода: " + e.getMessage());
                return false;
            }
        }
        return true;
    }
}
