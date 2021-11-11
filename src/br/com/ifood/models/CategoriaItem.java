package br.com.ifood.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoriaItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	@Id
	private int id_categoria_item;
	private String nm_categoria_item;
	
	/* CONSTRUCTOR */
	
	public CategoriaItem() {}
	
	public CategoriaItem(String nm_categoria_item) {
		super();
		this.nm_categoria_item = nm_categoria_item;
	}
	
	public CategoriaItem(int id_categoria_item, String nm_categoria_item) {
		super();
		this.id_categoria_item = id_categoria_item;
		this.nm_categoria_item = nm_categoria_item;
	}

	/* GETTERS & SETTERS */
	
	public int getId_categoria_item() {
		return id_categoria_item;
	}
	
	public void setId_categoria_item(int id_categoria_item) {
		this.id_categoria_item = id_categoria_item;
	}
	
	public String getNm_categoria_item() {
		return nm_categoria_item;
	}
	
	public void setNm_categoria_item(String nm_categoria_item) {
		this.nm_categoria_item = nm_categoria_item;
	}
	
	/* METHODS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_categoria_item;
		result = prime * result + ((nm_categoria_item == null) ? 0 : nm_categoria_item.hashCode());
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
		CategoriaItem other = (CategoriaItem) obj;
		if (id_categoria_item != other.id_categoria_item)
			return false;
		if (nm_categoria_item == null) {
			if (other.nm_categoria_item != null)
				return false;
		} else if (!nm_categoria_item.equals(other.nm_categoria_item))
			return false;
		return true;
	}
	
}
