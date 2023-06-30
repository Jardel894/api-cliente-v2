package br.com.devsFutures.cliente.service;

import br.com.devsFutures.cliente.dto.request.TelefonePutRequestDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TelefoneService {

    void updateTelefoneByCliente(TelefonePutRequestDto telefonePutRequestDto, UUID clienteId);

}
