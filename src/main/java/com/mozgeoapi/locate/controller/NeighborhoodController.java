package com.mozgeoapi.locate.controller;

import com.mozgeoapi.locate.model.Neighborhood;
import com.mozgeoapi.locate.service.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@ResponseBody
@RequestMapping("/api")
public class NeighborhoodController {
    @Autowired
    NeighborhoodService service;

    @PostMapping("/neighborhood/save/{localityUuid}")
    ResponseEntity<Neighborhood> saveNeighborhood(@RequestBody Neighborhood neighborhood, @PathVariable String localityUuid){
        var savedNeighborhood = service.saveNeighborhood(neighborhood, localityUuid);
        return new ResponseEntity<>(savedNeighborhood, HttpStatus.CREATED);
    }

    @GetMapping("/neighborhood/getById/{id}")
    public ResponseEntity<Neighborhood> getNeighborhoodById(@PathVariable("id") Long id) {
        var neighborhood = service.getNeighborhoodById(id);
        if (neighborhood != null) {
            return new ResponseEntity<>(neighborhood, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
