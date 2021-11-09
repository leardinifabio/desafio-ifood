package br.com.ifood.factory;

import br.com.ifood.dao.implementations.LojaDAO;

public class DAOFactory {

	public static LojaDAO getLojaDAO() {
		return new LojaDAO();
	}
}
