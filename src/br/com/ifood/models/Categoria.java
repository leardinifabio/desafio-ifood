package br.com.ifood.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	@Id
	private int id_categoria;
	private String nm_categoria;
	
	
	/* CONSTRUCTOR */
	
	public Categoria() {}
	
	public Categoria(String nm_razao_social) {
		super();
		this.nm_categoria = nm_razao_social;
	}
	
	public Categoria(int id_categoria, String nm_razao_social) {
		super();
		this.id_categoria = id_categoria;
		this.nm_categoria = nm_razao_social;
	}

	/* GETTERS & SETTERS */
	
	public int getId_categoria() {
		return id_categoria;
	}
	
	public String getNm_categoria() {
		return nm_categoria;
	}
	
	public void setNm_categoria(String nm_categoria) {
		this.nm_categoria = nm_categoria;
	}
	
	/* METHODS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_categoria;
		result = prime * result + ((nm_categoria == null) ? 0 : nm_categoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (id_categoria != other.id_categoria)
			return false;
		if (nm_categoria == null) {
			if (other.nm_categoria != null)
				return false;
		} else if (!nm_categoria.equals(other.nm_categoria))
			return false;
		return true;
	}
	
}
