package hh.swd20.Animaldb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Animaldb.domain.Animal;
import hh.swd20.Animaldb.domain.AnimalRepo;
import hh.swd20.Animaldb.domain.Type;
import hh.swd20.Animaldb.domain.TypeRepo;

@Controller
public class AnimaldbController {

	@Autowired
	private AnimalRepo animalrepo;
	@Autowired
	private TypeRepo typerepo;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mainpage() {
		return "animaldb";
	}

	@RequestMapping(value = "/animals", method = RequestMethod.GET)
	public String getAnimals(Model model) {

		model.addAttribute("animals", animalrepo.findAll());
		return "animals";
	}

	@RequestMapping(value = "/add")
	public String addAnimal(Model model) {
		model.addAttribute("animal", new Animal());
		model.addAttribute("types", typerepo.findAll());
		return "addanimal";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteAnimal(@PathVariable("id") Long id, Model model) {
		animalrepo.deleteById(id);
		return "redirect:../animals";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Animal animal) {
		animalrepo.save(animal);
		return "redirect:animals";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editAnimal(@PathVariable("id") Long id, Model model) {
		model.addAttribute("animal", animalrepo.findById(id));
		return "editanimal";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/typelist", method = RequestMethod.GET)
	public String getTypes(Model model) {
		model.addAttribute("types", typerepo.findAll());
		return "typelist";
	}

	@RequestMapping(value = "/addtype", method = RequestMethod.GET)
	public String addType(Model model) {
		model.addAttribute("type", new Type());
		return "newtype";
	}

	@RequestMapping(value = "/savetype", method = RequestMethod.POST)
	public String save(Type type) {
		typerepo.save(type);
		return "redirect:typelist";
	}

	@RequestMapping(value = "/api/animals", method = RequestMethod.GET)
	public @ResponseBody List<Animal> animalsREST() {
		return (List<Animal>) animalrepo.findAll();
	}

	@RequestMapping(value = "/api/animals/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Animal> getAnimalRest(@PathVariable("id") Long id) {
		return animalrepo.findById(id);
	}

	@RequestMapping(value = "/api/animals", method = RequestMethod.POST)
	public @ResponseBody Animal saveAnimalREST(@RequestBody Animal animal) {
		animalrepo.save(animal);
		return animal;
	}
}
