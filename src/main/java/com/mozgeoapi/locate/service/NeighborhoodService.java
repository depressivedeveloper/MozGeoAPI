package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.Neighborhood;
import com.mozgeoapi.locate.repository.NeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeighborhoodService {
    @Autowired
    private NeighborhoodRepository repository;

    @Autowired
    private LocalityService localityService;

    public Neighborhood saveNeighborhood(Neighborhood neighborhood, String localityUuid){
        return localityService.addNeighborhood(neighborhood, localityUuid);
    }

    public Neighborhood getNeighborhoodById(Long id){
        return repository.findById(id).orElse(null);
    }
}
