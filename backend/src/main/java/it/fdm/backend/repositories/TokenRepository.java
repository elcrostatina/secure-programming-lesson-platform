package it.fdm.backend.repositories;

import it.fdm.backend.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByLocalNameAndDomain(String localName, String domain);

    Token findOneById(UUID id);
}
