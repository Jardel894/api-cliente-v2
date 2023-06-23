package br.com.devsFutures.cliente.converter;

import br.com.devsFutures.cliente.dto.request.ClienteNovoRequestDto;
import br.com.devsFutures.cliente.dto.response.ClienteResponseDto;
import br.com.devsFutures.cliente.dto.response.CustomPageDto;
import br.com.devsFutures.cliente.dto.response.EnderecoResponse;
import br.com.devsFutures.cliente.dto.response.PageDto;
import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.entities.Endereco;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteConverter {

    public static Cliente toCliente(ClienteNovoRequestDto clienteNovoRequestDto) {
        return Cliente.builder()
                .nome(clienteNovoRequestDto.getNome())
                .cpf(clienteNovoRequestDto.getCpf())
                .email(clienteNovoRequestDto.getEmail())
                .telefone(clienteNovoRequestDto.getTelefone())
                .build();
    }

    public static ClienteResponseDto toClienteResponseDto(Cliente cliente) {
        return ClienteResponseDto.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .endereco(EnderecoResponse.builder()
                        .bairro(cliente.getEndereco().getBairro())
                        .cep(cliente.getEndereco().getCep())
                        .complemento(cliente.getEndereco().getComplemento())
                        .uf(cliente.getEndereco().getUf())
                        .localidade(cliente.getEndereco().getLocalidade())
                        .logradouro(cliente.getEndereco().getLogradouro())
                        .numero(cliente.getEndereco().getNumero())
                        .build())
                .telefone(cliente.getTelefone())
                .build();
    }

    public static PageDto<ClienteResponseDto> toClientePageResponseDto(Page<Cliente> clientePage) {
        PageDto<ClienteResponseDto> clienteResponseDtos = new PageDto<>();

        List<ClienteResponseDto> responseDtos = clientePage.getContent()
                .stream()
                .map(cliente -> ClienteResponseDto.builder()
                        .nome(cliente.getNome())
                        .cpf(cliente.getCpf())
                        .endereco(EnderecoResponse.builder()
                                .bairro(cliente.getEndereco().getBairro())
                                .cep(cliente.getEndereco().getCep())
                                .complemento(cliente.getEndereco().getComplemento())
                                .uf(cliente.getEndereco().getUf())
                                .localidade(cliente.getEndereco().getLocalidade())
                                .logradouro(cliente.getEndereco().getLogradouro())
                                .numero(cliente.getEndereco().getNumero())
                                .build())
                        .email(cliente.getEmail())
                        .telefone(cliente.getTelefone())
                        .build()).collect(Collectors.toList());

        clienteResponseDtos.setContent(responseDtos);

        CustomPageDto customPageDto = CustomPageDto.builder()
                .totalPages(clientePage.getTotalPages())
                .totalElements(clientePage.getTotalElements())
                .number(clientePage.getNumber())
                .size(clientePage.getSize())
                .build();

        clienteResponseDtos.setCustomPageDto(customPageDto);
        return clienteResponseDtos;
    }
}
