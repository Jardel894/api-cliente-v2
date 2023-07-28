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
import org.springframework.util.CollectionUtils;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneRequestDto {

    @Length(min = 2, max = 3)
    private String ddd;

    @Length(max = 30)
    private String numero;

    @Enumerated(EnumType.STRING)
    private TelefoneTipoEnum telefoneTipo;

    public static List<Telefone> toTelefoneList(List<TelefoneRequestDto> telefoneRequestDtoList) {
        if(CollectionUtils.isEmpty(telefoneRequestDtoList)){
            return null;
        }

        return telefoneRequestDtoList.stream()
                .map(TelefoneRequestDto::toTelefone)
                .toList();
    }

    public static Telefone toTelefone(TelefoneRequestDto telefoneRequestDto) {
        return Telefone.builder()
                .ddd(telefoneRequestDto.getDdd())
                .numero(telefoneRequestDto.getNumero())
                .telefoneTipo(telefoneRequestDto.getTelefoneTipo())
                .build();
    }

}
