package com.raceco.apii.Repository;

import com.raceco.apii.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByCityNameAndBranchBranchId(String cityName, Long branchId);
    Optional<City> findByCityNameAndPostcode(String cityName, String postcode);


}
