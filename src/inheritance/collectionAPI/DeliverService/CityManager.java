package inheritance.collectionAPI.DeliverService;

import java.util.HashSet;

public class CityManager {
    private HashSet<String> citySet;

    public CityManager() {
        citySet = new HashSet<>();
    }

    public void addCity(String cityName) {
        citySet.add(cityName.toLowerCase());
    }

    public void displayCity() {
        if (citySet.isEmpty())
            System.out.println("No cities to display.");
        else {
            System.out.println("----Currently Delivers In----");
            System.out.println(citySet);
        }
    }

    public void checkCity(String cityName) {
        if (citySet.contains(cityName.toLowerCase()))
            System.out.println("We are delivering in " + cityName);
        else
            System.out.println("We are not delivering in " + cityName);
    }
}
