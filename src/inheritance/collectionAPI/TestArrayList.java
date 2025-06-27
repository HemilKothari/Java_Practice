package inheritance.collectionAPI;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("One");
        arrayList.add(2);

        System.out.println(arrayList);

        for (Object object : arrayList) {
            System.out.println(object);
        }
    }
}
