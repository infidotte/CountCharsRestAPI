package com.example.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Node {
    @JsonProperty("key")
    private final char key;
    @JsonProperty("value")
    private final int value;
}
