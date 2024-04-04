package com.mozgeoapi.locate.repository;

import com.mozgeoapi.locate.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String countryName);
}
