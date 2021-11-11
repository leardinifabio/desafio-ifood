package br.com.ifood.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.converter.LojaConverter;
import br.com.ifood.dao.implementations.CategoriaDAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.factory.DAOFactory;
import br.com.ifood.models.Loja;
import br.com.ifood.services.LojaService;

public class LojaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/* PROPERTIES */
	
	private LojaService service;
	private CategoriaDAO categoriaDAO;
	
	/* INIT */
	
	public void init() throws ServletException {
		super.init();
		service = new LojaService();
		categoriaDAO = DAOFactory.getCategoriaDAO();
	}
	
	/* ACTIONS */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			this.getAll(request, response);
		} else {
			switch(action.toString()) {
				case "new":
					request.setAttribute("loja", new Loja());
					request.setAttribute("categorias", categoriaDAO.getAll());
					request.setAttribute("action", "new");
					request.getRequestDispatcher("lojas/create.jsp").forward(request, response);
					break;
				case "update":
					LojaConverter lojaToUpdate = service.get(Integer.parseInt(request.getParameter("id").toString()));
					
					request.setAttribute("loja", lojaToUpdate);
					request.setAttribute("categorias", categoriaDAO.getAll());
					request.setAttribute("action", "update");
					request.getRequestDispatcher("lojas/update.jsp").forward(request, response);
					break;
				case "delete":
					try {
						int id = Integer.parseInt(request.getParameter("id").toString());
						service.remove(id);
					} catch (DBException db) {
						request.setAttribute("error", db.getMessage());
						db.printStackTrace();
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
		switch(request.getParameter("action").toString()) {
			case "create":
				try {
					service.save(request);
					request.setAttribute("success", "Loja cadastrada com sucesso!");
					this.getAll(request, response);
				} catch (DBException db) {
					request.setAttribute("error", db.getMessage());
					db.printStackTrace();
					request.getRequestDispatcher("lojas/create.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
					e.printStackTrace();
					request.getRequestDispatcher("lojas/create.jsp").forward(request, response);
				}
				break;
			case "update":
				try {
					service.update(request);
					request.setAttribute("success", "Loja atualizada com sucesso!");
					this.getAll(request, response);
				} catch (DBException db) {
					request.setAttribute("error", db.getMessage());
					db.printStackTrace();
					request.getRequestDispatcher("lojas/update.jsp").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("error", e.getMessage());
					e.printStackTrace();
					request.getRequestDispatcher("lojas/update.jsp").forward(request, response);
				}
				break;
		}		
	}
	
	/* METHODS */
	
	/**
	 * Método responsavel por realizar chamada de index
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<LojaConverter> lojas = service.getAll();
			request.setAttribute("lojas", lojas);
			request.getRequestDispatcher("lojas/index.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
	}

}
