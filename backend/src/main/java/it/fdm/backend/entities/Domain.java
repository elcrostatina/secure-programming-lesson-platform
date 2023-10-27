package it.fdm.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "domain")
public class Domain extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private CompanyInfo companyInfo;

    private String name;
}