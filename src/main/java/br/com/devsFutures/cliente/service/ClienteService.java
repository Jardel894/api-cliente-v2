package br.com.devsFutures.cliente.service;

import br.com.devsFutures.cliente.dto.request.ClienteNovoRequestDto;
import br.com.devsFutures.cliente.dto.request.ClientePutRequestDto;
import br.com.devsFutures.cliente.dto.response.ClienteResponseDto;
import br.com.devsFutures.cliente.dto.response.PageDto;
import br.com.devsFutures.cliente.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.UUID;

public interface ClienteService {

     ClienteResponseDto criar(ClienteNovoRequestDto clienteNovoRequestDto);

    PageDto<ClienteResponseDto> consultar(Pageable pageable);

     Cliente consultarPorUuid(UUID uuid);

     Cliente consultarPorCpf(String cpf);

     Cliente consultarPorEmail(String email);

     void excluirPorCpf(String cpf);

     void excluirPorUuid(UUID uuid);

     void excluirPorEmail(String email);

      ClienteResponseDto atualizarPorUuid(ClientePutRequestDto clientePutRequestDto, UUID uuid);
      ClienteResponseDto atualizarPorEmail(ClientePutRequestDto clientePutRequestDto, String email);
      ClienteResponseDto atualizarPorCpf(ClientePutRequestDto clientePutRequestDto, String cpf);



}
