package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.val;

@SpringBootApplication
public class DemoApplication
		implements CommandLineRunner {

	@Autowired
	private UsuarioRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		for (long i = 0; i < 100; i++) {
			val entity = new Usuario();
			entity.setId(i);
			entity.setNome(String.format("name is %s %s", "Adriano", i));
			repo.save(entity);
		}

		QUsuario usuario = QUsuario.usuario;
		val exp = usuario.nome.contains("Adriano");
		for (val item : repo.findAll(exp)) {
			System.out.printf(item.toString());	
		}

	}

}
