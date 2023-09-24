package com.example.restapi.Serializing.Node;

import com.example.restapi.Entity.Node;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

//custom deserializer
public class NodeDeserializer extends StdDeserializer<Node> {
    public NodeDeserializer() {
        this(null);
    }

    public NodeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Node deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        char key = node.get("key").asText().charAt(0);
        int value = node.get("value").asInt();
        return new Node(key, value);
    }
}
