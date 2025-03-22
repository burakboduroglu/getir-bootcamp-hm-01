package com.boduroglu.repositories;

import com.boduroglu.models.Apartment;
import com.boduroglu.models.House;
import com.boduroglu.models.SummerHouse;
import com.boduroglu.models.Villa;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository {
    private final List<Apartment> apartments;
    private final List<Villa> villas;
    private final List<SummerHouse> summerHouses;

    public HouseRepository() {
        apartments = new ArrayList<>();
        villas = new ArrayList<>();
        summerHouses = new ArrayList<>();

        // Creating 3 instances of each type
        apartments.add(new Apartment("Apartment 1", 100000, 80, 2, 1));
        apartments.add(new Apartment("Apartment 2", 150000, 100, 3, 1));
        apartments.add(new Apartment("Apartment 3", 120000, 90, 2, 1));

        villas.add(new Villa("Villa 1", 300000, 200, 4, 2));
        villas.add(new Villa("Villa 2", 350000, 250, 5, 2));
        villas.add(new Villa("Villa 3", 280000, 180, 4, 1));

        summerHouses.add(new SummerHouse("SummerHouse 1", 200000, 150, 3, 1));
        summerHouses.add(new SummerHouse("SummerHouse 2", 230000, 160, 3, 2));
        summerHouses.add(new SummerHouse("SummerHouse 3", 180000, 140, 2, 1));
    }

    public List<House> getHouseList() {
        List<House> houses = new ArrayList<>();
        houses.addAll(apartments);
        houses.addAll(villas);
        houses.addAll(summerHouses);
        return houses;
    }
    public List<Apartment> getApartmentList() { return apartments; }
    public List<Villa> getVillaList() { return villas; }
    public List<SummerHouse> getSummerHouseList() { return summerHouses; }
}
