package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.Province;
import com.mozgeoapi.locate.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository repository;

    public Province saveProvince(Province province){
        return repository.save(province);
    }

    public Province getProvinceById(Long id){
        return repository.findById(id).orElse(null);
    }
}
