package br.com.devsFutures.cliente.service.serviceImpl;

import br.com.devsFutures.cliente.entities.Cliente;
import br.com.devsFutures.cliente.repository.ClienteRepository;
import br.com.devsFutures.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;
    @Override
    public Cliente criar(Cliente cliente) {
      return clienteRepository.save(cliente);
    }
}
