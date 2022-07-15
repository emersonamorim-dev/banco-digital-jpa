package org.bancojpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "banco")
@Entity
public class Banco {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "banco")
    private List<Cliente> clientes;

    @JoinTable(name ="conta",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "conta_id"))
    private  List<Cliente> cliente;

    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas;
}
