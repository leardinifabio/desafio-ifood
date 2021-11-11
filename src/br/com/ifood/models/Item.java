package br.com.ifood.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	@Id
	private int id_item;
	private String nm_item;
	private String ds_item;
	private double vl_preco;
	private int id_loja_item;
	private int id_categoria_item_item;
	
	/* CONSTRUCTOR */
	
	public Item() {}
	
	public Item(String nm_item, String ds_item, double vl_preco, int id_loja_item, int id_categoria_item_item) {
		super();
		this.nm_item = nm_item;
		this.ds_item = ds_item;
		this.vl_preco = vl_preco;
		this.id_loja_item = id_loja_item;
		this.id_categoria_item_item = id_categoria_item_item;
	}
	
	public Item(int id_item, String nm_item, String ds_item, double vl_preco, int id_loja_item, int id_categoria_item_item) {
		super();
		this.id_item = id_item;
		this.nm_item = nm_item;
		this.ds_item = ds_item;
		this.vl_preco = vl_preco;
		this.id_loja_item = id_loja_item;
		this.id_categoria_item_item = id_categoria_item_item;
	}

	/* GETTERS & SETTERS */

	public int getId_item() {
		return id_item;
	}
	
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	public String getNm_item() {
		return nm_item;
	}

	public void setNm_item(String nm_item) {
		this.nm_item = nm_item;
	}

	public String getDs_item() {
		return ds_item;
	}

	public void setDs_item(String ds_item) {
		this.ds_item = ds_item;
	}

	public double getVl_preco() {
		return vl_preco;
	}

	public void setVl_preco(double vl_preco) {
		this.vl_preco = vl_preco;
	}

	public int getId_loja_item() {
		return id_loja_item;
	}

	public void setId_loja_item(int id_loja_item) {
		this.id_loja_item = id_loja_item;
	}

	public int getId_categoria_item_item() {
		return id_categoria_item_item;
	}

	public void setId_categoria_item_item(int id_categoria_item_item) {
		this.id_categoria_item_item = id_categoria_item_item;
	}
	
	/* METHODS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ds_item == null) ? 0 : ds_item.hashCode());
		result = prime * result + id_categoria_item_item;
		result = prime * result + id_item;
		result = prime * result + id_loja_item;
		result = prime * result + ((nm_item == null) ? 0 : nm_item.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vl_preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Item other = (Item) obj;
		if (ds_item == null) {
			if (other.ds_item != null)
				return false;
		} else if (!ds_item.equals(other.ds_item))
			return false;
		if (id_categoria_item_item != other.id_categoria_item_item)
			return false;
		if (id_item != other.id_item)
			return false;
		if (id_loja_item != other.id_loja_item)
			return false;
		if (nm_item == null) {
			if (other.nm_item != null)
				return false;
		} else if (!nm_item.equals(other.nm_item))
			return false;
		if (Double.doubleToLongBits(vl_preco) != Double.doubleToLongBits(other.vl_preco))
			return false;
		return true;
	}
	
}
