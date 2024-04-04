package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.Locality;
import com.mozgeoapi.locate.model.Neighborhood;
import com.mozgeoapi.locate.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LocalityService {
    @Autowired
    private LocalityRepository repository;

    @Autowired
    private DistrictService districtService;

    public Neighborhood addNeighborhood(Neighborhood neighborhood, String localityUuid ){
        var locality = repository.findByUuid(localityUuid);
        if(locality!=null){
            if (locality.getNeighborhoodList()==null) locality.setNeighborhoodList(new ArrayList<>());
            locality.getNeighborhoodList().add(neighborhood);
            locality = repository.save(locality);
            return locality.getNeighborhoodList().get(locality.getNeighborhoodList().size()-1);
        }
        return neighborhood;
    }

    public Locality saveLocality(Locality locality, String districtUuid){
        var saved = districtService.addLocality(locality, districtUuid);
        return saved;
    }

    public Locality getLocalityById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Locality finLocalityByName(String nome){
        return repository.findByName(nome);
    }


}
