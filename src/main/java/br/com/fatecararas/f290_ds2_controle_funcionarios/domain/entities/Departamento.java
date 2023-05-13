package br.com.fatecararas.f290_ds2_controle_funcionarios.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "departamentos")
public class Departamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String descricao;

    @OneToMany(mappedBy = "departamento")
    List<Cargo> cargos = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String descricao) {
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "Departamento [id=" + id + ", descricao=" + descricao + "]";
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}
