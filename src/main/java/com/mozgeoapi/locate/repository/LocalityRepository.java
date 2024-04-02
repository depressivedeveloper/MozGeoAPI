package com.mozgeoapi.locate.repository;

import com.mozgeoapi.locate.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalityRepository extends JpaRepository<Locality, Long>{

}