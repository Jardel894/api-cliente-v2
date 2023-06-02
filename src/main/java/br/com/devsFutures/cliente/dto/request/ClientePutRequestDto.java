package br.com.devsFutures.cliente.dto.request;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePutRequestDto {

    private String nome;
    private String endereco;
    private String email;
    private String telefone;
}
