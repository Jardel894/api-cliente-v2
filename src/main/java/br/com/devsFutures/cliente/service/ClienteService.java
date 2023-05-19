package br.com.devsFutures.cliente.service;

import br.com.devsFutures.cliente.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClienteService {


     Cliente criar(Cliente cliente);

     Page<Cliente> consultar(Pageable pageable);

     Cliente consultarPorUuid(UUID uuid);

     Cliente consultarPorCpf(String cpf);

     Cliente consultarPorEmail(String email);

     void excluirPorCpf(String cpf);
}
