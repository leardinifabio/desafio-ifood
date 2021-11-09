package br.com.ifood.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	@Id
	private int id_loja;
	private String nm_razao_social;
	
	/* CONSTRUCTOR */
	
	public Loja(String nm_razao_social) {
		super();
		this.nm_razao_social = nm_razao_social;
	}

	/* GETTERS & SETTERS */
	
	public int getId_loja() {
		return id_loja;
	}
	
	public String getNm_razao_social() {
		return nm_razao_social;
	}
	
	public void setNm_razao_social(String nm_razao_social) {
		this.nm_razao_social = nm_razao_social;
	}
	
	/* METHODS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_loja;
		result = prime * result + ((nm_razao_social == null) ? 0 : nm_razao_social.hashCode());
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
		Loja other = (Loja) obj;
		if (id_loja != other.id_loja)
			return false;
		if (nm_razao_social == null) {
			if (other.nm_razao_social != null)
				return false;
		} else if (!nm_razao_social.equals(other.nm_razao_social))
			return false;
		return true;
	}
	
}
