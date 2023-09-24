package com.example.restapi.Utility;

import com.example.restapi.Entity.Node;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CountChars {

    //main logic method
    public static List<Node> countChars(String string) {
        //get all chars
        char[] chars = string.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        for (char aChar : chars) {
            //if char already exist in hashmap, then we add +1 to value, else add it with value 0
            count.put(aChar, count.getOrDefault(aChar, 0) + 1);
        }
        //first we convert our hashmap to stream of nodes
        //than we sort using the comparator sorts, make revers, convert to list, than return
        return count.entrySet().stream().map(x -> new Node(x.getKey(), x.getValue()))
                .sorted(Comparator.comparingInt(Node::getValue).reversed()).toList();
    }

}
