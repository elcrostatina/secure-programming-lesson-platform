package it.fdm.backend.repositories;

import it.fdm.backend.entities.Domain;
import it.fdm.backend.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findOneByUserIdAndVideoId(UUID userIdm, UUID videoId);
}