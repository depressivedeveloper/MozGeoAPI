package com.mozgeoapi.locate;

import com.mozgeoapi.locate.model.Province;
import com.mozgeoapi.locate.repository.ProvinceRepository;
import org.apache.logging.slf4j.SLF4JLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
class LocateApplicationTests {
	@Autowired
	ProvinceRepository repository;

	@Test
	void contextLoads() {

	}

}
