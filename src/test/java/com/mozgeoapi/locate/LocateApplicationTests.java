package com.mozgeoapi.locate;

import com.mozgeoapi.locate.model.Country;
import com.mozgeoapi.locate.model.District;
import com.mozgeoapi.locate.model.Province;
import com.mozgeoapi.locate.repository.CountryRepository;
import com.mozgeoapi.locate.repository.ProvinceRepository;
import org.apache.logging.slf4j.SLF4JLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@SpringBootTest
class LocateApplicationTests {
	@Autowired
	ProvinceRepository repository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	ProvinceRepository provinceRepository;

	@Test
	void contextLoads() {

		var p = new Province();
		p = provinceRepository.findProvinceByUuid("990dacc8-6494-417b-9396-8c9ad18a4cb8");
		System.out.println("PROVINCIA: "+p);

		var d =  new District("Marracuene");
		if (p.getDistrictList() == null) p.setDistrictList(new ArrayList<>());
//		p.getDistrictList().add(d);
//		p= provinceRepository.save(p);
		var c = countryRepository.findById(1L).get();
		System.out.println(c);
		System.out.println(p);
	}

}
