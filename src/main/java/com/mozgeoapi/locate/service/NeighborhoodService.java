package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.District;
import com.mozgeoapi.locate.model.Neighborhood;
import com.mozgeoapi.locate.repository.DistrictRepository;
import com.mozgeoapi.locate.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeighborhoodService {
    @Autowired
    private NeighborhoodRepository repository;

    public Neighborhood saveNeighborhood(Neighborhood neighborhood){
        return repository.save(neighborhood);
    }

    public Neighborhood getNeighborhoodById(Long id){
        return repository.findById(id).orElse(null);
    }
}
