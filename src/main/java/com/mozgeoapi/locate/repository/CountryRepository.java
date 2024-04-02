package com.mozgeoapi.locate.repository;

import com.mozgeoapi.locate.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
