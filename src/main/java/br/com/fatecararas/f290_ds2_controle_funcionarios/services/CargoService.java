package br.com.fatecararas.f290_ds2_controle_funcionarios.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities.Cargo;
import br.com.fatecararas.f290_ds2_controle_funcionarios.repositories.CargoRepository;

@Service
public class CargoService {
    
    private CargoRepository repository;

    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Cargo cargo) {
        repository.save(cargo);
    }

    public List<Cargo> buscarTodos() {
        return repository.findAll();
    }
    
}
