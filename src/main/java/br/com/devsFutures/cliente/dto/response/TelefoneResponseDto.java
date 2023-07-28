package br.com.devsFutures.cliente.dto.response;

import br.com.devsFutures.cliente.dto.request.TelefoneRequestDto;
import br.com.devsFutures.cliente.entities.Telefone;
import br.com.devsFutures.cliente.enums.TelefoneTipoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneResponseDto {

    private UUID uuid;
    private String ddd;
    private String numero;
    private TelefoneTipoEnum telefoneTipo;

    public static List<TelefoneResponseDto> toTelefoneResponseDtoList(List<Telefone> telefoneList) {
        return telefoneList.stream()
                .map(TelefoneResponseDto::toTelefoneResponseDto)
                .toList();
    }

    public static TelefoneResponseDto toTelefoneResponseDto(Telefone telefone) {
        return TelefoneResponseDto.builder()
                .ddd(telefone.getDdd())
                .numero(telefone.getNumero())
                .telefoneTipo(telefone.getTelefoneTipo())
                .build();
    }

}
