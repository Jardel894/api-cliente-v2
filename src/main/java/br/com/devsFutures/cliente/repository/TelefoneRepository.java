package br.com.devsFutures.cliente.repository;

import br.com.devsFutures.cliente.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {
}
