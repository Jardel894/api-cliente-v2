package br.com.devsFutures.cliente.dto.request;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePutRequestDto {

    private String nome;
    private EnderecoRequest endereco;
    private String email;
    private List<TelefonePutRequestDto> telefones;
}
