package org.my.education.Domain;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ClientSerializerOutput implements JsonSerializer<Client> {
    @Override
    public JsonElement serialize(Client client, Type typeOfClient, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("clientId", client.getId());
        result.addProperty("spentTotal", client.getSpentTotal());
        result.addProperty("isBig", client.isBig());

        return result;
    }
}
