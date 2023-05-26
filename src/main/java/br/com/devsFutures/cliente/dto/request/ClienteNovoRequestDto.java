package br.com.devsFutures.cliente.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteNovoRequestDto {

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;

}
