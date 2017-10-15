package org.my.education.Domain;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ClientDeserializer implements JsonDeserializer<Client> {
    @Override
    public Client deserialize(JsonElement json, Type typeOfClient, JsonDeserializationContext context)
//            throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();

        Client client = new Client();
        client.setId(jsonObject.get("clientId").getAsInt());
        long totalSpent = 0;
        int i = 0;

        JsonArray sbscrs = jsonObject.getAsJsonArray("subscribers");
        for ( JsonElement sbscr : sbscrs) {
            client.addSubscriber(context.deserialize(sbscr, Subscriber.class));
            totalSpent += client.getSubscribers().get(i).getSpent();
            i++;
        }

        client.setSpentTotal(totalSpent);

        return client;
    }
}
