package br.com.devsFutures.cliente.controller;

import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar (@RequestBody Cliente clienteNovo){
      return clienteService.criar(clienteNovo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Cliente> consultar(Pageable pageable){
        return clienteService.consultar(pageable);
    }

    @GetMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente consultarPorUuid(@PathVariable("uuid") UUID uuid){
        return clienteService.consultarPorUuid(uuid);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente consultarPorCpf(@PathVariable("cpf") String cpf){
        return clienteService.consultarPorCpf(cpf);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente consultarPorEmail(@PathVariable("email") String email){
        return clienteService.consultarPorEmail(email);
    }

    @DeleteMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPorCpf(@PathVariable("cpf") String cpf){
         clienteService.excluirPorCpf(cpf);
    }

}
