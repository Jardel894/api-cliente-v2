package br.com.devsFutures.cliente.service.serviceImpl;

import br.com.devsFutures.cliente.converter.ClienteConverter;
import br.com.devsFutures.cliente.dto.request.ClienteNovoRequestDto;
import br.com.devsFutures.cliente.dto.response.ClienteResponseDto;
import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.repository.ClienteRepository;
import br.com.devsFutures.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponseDto criar(ClienteNovoRequestDto clienteNovoRequestDto) {
        Cliente cliente = ClienteConverter.toCliente(clienteNovoRequestDto);
        clienteRepository.save(cliente);
        return ClienteConverter.toClienteResponseDto(cliente);
    }

    @Override
    public Page<Cliente> consultar(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente consultarPorUuid(UUID uuid) {
        return clienteRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado por uuid: " + uuid));
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        return clienteRepository.buscaClientePorDocumento(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo cpf: " + cpf));
    }

    @Override
    public Cliente consultarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado por email: " + email));
    }

    @Override
    @Transactional
    public void excluirPorCpf(String cpf) {
        clienteRepository.deleteByCpf(cpf);
    }
}
