package br.com.ifood.converter;

import java.io.Serializable;

import br.com.ifood.models.CategoriaItem;
import br.com.ifood.models.Loja;

public class ItemConverter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	private int id_item;
	private String nm_item;
	private String ds_item;
	private double vl_preco;
	private Loja item_loja;
	private CategoriaItem item_categoria;
	
	/* CONSTRUCTOR */
	
	public ItemConverter() {}
	
	public ItemConverter(String nm_item, String ds_item, double vl_preco, Loja item_loja,
			CategoriaItem item_categoria) {
		super();
		this.nm_item = nm_item;
		this.ds_item = ds_item;
		this.vl_preco = vl_preco;
		this.item_loja = item_loja;
		this.item_categoria = item_categoria;
	}
	
	public ItemConverter(int id_item, String nm_item, String ds_item, double vl_preco, Loja item_loja,
			CategoriaItem item_categoria) {
		super();
		this.id_item = id_item;
		this.nm_item = nm_item;
		this.ds_item = ds_item;
		this.vl_preco = vl_preco;
		this.item_loja = item_loja;
		this.item_categoria = item_categoria;
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

	public Loja getItem_loja() {
		return item_loja;
	}

	public void setItem_loja(Loja item_loja) {
		this.item_loja = item_loja;
	}

	public CategoriaItem getItem_categoria() {
		return item_categoria;
	}

	public void setItem_categoria(CategoriaItem item_categoria) {
		this.item_categoria = item_categoria;
	}
	
	/* METHODS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ds_item == null) ? 0 : ds_item.hashCode());
		result = prime * result + id_item;
		result = prime * result + ((item_categoria == null) ? 0 : item_categoria.hashCode());
		result = prime * result + ((item_loja == null) ? 0 : item_loja.hashCode());
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
		ItemConverter other = (ItemConverter) obj;
		if (ds_item == null) {
			if (other.ds_item != null)
				return false;
		} else if (!ds_item.equals(other.ds_item))
			return false;
		if (id_item != other.id_item)
			return false;
		if (item_categoria == null) {
			if (other.item_categoria != null)
				return false;
		} else if (!item_categoria.equals(other.item_categoria))
			return false;
		if (item_loja == null) {
			if (other.item_loja != null)
				return false;
		} else if (!item_loja.equals(other.item_loja))
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
