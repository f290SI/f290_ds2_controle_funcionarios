package br.com.fatecararas.f290_ds2_controle_funcionarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
    
}
