package com.pedro.study.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id ")
    private Integer id;

    @Column(name = "nome" , length = 100)
    @NotEmpty(message = "Campo nome e obrigatorio")
    private String nome;

    @Column(name = "cpf" , length = 11)
    @NotEmpty(message = "Campo cpf obrigatorio")
    private String cpf;

    @JsonIgnore
    @OneToMany( mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
}
