package br.com.devsFutures.cliente.repository;

import br.com.devsFutures.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    // Exemplo de Query
    @Query(value = "select c from Cliente c where cpf = :cpf")
    Optional<Cliente> buscaClientePorDocumento(@Param("cpf") String cpf);

    Optional<Cliente> findByEmail(String email);

    void deleteByCpf(String cpf);
    void deleteByEmail(String email);
}
