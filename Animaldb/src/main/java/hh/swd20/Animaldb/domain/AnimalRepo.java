package hh.swd20.Animaldb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnimalRepo extends CrudRepository<Animal, Long> {
	List<Animal> findBySpecies(String Species);

}
