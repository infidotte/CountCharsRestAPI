package com.example.restapi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountChars {
    public static Object countChars(String string) {
        char[] chars = string.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        for (char aChar : chars) {
            count.put(aChar,count.getOrDefault(aChar,0) + 1);
        }
        return count.entrySet().stream().sorted(Map.Entry.<Character,Integer>comparingByValue().reversed()).collect(Collectors.toList());
      //  return count.entrySet().stream().map(x -> new Node(x.getKey(), x.getValue()))
        //        .sorted(Comparator.comparingInt(Node::getValue).reversed()).toList();
    }

}
