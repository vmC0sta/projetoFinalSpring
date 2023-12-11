package com.example.projetofinalspring.domain.endereco;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(Long id, String descricao, Pais pais) {
        this.id = id;
        this.descricao = descricao;
        this.pais = pais;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", pais=" + pais +
                '}';
    }
}
