package com.mozgeoapi.locate.repository;

import com.mozgeoapi.locate.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long>{
    Locality findByUuid(String localityUuid);
    Locality findByName(String nome);
}