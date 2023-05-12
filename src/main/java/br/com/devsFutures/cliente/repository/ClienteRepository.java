package br.com.devsFutures.cliente.repository;

import br.com.devsFutures.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, UUID> {
}