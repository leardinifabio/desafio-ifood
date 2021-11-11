package br.com.ifood.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	@Id
	private int id_endereco;
	private String nr_cep;
	private String cd_uf;
	private String nm_cidade;
	private String nm_bairro;
	private String nm_endereco;
	private int nr_numero;
	private String ds_complemento; 
	private int id_endereco_loja;
	
	/* CONSTRUCTOR */
	
	public Endereco() {}
	
	public Endereco(String nr_cep, String cd_uf, String nm_cidade, String nm_bairro,
			String nm_endereco, int nr_numero, String ds_complemento, int id_endereco_loja) {
		super();
		this.nr_cep = nr_cep;
		this.cd_uf = cd_uf;
		this.nm_cidade = nm_cidade;
		this.nm_bairro = nm_bairro;
		this.nm_endereco = nm_endereco;
		this.nr_numero = nr_numero;
		this.ds_complemento = ds_complemento;
		this.id_endereco_loja = id_endereco_loja;
	}
	
	public Endereco(int id_endereco, String nr_cep, String cd_uf, String nm_cidade, String nm_bairro,
			String nm_endereco, int nr_numero, String ds_complemento, int id_endereco_loja) {
		super();
		this.id_endereco = id_endereco;
		this.nr_cep = nr_cep;
		this.cd_uf = cd_uf;
		this.nm_cidade = nm_cidade;
		this.nm_bairro = nm_bairro;
		this.nm_endereco = nm_endereco;
		this.nr_numero = nr_numero;
		this.ds_complemento = ds_complemento;
		this.id_endereco_loja = id_endereco_loja;
	}

	/* GETTERS & SETTERS */

	public int getId_endereco() {
		return id_endereco;
	}
	
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getNr_cep() {
		return nr_cep;
	}

	public void setNr_cep(String nr_cep) {
		this.nr_cep = nr_cep;
	}

	public String getCd_uf() {
		return cd_uf;
	}

	public void setCd_uf(String cd_uf) {
		this.cd_uf = cd_uf;
	}

	public String getNm_cidade() {
		return nm_cidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}

	public String getNm_bairro() {
		return nm_bairro;
	}

	public void setNm_bairro(String nm_bairro) {
		this.nm_bairro = nm_bairro;
	}

	public String getNm_endereco() {
		return nm_endereco;
	}

	public void setNm_endereco(String nm_endereco) {
		this.nm_endereco = nm_endereco;
	}

	public int getNr_numero() {
		return nr_numero;
	}

	public void setNr_numero(int nr_numero) {
		this.nr_numero = nr_numero;
	}

	public String getDs_complemento() {
		return ds_complemento;
	}

	public void setDs_complemento(String ds_complemento) {
		this.ds_complemento = ds_complemento;
	}

	public int getId_endereco_loja() {
		return id_endereco_loja;
	}

	public void setId_endereco_loja(int id_endereco_loja) {
		this.id_endereco_loja = id_endereco_loja;
	}
	
	/* METHODS */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_uf == null) ? 0 : cd_uf.hashCode());
		result = prime * result + ((ds_complemento == null) ? 0 : ds_complemento.hashCode());
		result = prime * result + id_endereco;
		result = prime * result + id_endereco_loja;
		result = prime * result + ((nm_bairro == null) ? 0 : nm_bairro.hashCode());
		result = prime * result + ((nm_cidade == null) ? 0 : nm_cidade.hashCode());
		result = prime * result + ((nm_endereco == null) ? 0 : nm_endereco.hashCode());
		result = prime * result + ((nr_cep == null) ? 0 : nr_cep.hashCode());
		result = prime * result + nr_numero;
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
		Endereco other = (Endereco) obj;
		if (cd_uf == null) {
			if (other.cd_uf != null)
				return false;
		} else if (!cd_uf.equals(other.cd_uf))
			return false;
		if (ds_complemento == null) {
			if (other.ds_complemento != null)
				return false;
		} else if (!ds_complemento.equals(other.ds_complemento))
			return false;
		if (id_endereco != other.id_endereco)
			return false;
		if (id_endereco_loja != other.id_endereco_loja)
			return false;
		if (nm_bairro == null) {
			if (other.nm_bairro != null)
				return false;
		} else if (!nm_bairro.equals(other.nm_bairro))
			return false;
		if (nm_cidade == null) {
			if (other.nm_cidade != null)
				return false;
		} else if (!nm_cidade.equals(other.nm_cidade))
			return false;
		if (nm_endereco == null) {
			if (other.nm_endereco != null)
				return false;
		} else if (!nm_endereco.equals(other.nm_endereco))
			return false;
		if (nr_cep == null) {
			if (other.nr_cep != null)
				return false;
		} else if (!nr_cep.equals(other.nr_cep))
			return false;
		if (nr_numero != other.nr_numero)
			return false;
		return true;
	}
	
}
