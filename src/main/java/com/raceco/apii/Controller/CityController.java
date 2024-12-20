package com.raceco.apii.Controller;

import com.raceco.apii.Entity.City;
import com.raceco.apii.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.addCity(city));
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> getCityById(@PathVariable Long cityId) {
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long cityId) {
        cityService.deleteCity(cityId);
        return ResponseEntity.noContent().build();
    }
}
