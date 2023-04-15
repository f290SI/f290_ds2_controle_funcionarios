package br.com.fatecararas.f290_ds2_controle_funcionarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities.Departamento;
import br.com.fatecararas.f290_ds2_controle_funcionarios.services.DepartamentoService;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping("/todos")
    public String departamentos(Model model) {
        List<Departamento> todos = service.buscarTodos();
        model.addAttribute("departamentos", todos);
        return "departamentos";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Departamento departamento) {
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamento/todos";
    }

    @PostMapping("/atualizar")
    public String atualizar(Departamento departamento) {
        service.atualizar(departamento);
        return "redirect:/departamento/todos";
    }

    @GetMapping("/editar/{id}")
    public String preEdicao(@PathVariable("id") Integer id, ModelMap model) {
        Departamento departamento = service.buscarPorId(id);
        model.addAttribute("departamento", departamento);

        return "/cadastrar";
    }   

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        service.apagar(id);
        return "redirect:/departamento/todos";
    }

    // @ModelAttribute(name = "departamentos")
    // public List<Departamento> getAll() {
    //     return service.buscarTodos();
    // }
    
}
