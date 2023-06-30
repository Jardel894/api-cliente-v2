package br.com.devsFutures.cliente.dto.request;

import br.com.devsFutures.cliente.entities.Telefone;
import br.com.devsFutures.cliente.enums.TelefoneTipoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefonePutRequestDto {

    private UUID uuid;

    @Length(min = 2, max = 3)
    private String ddd;

    @Length(max = 30)
    private String numero;

    @Enumerated(EnumType.STRING)
    private TelefoneTipoEnum telefoneTipo;

}
