package br.com.ifood.factory;

import br.com.ifood.dao.implementations.CategoriaDAO;
import br.com.ifood.dao.implementations.CategoriaItemDAO;
import br.com.ifood.dao.implementations.EnderecoDAO;
import br.com.ifood.dao.implementations.ItemDAO;
import br.com.ifood.dao.implementations.LojaDAO;
import br.com.ifood.dao.implementations.ResponsavelDAO;

public class DAOFactory {

	public static LojaDAO getLojaDAO() {
		return new LojaDAO();
	}
	
	public static CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAO();
	}
	
	public static EnderecoDAO getEnderecoDAO() {
		return new EnderecoDAO();
	}
	
	public static ResponsavelDAO getResponsavelDAO() {
		return new ResponsavelDAO();
	}
	
	public static CategoriaItemDAO getCategoriaItemDAO() {
		return new CategoriaItemDAO();
	}
	
	public static ItemDAO getItemDAO() {
		return new ItemDAO();
	}

}
