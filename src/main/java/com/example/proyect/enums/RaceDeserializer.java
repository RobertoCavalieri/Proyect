package com.example.proyect.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.json.JsonParseException;

import java.io.IOException;

public class RaceDeserializer extends JsonDeserializer<Race> {

    @Override
    public Race deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String value = parser.getText();
        try {
            return Race.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new JsonParseException();
        }
    }
}
