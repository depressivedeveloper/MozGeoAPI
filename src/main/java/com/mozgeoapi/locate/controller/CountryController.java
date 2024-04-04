package com.mozgeoapi.locate.controller;

import com.mozgeoapi.locate.model.Country;
import com.mozgeoapi.locate.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@ResponseBody
@RequestMapping("/api")
public class CountryController {
    @Autowired
    private CountryService service;

    // Only for administrator
    @PostMapping("/country/save")
    public ResponseEntity<Country> save(@RequestBody Country country){
        var saved = service.saveCountry(country);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Only for administrator
    @GetMapping("/country/getAll")
    public ResponseEntity<List<Country>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    // For everyone
    @GetMapping("/country/{countryName}")
    public ResponseEntity<Country> getAll(@PathVariable String countryName){
        var country = service.findByName(countryName);
        if (country!=null) return new ResponseEntity<>(country, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
