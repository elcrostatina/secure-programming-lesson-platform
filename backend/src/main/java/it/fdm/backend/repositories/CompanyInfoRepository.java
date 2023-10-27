package it.fdm.backend.repositories;

import it.fdm.backend.entities.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {
    CompanyInfo findOneById(UUID id);
}