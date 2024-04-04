package com.mozgeoapi.locate.service;

import com.mozgeoapi.locate.model.District;
import com.mozgeoapi.locate.model.Province;
import com.mozgeoapi.locate.repository.CountryRepository;
import com.mozgeoapi.locate.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository repository;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CountryRepository countryRepository;

    public Province saveProvince(Province province){
        var country = countryService.getCountryById(1L);
        country.getProvinceList().add(province);
        country = countryRepository.save(country);
        if (!country.getProvinceList().isEmpty()) province = country.getProvinceList().get(country.getProvinceList().size()-1);
        return province;
    }

    // Associating a new district to their province
    public District addDistrict(District district, String provinceUuid ){
        var province = repository.findProvinceByUuid(provinceUuid);
        if(province!=null){

            province.getDistrictList().add(district);
            province = repository.save(province);
            return province.getDistrictList().get(province.getDistrictList().size()-1);
        }
        return district;
    }

    public Province findProvinceById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Province> findAll() {
        return repository.findAll();
    }

    public Province findProvinceByUuid(String uuid) {
        return repository.findProvinceByUuid(uuid);
    }

    public Province findProvinceByName(String name) {
        return repository.findProvinceByName(name);
    }

}
