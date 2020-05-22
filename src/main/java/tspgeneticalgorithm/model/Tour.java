package tspgeneticalgorithm.model;

import tspgeneticalgorithm.controller.CityDatabase;
import java.util.ArrayList;
import java.util.Collections;

public class Tour {
    private ArrayList tour = new ArrayList<City>();
    private double fitness = 0;
    private int distance = 0;
    
    public Tour(){
        for (int i = 0; i < CityDatabase.numberOfCities(); i++)
            tour.add(null);
    }
    
    public Tour(ArrayList tour){
        this.tour = tour;
    }

    public void generateIndividual() {
        for (int i = 0; i < CityDatabase.numberOfCities(); i++) {
            setCity(i, CityDatabase.getCity(i));
        }
        
        Collections.shuffle(tour);
    }

    public City getCity(int tourPosition) {
        return (City) tour.get(tourPosition);
    }

    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness() {
        if (fitness == 0)
            fitness = 1 / (double) getDistance();
        
        return fitness;
    }
    
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            
            for (int i = 0; i < tourSize(); i++) {
                City origin = getCity(i);
                City destination;
                
                if (i + 1 < tourSize())
                    destination = getCity(i + 1);
                else
                    destination = getCity(0);
                
                tourDistance += origin.distanceTo(destination);
            }
            
            distance = tourDistance;
        }
        
        return distance;
    }

    public int tourSize() {
        return tour.size();
    }
    
    public boolean containsCity(City city){
        return tour.contains(city);
    }
}
