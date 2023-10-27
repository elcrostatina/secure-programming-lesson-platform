package it.fdm.backend.services;

import it.fdm.backend.entities.CompanyInfo;
import it.fdm.backend.entities.Domain;
import it.fdm.backend.repositories.CompanyInfoRepository;
import it.fdm.backend.repositories.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoService {
    private final CompanyInfoRepository companyInfoRepository;
    private final DomainRepository domainRepository;

    @Autowired
    CompanyInfoService(CompanyInfoRepository companyInfoRepository, DomainRepository domainRepository) {
        this.companyInfoRepository = companyInfoRepository;
        this.domainRepository = domainRepository;
    }
/*
    public void createCompanyInfo() {
        Domain domain = new Domain();
        domain.setName("fdm.it");

        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setNome("FDM");
        domain.setCompanyInfo(companyInfo);

        companyInfoRepository.save(companyInfo);
        domainRepository.save(domain);
    }
*/
    public List<CompanyInfo> getCompanyInfo() {
        return companyInfoRepository.findAll();
    }
}
