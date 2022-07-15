package org.bancojpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "agencia")
@Entity
public class Agencia {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String conta;

    @OneToMany(mappedBy = "agencia")
    private List<Numero> numeros;

    @ManyToMany
    @JoinTable(name = "agencia",
            joinColumns = @JoinColumn(name = "conta_id"),
             inverseJoinColumns = @JoinColumn(name = "cliente_id"))
    private List<Cliente> clientes;

}
