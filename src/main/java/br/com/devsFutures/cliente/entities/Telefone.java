package br.com.devsFutures.cliente.entities;

import br.com.devsFutures.cliente.enums.TelefoneTipoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_telefone")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(length = 3)
    private String ddd;

    @Column(length = 30, unique = true)
    private String numero;

    @Enumerated(EnumType.STRING)
    private TelefoneTipoEnum telefoneTipo;

}
