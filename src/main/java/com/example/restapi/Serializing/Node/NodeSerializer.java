package com.example.restapi.Serializing.Node;

import com.example.restapi.Entity.Node;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

//custom serializer
public class NodeSerializer extends StdSerializer<Node> {
    public NodeSerializer() {
        super(Node.class);
    }

    @Override
    public void serialize(Node value,
                          JsonGenerator gen,
                          SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("key", String.valueOf(value.getKey()));
        gen.writeNumberField("value", value.getValue());
        gen.writeEndObject();
    }
}
