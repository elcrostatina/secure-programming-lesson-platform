package it.fdm.backend.repositories;

import it.fdm.backend.entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Long> {
}