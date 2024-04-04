package com.mozgeoapi.locate.controller;

import com.mozgeoapi.locate.model.District;
import com.mozgeoapi.locate.service.DistrictService;
import com.mozgeoapi.locate.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@ResponseBody
@RequestMapping("/api")
public class DistrictController {
    @Autowired
    DistrictService service;

    @Autowired
    ProvinceService provinceService;

    @GetMapping("/district/findAllByProvinceName/{provinceName}")
    public ResponseEntity<List<District>> findByProvinceName(@PathVariable String provinceName){
        var province = provinceService.findProvinceByName(provinceName);
        if (province!=null) return ResponseEntity.ok(province.getDistrictList());
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/district/findAllByProvinceUuid/{uuid}")
    public ResponseEntity<List<District>> findByProvinceUuid(@PathVariable String uuid){
        var province = provinceService.findProvinceByName(uuid);
        if (province!=null) return ResponseEntity.ok(province.getDistrictList());
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/district/findByName/{name}")
    public ResponseEntity<District> findName(@PathVariable String name){
        var district = service.findDistrictByName(name);
        if (district!=null) return ResponseEntity.ok(district);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/district/findByUuid/{uuid}")
    public ResponseEntity<District> findUuid(@PathVariable String uuid){
        var district = service.findDistrictByName(uuid);
        if (district!=null) return ResponseEntity.ok(district);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // for administrator
    @GetMapping("/district/findById/{id}")
    public ResponseEntity<District> findId(@PathVariable Long id){
        var district = service.findDistrictById(id);
        if (district!=null) return ResponseEntity.ok(district);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
