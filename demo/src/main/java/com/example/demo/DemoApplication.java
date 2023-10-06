package com.example.demo;

import com.example.demo.entities.Localidad;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	LocalidadRepository localidadRepository;
	@Autowired
	PersonaRepository personaRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepository, AutorRepository autorRepository, DomicilioRepository domicilioRepository, LibroRepository libroRepository, LocalidadRepository localidadRepository) {
		return args -> {

			for(int i = 0; i<=15; i++){
				Localidad localidad  = Localidad.builder()
						.denominacion("localicadPrueba")
						.build();
				localidadRepository.save(localidad);
				Domicilio domicilio = Domicilio.builder()
						.calle("calleprueba")
						.numero(31312)
						.localidad(localidad)
						.build();
				domicilioRepository.save(domicilio);
				Persona persona = Persona.builder()
						.nombre("giova")
						.apellido("cirrin")
						.domicilio(domicilio)
						.dni(342432)
						.build();
				personaRepository.save(persona);
				Libro libro = Libro.builder()
						.fecha(23)
						.genero("genero: "+1)
						.titulo("title")
						.paginas(2)
						.persona(persona)
						.build();
				libroRepository.save(libro);
				Autor autor = Autor.builder()
						.nombre("nombre")
						.apellido("apellido")
						.biografia("un capo")
						.build();
				autorRepository.save(autor);
			}

		};
	}
}