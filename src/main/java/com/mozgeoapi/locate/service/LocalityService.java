package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.Locality;
import com.mozgeoapi.locate.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalityService {
    @Autowired
    private LocalityRepository repository;

    public Locality saveLocality(Locality locality){
        var saved = repository.save(locality);
        return saved;
    }

    public Locality getLocalityById(Long id){
        return repository.findById(id).orElse(null);
    }
}
