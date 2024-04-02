package com.mozgeoapi.locate.controller;

import com.mozgeoapi.locate.model.Province;
import com.mozgeoapi.locate.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@ResponseBody
@RequestMapping("/api")
public class ProvinceController {
    @Autowired
    ProvinceService service;

    @PostMapping("/province-save")
    ResponseEntity<Province> saveProvince(@RequestBody Province province){
        var savedProvince = service.saveProvince(province);
        return new ResponseEntity<>(savedProvince, HttpStatus.CREATED);
    }

    @GetMapping("/province-getById/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable("id") Long id) {
        var province = service.getProvinceById(id);
        if (province != null) {
            return new ResponseEntity<>(province, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
