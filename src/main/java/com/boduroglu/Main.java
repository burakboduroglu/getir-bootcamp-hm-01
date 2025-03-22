package com.boduroglu;

import com.boduroglu.models.House;
import com.boduroglu.repositories.HouseRepository;
import com.boduroglu.services.HouseService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HouseRepository repository = new HouseRepository();
        HouseService service = new HouseService(repository);

        // Print all calculations
        System.out.println("Total Apartment Price: $" + service.getTotalApartmentPrice());
        System.out.println("Total Villa Price: $" + service.getTotalVillaPrice());
        System.out.println("Total Summer House Price: $" + service.getTotalSummerHousePrice());
        System.out.println("Total All Houses Price: $" + service.getTotalAllHousesPrice());

        System.out.println("\nAverage Apartment Square Meter: " + service.getAverageApartmentSquareMeter() + " m²");
        System.out.println("Average Villa Square Meter: " + service.getAverageVillaSquareMeter() + " m²");
        System.out.println("Average Summer House Square Meter: " + service.getAverageSummerHouseSquareMeter() + " m²");
        System.out.println("Average All Houses Square Meter: " + service.getAverageAllHousesSquareMeter() + " m²");

        System.out.println("\nHouses with 3 rooms and 1 living room:");
        List<House> filteredHouses = service.filterHousesByRooms(3, 1);
        filteredHouses.forEach(house ->
                System.out.println(house.getName() + " - Price: $" + house.getPrice() +
                        " - " + house.getSquareMeter() + " m²"));
    }
}