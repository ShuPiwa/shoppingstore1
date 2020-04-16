package controller;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        System.out.println(map);

        map.remove("a");
        System.out.println(map);
    }
}
