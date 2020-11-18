package hh.swd20.Animaldb;

import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import hh.swd20.Animaldb.domain.Animal;
import hh.swd20.Animaldb.domain.AnimalRepo;
import hh.swd20.Animaldb.domain.Type;
import hh.swd20.Animaldb.domain.TypeRepo;
import hh.swd20.Animaldb.domain.User;
import hh.swd20.Animaldb.domain.UserRepo;

@SpringBootApplication
public class AnimaldbApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(AnimaldbApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;

	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public CommandLineRunner demo(AnimalRepo animalrepo, TypeRepo typerepo, UserRepo userrepo) {
		return (args) -> {

			Type type1 = new Type("Fish");
			Type type2 = new Type("Feline");
			Type type3 = new Type("Canine");
			Type type4 = new Type("Reptile");
			Type type5 = new Type("Insect");
			typerepo.save(type1);
			typerepo.save(type2);
			typerepo.save(type3);
			typerepo.save(type4);
			typerepo.save(type5);
			animalrepo.save(new Animal("Blue Whale", "Atlantic Ocean", type1));
			animalrepo.save(new Animal("Lion", "Africa", type2));
			animalrepo.save(new Animal("German Shepherd", "Europe", type3));
			animalrepo.save(new Animal("Cobra", "Asia", type4));
			animalrepo.save(new Animal("Black Widow", "Africa", type5));

			User user1 = new User("admin", "$2a$10$gopPaJU/z8c6NRJOgNx7UONhZj6a1W0Yfb3d0Nn8GMLRTgZP3UGLe", "ADMIN");
			userrepo.save(user1);
			User user2 = new User("guest", "$2a$10$MOyw8eMWyYkHNykQpZ1pxO8Y39/VnaR4WWVNgEmWX.o/oQ6K5X1Fe", "USER");
			userrepo.save(user2);

		};

	}
}