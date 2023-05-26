package br.com.devsFutures.cliente.converter;

import br.com.devsFutures.cliente.dto.request.ClienteNovoRequestDto;
import br.com.devsFutures.cliente.dto.response.ClienteResponseDto;
import br.com.devsFutures.cliente.entities.Cliente;

public class ClienteConverter {

    public static Cliente toCliente(ClienteNovoRequestDto clienteNovoRequestDto){
        return Cliente.builder()
                .nome(clienteNovoRequestDto.getNome())
                .cpf(clienteNovoRequestDto.getCpf())
                .email(clienteNovoRequestDto.getEmail())
                .telefone(clienteNovoRequestDto.getTelefone())
                .endereco(clienteNovoRequestDto.getEndereco())
                .build();
    }

    public static ClienteResponseDto toClienteResponseDto(Cliente cliente) {
        return ClienteResponseDto.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .telefone(cliente.getTelefone())
                .build();
    }
}
