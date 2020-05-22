package tspgeneticalgorithm.controller;

import tspgeneticalgorithm.model.*;

public class TSPLogic {
    private static double mutationRate;

    public static Population evolvePopulation(Population pop, double mutationRate) {
        TSPLogic.mutationRate = mutationRate;
        
        Population newPopulation = new Population(pop.populationSize(), false);
        newPopulation.saveTour(0, pop.getFittest());
        
        for (int i = 1; i < newPopulation.populationSize(); i++) {
            // Select parents
            Tour parent1 = tournamentSelection(pop);
            Tour parent2 = tournamentSelection(pop);
            // Crossover parents
            Tour child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.saveTour(i, child);
        }

        for (int i = 1; i < newPopulation.populationSize(); i++)
            mutate(newPopulation.getTour(i));

        return newPopulation;
    }

    private static Tour tournamentSelection(Population pop) {
        int tournamentSize = 5;
        Population tournament = new Population(tournamentSize, false);
        
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }

        return tournament.getFittest();
    }
    
    public static Tour crossover(Tour parent1, Tour parent2) {
        Tour child = new Tour();

        int start = (int) (Math.random() * parent1.tourSize());
        int end = (int) (Math.random() * parent1.tourSize());

        for (int i = 0; i < child.tourSize(); i++) {
            if (start < end && i > start && i < end)
                child.setCity(i, parent1.getCity(i));
            else if (start > end) {
                if (!(i < start && i > end))
                    child.setCity(i, parent1.getCity(i));
            }
        }

        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.containsCity(parent2.getCity(i))) {
                for (int j = 0; j < child.tourSize(); j++) {
                    if (child.getCity(j) == null) {
                        child.setCity(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        
        return child;
    }

    private static void mutate(Tour tour) {
        for(int tourPos1 = 0; tourPos1 < tour.tourSize(); tourPos1++) {
            if(Math.random() < mutationRate) {
                int tourPos2 = (int) (tour.tourSize() * Math.random());

                City city1 = tour.getCity(tourPos1);
                City city2 = tour.getCity(tourPos2);

                tour.setCity(tourPos2, city1);
                tour.setCity(tourPos1, city2);
            }
        }
    }
}
