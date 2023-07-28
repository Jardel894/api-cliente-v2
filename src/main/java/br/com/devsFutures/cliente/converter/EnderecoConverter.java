package br.com.devsFutures.cliente.converter;

import br.com.devsFutures.cliente.dto.request.EnderecoRequest;
import br.com.devsFutures.cliente.dto.response.EnderecoResponse;
import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.entities.Endereco;
import org.springframework.util.ObjectUtils;

public class EnderecoConverter {

    public static Endereco toEndereco(EnderecoRequest enderecoRequest, Cliente cliente) {
        if (ObjectUtils.isEmpty(enderecoRequest) || ObjectUtils.isEmpty(cliente)){
            return null;
        }

        return Endereco.builder()
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
        if (ObjectUtils.isEmpty(endereco)){
            return null;
        }

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