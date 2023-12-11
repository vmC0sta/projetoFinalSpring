package com.example.projetofinalspring.domain.endereco;

import jakarta.persistence.*;

@Entity
@Table(name = "municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String descricao;
    @ManyToOne
    private Estado estado;

    public Municipio() {
    }

    public Municipio(Long id, String descricao, Estado estado) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", estado=" + estado +
                '}';
    }
}
