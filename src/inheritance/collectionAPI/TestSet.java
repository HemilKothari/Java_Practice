package inheritance.collectionAPI;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(50);
        hashSet.add(30);

        System.out.println(hashSet);

        LinkedHashSet linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(10);
        linkedHashSet.add(10);
        linkedHashSet.add(50);
        linkedHashSet.add(30);
        
        System.out.println(linkedHashSet);

        TreeSet treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(50);
        treeSet.add(30);

        System.out.println(treeSet);
        
    }
}
