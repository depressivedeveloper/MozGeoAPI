package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.District;
import com.mozgeoapi.locate.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repository;

    public District saveDistrict(District district){
        return repository.save(district);
    }

    public District getDistrictById(Long id){
        return repository.findById(id).orElse(null);
    }

}
