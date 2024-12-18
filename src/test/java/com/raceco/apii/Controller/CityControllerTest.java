package com.raceco.apii.Controller;

import com.raceco.apii.Entity.City;
import com.raceco.apii.Service.CityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CityControllerTest {
    @InjectMocks
    private CityController cityController;

    @Mock
    private CityService cityService;

    @Test
     void testAddCity() {
        City city = new City();
        city.setCityId(1L);
        city.setCityName("New York");
        city.setPostcode("10001");

        when(cityService.addCity(any(City.class))).thenReturn(city);

        ResponseEntity<City> response = cityController.addCity(city);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getCityName()).isEqualTo("New York");
        verify(cityService, times(1)).addCity(any(City.class));
    }

    @Test
    void testGetAllCities() {
        City city1 = new City();
        city1.setCityId(1L);
        city1.setCityName("New York");

        City city2 = new City();
        city2.setCityId(2L);
        city2.setCityName("Los Angeles");

        List<City> cities = Arrays.asList(city1, city2);

        when(cityService.getAllCities()).thenReturn(cities);

        ResponseEntity<List<City>> response = cityController.getAllCities();

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getCityName()).isEqualTo("New York");
        assertThat(response.getBody().get(1).getCityName()).isEqualTo("Los Angeles");
        verify(cityService, times(1)).getAllCities();
    }

    @Test
    void testGetCityById() {
        City city = new City();
        city.setCityId(1L);
        city.setCityName("New York");

        when(cityService.getCityById(1L)).thenReturn(city);

        ResponseEntity<City> response = cityController.getCityById(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getCityName()).isEqualTo("New York");
        verify(cityService, times(1)).getCityById(1L);
    }

    @Test
    void testDeleteCity() {
        doNothing().when(cityService).deleteCity(1L);

        ResponseEntity<Void> response = cityController.deleteCity(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(cityService, times(1)).deleteCity(1L);
    }
}
