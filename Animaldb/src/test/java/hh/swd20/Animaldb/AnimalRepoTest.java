package hh.swd20.Animaldb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Animaldb.domain.Animal;
import hh.swd20.Animaldb.domain.AnimalRepo;

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class AnimalRepoTest {

	@Autowired
	private AnimalRepo repo;

	@Test
	public void findBySpecies() {
		List<Animal> animals = repo.findBySpecies("Lion");

		assertThat(animals).hasSize(1);
		assertThat(animals.get(0).getSpecies()).isEqualTo("Lion");
	}

	@Test
	public void addNewBAnimal() {
		Animal animal = new Animal("Test", "Test", null);
		repo.save(animal);
		assertThat(animal.getId()).isNotNull();
	}

}