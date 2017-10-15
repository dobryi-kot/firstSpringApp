package org.my.education.Domain;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ClientSerializerGenerate implements JsonSerializer<Client> {
    @Override
    public JsonElement serialize(Client client, Type typeOfClient, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("clientId", client.getId());

        JsonArray sbscrs = new JsonArray();
        result.add("subscribers", sbscrs);
        for ( Subscriber sbscr : client.getSubscribers()) {
            sbscrs.add(context.serialize(sbscr));
        }

        return result;
    }
}