package br.com.devsFutures.cliente.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_endereco")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column
    private String cep;
    @Column
    private String logradouro;
    @Column
    private String complemento;
    @Column
    private String bairro;
    @Column
    private String localidade;
    @Column
    private String uf;
    @Column
    private Integer numero;

    @OneToOne
    @MapsId
    @JoinColumn(name ="cliente_id")
    private Cliente cliente;

}
