package it.fdm.backend.repositories;

import it.fdm.backend.entities.Privilege;
import it.fdm.backend.entities.ResourceMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResourceMapRepository extends JpaRepository<ResourceMap, Long> {
    ResourceMap findById(UUID id);
}