package br.com.devsFutures.cliente.converter;

import br.com.devsFutures.cliente.dto.request.EnderecoRequest;
import br.com.devsFutures.cliente.dto.response.EnderecoResponse;
import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.entities.Endereco;

public class EnderecoConverter {

    public static Endereco toEndereco(EnderecoRequest enderecoRequest, Cliente cliente) {

        return Endereco.builder()
                .cliente(cliente)
                .bairro(enderecoRequest.getBairro())
                .cep(enderecoRequest.getCep())
                .uf(enderecoRequest.getUf())
                .complemento(enderecoRequest.getComplemento())
                .localidade(enderecoRequest.getLocalidade())
                .numero(enderecoRequest.getNumero())
                .logradouro(enderecoRequest.getLogradouro())
                .build();
    }

    public static EnderecoResponse toEnderecoResponseDto(Endereco endereco) {

        return EnderecoResponse.builder()
                .bairro(endereco.getBairro())
                .cep(endereco.getCep())
                .complemento(endereco.getComplemento())
                .uf(endereco.getUf())
                .localidade(endereco.getLocalidade())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .build();


    }
}