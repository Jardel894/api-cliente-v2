package br.com.devsFutures.cliente.service.serviceImpl;

import br.com.devsFutures.cliente.converter.ClienteConverter;
import br.com.devsFutures.cliente.dto.request.ClienteNovoRequestDto;
import br.com.devsFutures.cliente.dto.request.ClientePutRequestDto;
import br.com.devsFutures.cliente.dto.response.ClienteResponseDto;
import br.com.devsFutures.cliente.dto.response.PageDto;
import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.repository.ClienteRepository;
import br.com.devsFutures.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PageDto<ClienteResponseDto> consultar(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("email"));

        final Page<Cliente> clientePage = clienteRepository.findAll(pageRequest);

        return ClienteConverter.toClientePageResponseDto(clientePage);
    }

    @Override
    public ClienteResponseDto consultarPorUuid(UUID uuid) {
        Cliente cliente = clienteRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado por uuid: " + uuid));
        return ClienteConverter.toClienteResponseDto(cliente);
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        return clienteRepository.buscaClientePorDocumento(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo cpf: " + cpf));
    }

    @Override
    public ClienteResponseDto consultarPorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado por email: " + email));
        return ClienteConverter.toClienteResponseDto(cliente);
    }

    @Override
    @Transactional
    public void excluirPorCpf(String cpf) {
        clienteRepository.deleteByCpf(cpf);
    }

    @Override
    @Transactional
    public void excluirPorUuid(UUID uuid) {
        clienteRepository.deleteById(uuid);
    }

    @Override
    @Transactional
    public void excluirPorEmail(String email) {
        clienteRepository.deleteByEmail(email);
    }

    public ClienteResponseDto atualizarPorUuid(ClientePutRequestDto clientePutRequestDto, UUID uuid) {
        Cliente clienteSalvo = clienteRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        verificaDadosDeAtualizacao(clientePutRequestDto, clienteSalvo);
        clienteRepository.save(clienteSalvo);
        return ClienteConverter.toClienteResponseDto(clienteSalvo);
    }

    public ClienteResponseDto atualizarPorCpf(ClientePutRequestDto clientePutRequestDto, String cpf) {
        Cliente clienteSalvo = clienteRepository.buscaClientePorDocumento(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        verificaDadosDeAtualizacao(clientePutRequestDto, clienteSalvo);
        clienteRepository.save(clienteSalvo);
        return ClienteConverter.toClienteResponseDto(clienteSalvo);
    }

    public ClienteResponseDto atualizarPorEmail(ClientePutRequestDto clientePutRequestDto, String email) {
        Cliente clienteSalvo = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        verificaDadosDeAtualizacao(clientePutRequestDto, clienteSalvo);
        clienteRepository.save(clienteSalvo);
        return ClienteConverter.toClienteResponseDto(clienteSalvo);
    }

    private void verificaDadosDeAtualizacao(ClientePutRequestDto clientePutRequestDto, Cliente clienteSalvo) {
        clienteSalvo.setNome(clientePutRequestDto.getNome() == null ? clienteSalvo.getNome() : clientePutRequestDto.getNome());
        clienteSalvo.setTelefone(clientePutRequestDto.getTelefone() == null ? clienteSalvo.getTelefone() : clientePutRequestDto.getTelefone());
        clienteSalvo.setEndereco(clientePutRequestDto.getEndereco() == null ? clienteSalvo.getEndereco() : clientePutRequestDto.getEndereco());
        clienteSalvo.setEmail(clientePutRequestDto.getEmail() == null ? clienteSalvo.getEmail() : clientePutRequestDto.getEmail());
    }
}
