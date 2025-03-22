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
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    // Get Total Price
    public double getTotalApartmentPrice() {
        return houseRepository.getApartmentList().stream()
                .mapToDouble(Apartment::getPrice)
                .sum();
    }

    public double getTotalVillaPrice() {
        return houseRepository.getVillaList().stream()
                .mapToDouble(Villa::getPrice)
                .sum();
    }

    public double getTotalSummerHousePrice() {
        return houseRepository.getSummerHouseList().stream()
                .mapToDouble(SummerHouse::getPrice)
                .sum();
    }

    public double getTotalAllHousesPrice() {
        return getTotalApartmentPrice() + getTotalVillaPrice() + getTotalSummerHousePrice();
    }

    // Get Square Meter
    public double getAverageApartmentSquareMeter() {
        return houseRepository.getApartmentList().stream()
                .mapToDouble(Apartment::getSquareMeter)
                .average()
                .orElse(0);
    }

    public double getAverageVillaSquareMeter() {
        return houseRepository.getVillaList().stream()
                .mapToDouble(Villa::getSquareMeter)
                .average()
                .orElse(0);
    }

    public double getAverageSummerHouseSquareMeter() {
        return houseRepository.getSummerHouseList().stream()
                .mapToDouble(SummerHouse::getSquareMeter)
                .average()
                .orElse(0);
    }

    public double getAverageAllHousesSquareMeter() {
        double totalSquareMeter =
                houseRepository.getApartmentList().stream().mapToDouble(Apartment::getSquareMeter).sum() +
                        houseRepository.getVillaList().stream().mapToDouble(Villa::getSquareMeter).sum() +
                        houseRepository.getSummerHouseList().stream().mapToDouble(SummerHouse::getSquareMeter).sum();

        int totalCount =
                houseRepository.getApartmentList().size() +
                        houseRepository.getVillaList().size() +
                        houseRepository.getSummerHouseList().size();
        return totalCount > 0 ? totalSquareMeter / totalCount : 0;
    }

    // Filter by Room and Saloon Count
    public List<House> filterHousesByRooms(int roomCount, int livingRoomCount) {
        List<House> filtered = new ArrayList<>();
        houseRepository.getHouseList().stream()
                .filter(h -> h.getRoomCount() == roomCount && h.getLivingRoomCount() == livingRoomCount)
                .collect(Collectors.toList());
        return filtered;
    }
}
