package br.com.fatecararas.f290_ds2_controle_funcionarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities.Cargo;
import br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities.Departamento;
import br.com.fatecararas.f290_ds2_controle_funcionarios.services.CargoService;
import br.com.fatecararas.f290_ds2_controle_funcionarios.services.DepartamentoService;

@Controller
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private CargoService cargoService;
    
    @GetMapping("/cadastro")
    public String cadastro(Cargo cargo) {
        return "cargo/cadastrar";
    }

    @PostMapping("/salvar")
    public String salva(Cargo cargo) {
        cargoService.salvar(cargo);
        return "redirect:/cargo/cadastro";
    }

    @GetMapping("/todos")
    public String cargos() {
        return "cargo/listar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> getDepartamentos() {
        return departamentoService.buscarTodos();
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos() {
        return cargoService.buscarTodos();
    }

}
