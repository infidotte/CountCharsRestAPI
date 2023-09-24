package com.example.restapi.Entity;

import com.example.restapi.Serializing.Node.NodeDeserializer;
import com.example.restapi.Serializing.Node.NodeSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

//lombok.Data for getters and setters
//register serializer and deserializer by jackson annotation
@Data
@JsonSerialize(using = NodeSerializer.class)
@JsonDeserialize(using = NodeDeserializer.class)
public class Node {
    @JsonProperty("key")
    private final char key;
    @JsonProperty("value")
    private final int value;
}
