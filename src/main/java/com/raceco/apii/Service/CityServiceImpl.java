package com.raceco.apii.Service;

import com.raceco.apii.Entity.City;
import com.raceco.apii.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService{

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(()->new RuntimeException("City not found with ID:"+cityId));
    }

    @Override
    public void deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
