package br.com.fatecararas.f290_ds2_controle_funcionarios.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities.Departamento;
import br.com.fatecararas.f290_ds2_controle_funcionarios.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    public List<Departamento> buscarTodos() {
        return repository.findAll();
    }

    public Departamento salvar(Departamento pDepartamento) {
        Departamento d = new Departamento(pDepartamento.getDescricao());
        return repository.save(d);
    }

    public void apagar(Integer pId) {
        repository.deleteById(pId);
    }

    public Departamento atualizar(Departamento pDepartamento) {
        if (Objects.isNull(pDepartamento.getId())) {
            throw new RuntimeException("ID é obrigatório!");
        }
        // Tradicional
        Optional<Departamento> optDepto = repository.findById(pDepartamento.getId());

        if (optDepto.isEmpty()) {
            throw new RuntimeException(
                    String.format("Departamento não encontrado. ID: %s",
                            pDepartamento.getId()));
        }

        Departamento departamento = optDepto.get();
        departamento.setDescricao(pDepartamento.getDescricao());

        return repository.save(departamento);

        // Funcional
        // return repository
        // .findById(pDepartamento.getId())
        // .orElseThrow(() -> new RuntimeException(
        // String.format("Departamento não encontrado. ID: %s",
        // pDepartamento.getId())));
    }

    public Departamento buscarPorId(Integer pId) {
        Optional<Departamento> optDepartamento = repository.findById(pId);

        if (optDepartamento.isEmpty()) {
            throw new RuntimeException(String
                    .format("Id[%s] de departamento não localizado.", pId));
        }

        return optDepartamento.get();
    }

}
