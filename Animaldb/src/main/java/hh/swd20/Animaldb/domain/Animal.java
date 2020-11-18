package hh.swd20.Animaldb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String species;
	private String origin;

	@ManyToOne
	@JsonIgnoreProperties("animals")
	@JoinColumn(name = "typeid")
	private Type type;

	public Animal(Long id, String species, String origin) {
		super();
		this.id = id;
		this.species = species;
		this.origin = origin;
	}

	public Animal(String species, String origin, Type type) {
		super();
		this.species = species;
		this.origin = origin;
		this.type = type;
	}

	public Animal() {
		super();
		this.id = 0;
		this.species = null;
		this.origin = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		if (this.type != null)
			return "Animal [id=" + id + ", species=" + species + ", origin=" + origin + " type =" + this.getType()
					+ "]";
		else
			return "Animal [id=" + id + ", species=" + species + ", origin=" + origin + "]";

	}
}
