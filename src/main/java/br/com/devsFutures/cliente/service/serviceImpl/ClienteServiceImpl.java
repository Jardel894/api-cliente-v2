package br.com.devsFutures.cliente.service.serviceImpl;

import br.com.devsFutures.cliente.converter.ClienteConverter;
import br.com.devsFutures.cliente.dto.request.ClienteNovoRequestDto;
import br.com.devsFutures.cliente.dto.request.ClientePutRequestDto;
import br.com.devsFutures.cliente.dto.response.ClienteResponseDto;
import br.com.devsFutures.cliente.dto.response.PageDto;
import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.entities.Telefone;
import br.com.devsFutures.cliente.repository.ClienteRepository;
import br.com.devsFutures.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
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
        Cliente cliente = getCliente(uuid);
        return ClienteConverter.toClienteResponseDto(cliente);
    }

    @Override
    public ClienteResponseDto consultarPorCpf(String cpf) {
        Cliente cliente = clienteRepository.buscaClientePorDocumento(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo cpf: " + cpf));
        return ClienteConverter.toClienteResponseDto(cliente);
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
        Cliente clienteSalvo = getCliente(uuid);

        atualizarDados(clientePutRequestDto, clienteSalvo);

        clienteRepository.save(clienteSalvo);

        return ClienteConverter.toClienteResponseDto(clienteSalvo);
    }

    public ClienteResponseDto atualizarPorCpf(ClientePutRequestDto clientePutRequestDto, String cpf) {
        Cliente clienteSalvo = clienteRepository.buscaClientePorDocumento(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        atualizarDados(clientePutRequestDto, clienteSalvo);
        clienteRepository.save(clienteSalvo);
        return ClienteConverter.toClienteResponseDto(clienteSalvo);
    }

    public ClienteResponseDto atualizarPorEmail(ClientePutRequestDto clientePutRequestDto, String email) {
        Cliente clienteSalvo = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não existe"));
        atualizarDados(clientePutRequestDto, clienteSalvo);
        clienteRepository.save(clienteSalvo);
        return ClienteConverter.toClienteResponseDto(clienteSalvo);
    }

    //TODO - Realizar Testes via POSTMAN com esse metodo
    private void atualizarDados(ClientePutRequestDto clientePutRequestDto, Cliente clienteSalvo) {
        clienteSalvo.setNome(clientePutRequestDto.getNome() == null ? clienteSalvo.getNome() : clientePutRequestDto.getNome());
        clienteSalvo.setEmail(clientePutRequestDto.getEmail() == null ? clienteSalvo.getEmail() : clientePutRequestDto.getEmail());

        if (!CollectionUtils.isEmpty(clientePutRequestDto.getTelefones())) {
            List<Telefone> telefoneList = clientePutRequestDto.getTelefones()
                    .stream()
                    .map(telefone -> Telefone.builder()
                            .ddd(telefone.getDdd())
                            .numero(telefone.getNumero())
                            .telefoneTipo(telefone.getTelefoneTipo())
                            .build())
                    .toList();
            clienteSalvo.setTelefoneList(telefoneList);
        }
        if (!ObjectUtils.isEmpty(clientePutRequestDto.getEndereco())){
            clienteSalvo.setEndereco(clientePutRequestDto.getEndereco().to());
        }

    }

    private Cliente getCliente(UUID uuid) {
        return clienteRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Cliente não existe"));
    }

}
