package it.fdm.backend.entities;

public class CompanyInfo {

	private String nome;
	private String[] domains;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getDomains() {
		return domains;
	}

	public void setDomains(String[] domains) {
		this.domains = domains;
	}

}
