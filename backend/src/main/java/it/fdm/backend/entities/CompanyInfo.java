package it.fdm.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name = "company_info")
public class CompanyInfo extends BaseEntity {
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "companyInfo")
	@JsonManagedReference
	private Set<Domain> domains;
}
