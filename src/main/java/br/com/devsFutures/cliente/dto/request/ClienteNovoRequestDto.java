package br.com.devsFutures.cliente.dto.request;

import br.com.devsFutures.cliente.entities.Endereco;
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
    private EnderecoRequest endereco;
    private String telefone;

}
