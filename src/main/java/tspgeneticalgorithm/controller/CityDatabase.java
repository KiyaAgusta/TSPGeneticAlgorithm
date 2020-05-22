package tspgeneticalgorithm.controller;

import java.util.ArrayList;
import tspgeneticalgorithm.model.City;

public class CityDatabase {
    private static ArrayList destinationCities = new ArrayList<City>();

    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    public static City getCity(int index){
        return (City) destinationCities.get(index);
    }
    
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
