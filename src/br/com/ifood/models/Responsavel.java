package br.com.ifood.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Responsavel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	@Id
	private int id_responsavel;
	private String nm_responsavel;
	private String nr_cpf;
	private String nr_rg;
	private int id_loja_responsavel;
	
	/* CONSTRUCTOR */
	
	public Responsavel() {}
	
	public Responsavel(String nm_responsavel, String nr_cpf, String nr_rg, int id_loja_responsavel) {
		super();
		this.nm_responsavel = nm_responsavel;
		this.nr_cpf = nr_cpf;
		this.nr_rg = nr_rg;
		this.id_loja_responsavel = id_loja_responsavel;
	}

	public Responsavel(int id_responsavel, String nm_responsavel, String nr_cpf, String nr_rg, int id_loja_responsavel) {
		super();
		this.id_responsavel = id_responsavel;
		this.nm_responsavel = nm_responsavel;
		this.nr_cpf = nr_cpf;
		this.nr_rg = nr_rg;
		this.id_loja_responsavel = id_loja_responsavel;
	}

	/* GETTERS & SETTERS */

	public int getId_responsavel() {
		return id_responsavel;
	}
	
	public void setId_responsavel(int id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public String getNm_responsavel() {
		return nm_responsavel;
	}

	public void setNm_responsavel(String nm_responsavel) {
		this.nm_responsavel = nm_responsavel;
	}

	public String getNr_cpf() {
		return nr_cpf;
	}

	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}

	public String getNr_rg() {
		return nr_rg;
	}

	public void setNr_rg(String nr_rg) {
		this.nr_rg = nr_rg;
	}

	public int getId_loja_responsavel() {
		return id_loja_responsavel;
	}

	public void setId_loja_responsavel(int id_loja_responsavel) {
		this.id_loja_responsavel = id_loja_responsavel;
	}
	
	/* METHODS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_loja_responsavel;
		result = prime * result + id_responsavel;
		result = prime * result + ((nm_responsavel == null) ? 0 : nm_responsavel.hashCode());
		result = prime * result + ((nr_cpf == null) ? 0 : nr_cpf.hashCode());
		result = prime * result + ((nr_rg == null) ? 0 : nr_rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsavel other = (Responsavel) obj;
		if (id_loja_responsavel != other.id_loja_responsavel)
			return false;
		if (id_responsavel != other.id_responsavel)
			return false;
		if (nm_responsavel == null) {
			if (other.nm_responsavel != null)
				return false;
		} else if (!nm_responsavel.equals(other.nm_responsavel))
			return false;
		if (nr_cpf == null) {
			if (other.nr_cpf != null)
				return false;
		} else if (!nr_cpf.equals(other.nr_cpf))
			return false;
		if (nr_rg == null) {
			if (other.nr_rg != null)
				return false;
		} else if (!nr_rg.equals(other.nr_rg))
			return false;
		return true;
	}
	
}
