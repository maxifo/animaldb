package hh.swd20.Animaldb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Animaldb.web.AnimaldbController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AnimaldbApplicationTests {

	@Autowired
	private AnimaldbController controller;

	@Test
	void contextLoads() throws Exception {

		assertThat(controller).isNotNull();
	}

}
