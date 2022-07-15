package org.bancojpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bancojpa.BancoDigital;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cliente")
@Entity
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy = "cliente")
    private List<Banco> bancos;

    @ManyToOne
    @JoinColumn(name = "transferencia_id")
    private Transferencia transferencia;

    public void setBancoDigital(BancoDigital bancodigital) {
        Object o = new Object();
    }
}
