package br.com.fatecararas.f290_ds2_controle_funcionarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities.Departamento;
import br.com.fatecararas.f290_ds2_controle_funcionarios.repositories.DepartamentoRepository;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	private DepartamentoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Departamento> departamentos = repository.findAll();
		System.out.println(departamentos);

		Optional<Departamento> optDepartamento = repository.findById(2);

		optDepartamento.ifPresent(System.out::println);

		Departamento d1 = new Departamento("Jurídico");

		repository.save(d1);

		Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		
		System.out.println(gson.toJson(repository.findAll()));
	}

}
