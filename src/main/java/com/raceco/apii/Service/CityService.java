package com.raceco.apii.Service;

import com.raceco.apii.Entity.City;

import java.util.List;

public interface CityService {
    City addCity(City city);
    List<City> getAllCities();
    City getCityById(Long cityId);
    void deleteCity(Long cityId);
}
