package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.Country;
import com.mozgeoapi.locate.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public Country saveCountry(Country country){
        return repository.save(country);
    }

    public Country getCountryById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Country> getAll(){
        return repository.findAll();
    }

    public Country findByName(String countryName) {
        return repository.findByName(countryName);
    }
}
