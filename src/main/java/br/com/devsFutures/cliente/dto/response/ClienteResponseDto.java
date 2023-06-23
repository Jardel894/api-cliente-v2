package br.com.devsFutures.cliente.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoResponse endereco;


}
