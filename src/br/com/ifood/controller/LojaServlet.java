package br.com.ifood.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.dao.implementations.LojaDAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.factory.DAOFactory;
import br.com.ifood.models.Loja;

/**
 * Servlet implementation class LojaServlet
 */
@WebServlet("/loja")
public class LojaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private LojaDAO dao;
	
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getLojaDAO();
	}
	
	/* ACTIONS */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Loja> lojas = dao.getAll();
		request.setAttribute("lojas", lojas);
		request.getRequestDispatcher("lista-lojas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nm_razao_social = request.getParameter("nm_razao_social");
			Loja loja = new Loja(nm_razao_social);
			dao.save(loja);
			request.setAttribute("success", "Produto cadastrado com sucesso");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("error", db.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("cadastro-loja.jsp").forward(request, response);
	}

}
