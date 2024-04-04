package com.mozgeoapi.locate.repository;

import com.mozgeoapi.locate.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findProvinceByUuid(String uuid);
    Province findProvinceByName(String uuid);
}
