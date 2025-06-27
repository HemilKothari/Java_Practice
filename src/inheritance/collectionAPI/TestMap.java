package inheritance.collectionAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap<>();
        hashMap.put(10, "Rahul");
        hashMap.put(20, "A");
        hashMap.put(50, "S");
        hashMap.put(30, "D");

        System.out.println(hashMap);

        LinkedHashMap linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(10, "R");
        linkedHashMap.put(20, "A");
        linkedHashMap.put(50, "S");
        linkedHashMap.put(30, "D");
        
        System.out.println(linkedHashMap);

        TreeMap treeMap = new TreeMap<>();
        treeMap.put(10,"R");
        treeMap.put(20,"A");
        treeMap.put(50,"S");
        treeMap.put(30,"D");

        System.out.println(treeMap);
        
    }
}
