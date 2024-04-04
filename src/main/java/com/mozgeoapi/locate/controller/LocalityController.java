package com.mozgeoapi.locate.controller;

import com.mozgeoapi.locate.model.Locality;
import com.mozgeoapi.locate.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@ResponseBody
@RequestMapping("/api")
public class LocalityController {
    @Autowired
    LocalityService localityService;

    @GetMapping("/locality/findByName")
    public ResponseEntity<Locality> findLocalityByName(@PathVariable String name){
        var locality = localityService.finLocalityByName(name);
        if (locality!=null) return ResponseEntity.ok(locality);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }



}
