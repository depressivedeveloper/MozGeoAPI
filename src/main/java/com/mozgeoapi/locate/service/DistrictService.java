package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.District;
import com.mozgeoapi.locate.model.Locality;
import com.mozgeoapi.locate.repository.DistrictRepository;
import com.mozgeoapi.locate.repository.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository repository;

    @Autowired
    private LocalityRepository localityRepository;

    public Locality addLocality(Locality locality, String districtUuid ){
        var district = repository.findByUuid(districtUuid);
        if(district!=null){
            if (district.getLocalityList() == null)district.setLocalityList(new ArrayList<>());
            district.getLocalityList().add(locality);
            district = repository.save(district);
            return district.getLocalityList().get(district.getLocalityList().size()-1);
        }
        return locality;
    }

    public District findDistrictById(Long id){
        return repository.findById(id).orElse(null);
    }

    public District findDistrictByName(String name){
        return repository.findByName(name);
    }

    public District findDistrictByUuid(String uuid){
        return repository.findByUuid(uuid);
    }

}
