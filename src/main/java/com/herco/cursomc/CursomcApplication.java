package com.herco.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.herco.cursomc.domain.Categoria;
import com.herco.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { // para usar uma linha de comando ao de iniciar 
	
	// ser instanciado automaticamente
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informátia");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		// salvar no banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2)); // Arrays.asList é um macete dá hora
		
	}

}
