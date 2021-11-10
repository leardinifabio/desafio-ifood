package br.com.ifood.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.dao.implementations.LojaDAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.factory.DAOFactory;
import br.com.ifood.models.Loja;

public class LojaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private LojaDAO dao;
	
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getLojaDAO();
	}
	
	/* ACTIONS */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			this.getAll(request, response);
		} else {
			switch(action.toString()) {
				case "new":
					request.setAttribute("loja", new Loja());
					request.setAttribute("action", "new");
					request.getRequestDispatcher("lojas/create.jsp").forward(request, response);
					break;
				case "update":
					int idToUpdate = Integer.parseInt(request.getParameter("id").toString());					
					Optional<Loja> lojaToUpdate = dao.get(idToUpdate);
					
					request.setAttribute("loja", lojaToUpdate.get());
					request.setAttribute("action", "update");
					request.getRequestDispatcher("lojas/update.jsp").forward(request, response);
					break;
				case "delete":
					int idToDelete = Integer.parseInt(request.getParameter("id").toString());					
					Optional<Loja> lojaToDelete = dao.get(idToDelete);
					
					try {
						dao.remove(lojaToDelete.get());
					} catch (DBException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("error", e.getMessage());
					}
					
					this.getAll(request, response);
					break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action").toString();
		
		Loja loja = new Loja();
		loja.setNr_cnpj(request.getParameter("nr_cnpj").toString());
		loja.setNm_razao_social(request.getParameter("nm_razao_social").toString());
		loja.setNm_loja(request.getParameter("nm_loja").toString());
		loja.setNr_telefone(request.getParameter("nr_telefone").toString());
		loja.setDs_email(request.getParameter("ds_email").toString());
		loja.setCd_plano("1");
		// loja.setCategoria_loja(request.getParameter("categoria_loja"));
		
		switch(action) {
			case "create":
				try {
					dao.save(loja);
					request.setAttribute("success", "Loja cadastrada com sucesso!");
				} catch (DBException db) {
					db.printStackTrace();
					request.setAttribute("error", db.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("error", e.getMessage());
				}
				request.getRequestDispatcher("lojas/create.jsp").forward(request, response);
				break;
			case "update":
				try {
					dao.update(loja);
					request.setAttribute("success", "Loja atualizada com sucesso!");
				} catch (DBException db) {
					db.printStackTrace();
					request.setAttribute("error", db.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("error", e.getMessage());
				}
				break;
		}		
	}
	
	/* METHODS */
	
	protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Loja> lojas = dao.getAll();
		request.setAttribute("lojas", lojas);
		request.getRequestDispatcher("lojas/index.jsp").forward(request, response);
	}

}
