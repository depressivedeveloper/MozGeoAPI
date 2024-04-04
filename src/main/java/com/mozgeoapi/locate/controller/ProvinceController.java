package com.mozgeoapi.locate.controller;

import com.mozgeoapi.locate.model.Province;
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
public class ProvinceController {
    @Autowired
    private ProvinceService service;

    // for administrator
    @PostMapping("/province/save")
    ResponseEntity<Province> saveProvince(@RequestBody Province province){
        var savedProvince = service.saveProvince(province);
        return new ResponseEntity<>(savedProvince, HttpStatus.CREATED);
    }

    // for everyone
    @GetMapping("/province/getById/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable("id") Long id) {
        var province = service.findProvinceById(id);
        if (province != null) {
            return new ResponseEntity<>(province, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //for everyone
    @GetMapping("/province/getByUuid/{uuid}")
    public ResponseEntity<Province> getProvinceByUuid(@PathVariable("uuid") String uuid) {
        var province = service.findProvinceByUuid(uuid);
        if (province != null) {
            return new ResponseEntity<>(province, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //for everyone
    @GetMapping("/province/getByName/{name}")
    public ResponseEntity<Province> getProvinceByName(@PathVariable("name") String name) {
        var province = service.findProvinceByUuid(name);
        if (province != null) {
            return new ResponseEntity<>(province, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // for everyone
    @GetMapping("/province/getAll")
    public ResponseEntity<List<Province>> getProvinceById() {
        var provinces = service.findAll();
        if (provinces != null && !provinces.isEmpty()) {
            return new ResponseEntity<>(provinces, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
