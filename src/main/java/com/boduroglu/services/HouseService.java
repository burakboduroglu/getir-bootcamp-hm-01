package com.boduroglu.services;

import com.boduroglu.models.Apartment;
import com.boduroglu.models.House;
import com.boduroglu.models.SummerHouse;
import com.boduroglu.models.Villa;
import com.boduroglu.repositories.HouseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseService {
    private final HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    // Get Total Price
    public double getTotalApartmentPrice() {
        return repository.getApartmentList().stream()
                .mapToDouble(Apartment::getPrice)
                .sum();
    }
    public double getTotalVillaPrice() {
        return repository.getVillaList().stream()
                .mapToDouble(Villa::getPrice)
                .sum();
    }
    public double getTotalSummerHousePrice() {
        return repository.getSummerHouseList().stream()
                .mapToDouble(SummerHouse::getPrice)
                .sum();
    }
    public double getTotalAllHousesPrice() {
        return getTotalApartmentPrice() + getTotalVillaPrice() + getTotalSummerHousePrice();
    }

    // Get Square Meter
    public double getAverageApartmentSquareMeter() {
        return repository.getApartmentList().stream()
                .mapToDouble(Apartment::getSquareMeter)
                .average()
                .orElse(0);
    }
    public double getAverageVillaSquareMeter() {
        return repository.getVillaList().stream()
                .mapToDouble(Villa::getSquareMeter)
                .average()
                .orElse(0);
    }
    public double getAverageSummerHouseSquareMeter() {
        return repository.getSummerHouseList().stream()
                .mapToDouble(SummerHouse::getSquareMeter)
                .average()
                .orElse(0);
    }
    public double getAverageAllHousesSquareMeter() {
        double totalSquareMeter =
                repository.getApartmentList().stream().mapToDouble(Apartment::getSquareMeter).sum() +
                        repository.getVillaList().stream().mapToDouble(Villa::getSquareMeter).sum() +
                        repository.getSummerHouseList().stream().mapToDouble(SummerHouse::getSquareMeter).sum();

        int totalCount =
                repository.getApartmentList().size() +
                        repository.getVillaList().size() +
                        repository.getSummerHouseList().size();
        return totalCount > 0 ? totalSquareMeter / totalCount : 0;
    }

    // Filter by Room and Saloon Count
    public List<House> filterHousesByRooms(int roomCount, int livingRoomCount) {
        List<House> filtered = new ArrayList<>();
        filtered.addAll(repository.getApartmentList().stream()
                .filter(h -> h.getRoomCount() == roomCount && h.getLivingRoomCount() == livingRoomCount)
                .toList());
        filtered.addAll(repository.getVillaList().stream()
                .filter(h -> h.getRoomCount() == roomCount && h.getLivingRoomCount() == livingRoomCount)
                .toList());
        filtered.addAll(repository.getSummerHouseList().stream()
                .filter(h -> h.getRoomCount() == roomCount && h.getLivingRoomCount() == livingRoomCount)
                .toList());
        return filtered;
    }
}
