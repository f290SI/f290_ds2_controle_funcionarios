package br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "cargos")
public class Cargo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100, unique = true)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "departamento_id_fk")
    private Departamento departamento;

    @OneToMany(mappedBy = "cargo")
    List<Funcionario> funcionarios = new ArrayList<>();

    public Cargo() {
    }

    public Cargo(String descricao, Departamento departamento) {
        this.descricao = descricao;
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Cargo [id=" + id + ", descricao=" + descricao + ", departamento=" + departamento + ", funcionarios="
                + funcionarios + "]";
    }
    
}
