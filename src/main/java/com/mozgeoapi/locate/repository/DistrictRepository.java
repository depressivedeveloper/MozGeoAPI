package com.mozgeoapi.locate.repository;

import com.mozgeoapi.locate.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    District findByName(String name);
    District findByUuid(String uuid);
}
