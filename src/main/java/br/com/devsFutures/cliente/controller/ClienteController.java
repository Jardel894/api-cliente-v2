package br.com.devsFutures.cliente.controller;

import br.com.devsFutures.cliente.dto.request.ClienteNovoRequestDto;
import br.com.devsFutures.cliente.dto.request.ClientePutRequestDto;
import br.com.devsFutures.cliente.dto.response.ClienteResponseDto;
import br.com.devsFutures.cliente.dto.response.PageDto;
import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto criar(@RequestBody ClienteNovoRequestDto clienteNovoRequestDto) {
        return clienteService.criar(clienteNovoRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageDto<ClienteResponseDto> consultar(Pageable pageable) {
        return clienteService.consultar(pageable);
    }

    @GetMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto consultarPorUuid(@PathVariable("uuid") UUID uuid) {
        return clienteService.consultarPorUuid(uuid);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto consultarPorCpf(@PathVariable("cpf") String cpf) {
        return clienteService.consultarPorCpf(cpf);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDto consultarPorEmail(@PathVariable("email") String email) {
        return clienteService.consultarPorEmail(email);
    }

    @DeleteMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPorCpf(@PathVariable("cpf") String cpf) {
        clienteService.excluirPorCpf(cpf);
    }

    @DeleteMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPorUuid(@PathVariable("uuid") UUID uuid) {
        clienteService.excluirPorUuid(uuid);
    }

    @DeleteMapping("/email/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPorEmail(@PathVariable("email") String email) {
        clienteService.excluirPorEmail(email);
    }

    @PutMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteResponseDto atualizarPorUuid(@RequestBody ClientePutRequestDto clientePutRequestDto, @PathVariable("uuid") UUID uuid) {
        return clienteService.atualizarPorUuid(clientePutRequestDto, uuid);
    }

    @PutMapping("/email/{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteResponseDto atualizarPorEmail(@RequestBody ClientePutRequestDto clientePutRequestDto, @PathVariable("email") String email) {
        return clienteService.atualizarPorEmail(clientePutRequestDto, email);
    }

    @PutMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteResponseDto atualizarPorCpf(@RequestBody ClientePutRequestDto clientePutRequestDto, @PathVariable("cpf") String cpf) {
        return clienteService.atualizarPorCpf(clientePutRequestDto, cpf);
    }


}
