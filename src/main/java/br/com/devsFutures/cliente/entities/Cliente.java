package br.com.devsFutures.cliente.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    @Column(nullable = false)
    private String telefone;
}
