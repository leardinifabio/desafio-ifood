package br.com.ifood.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ifood.dao.DAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.models.Loja;
import br.com.ifood.singleton.ConnectionFactory;

public class LojaDAO implements DAO<Loja> {
    	
    @Override
    public Optional<Loja> get(int id) {
    	Loja loja = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_loja,"
    			+ "    	nr_cnpj,"
    			+ "    	nm_razao_social,"
    			+ "    	nm_loja,"
    			+ "    	nr_telefone,"
    			+ "    	ds_email,"
    			+ "    	cd_plano,"
    			+ "    	id_categoria_loja "
    			+ "FROM loja"
    			+ "		WHERE loja.id_loja = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			loja = new Loja(
    					result.getInt("id_loja"),
    					result.getString("nr_cnpj"), 
    					result.getString("nm_razao_social"), 
    					result.getString("nm_loja"),
    					result.getString("nr_telefone"),
    					result.getString("ds_email"),
    					result.getString("cd_plano"),
    					result.getInt("id_categoria_loja")
					);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
	    		e.printStackTrace();
			}
    	}
    	
        return Optional.ofNullable(loja);
    }
    
    @Override
    public List<Loja> getAll() {
    	List<Loja> lojas = new ArrayList<>();
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_loja,"
    			+ "    	nr_cnpj,"
    			+ "    	nm_razao_social,"
    			+ "    	nm_loja,"
    			+ "    	nr_telefone,"
    			+ "    	ds_email,"
    			+ "    	cd_plano,"
    			+ "    	id_categoria_loja "
    			+ "FROM loja";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			Loja loja = new Loja(
    					result.getInt("id_loja"),
    					result.getString("nr_cnpj"), 
    					result.getString("nm_razao_social"), 
    					result.getString("nm_loja"),
    					result.getString("nr_telefone"),
    					result.getString("ds_email"),
    					result.getString("cd_plano"),
    					result.getInt("id_categoria_loja")
					);
    			lojas.add(loja);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
	    		e.printStackTrace();
			}
    	}
    	
        return lojas;
    }
    
    @Override
    public Optional<Loja> save(Loja loja) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "INSERT INTO loja (nr_cnpj, nm_razao_social, nm_loja, nr_telefone, ds_email, cd_plano, id_categoria_loja)"
    			+ "    VALUES (?, ?, ?, ?, ?, ?, ?)";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql, new String[] {"id_loja"});

    		preparedStatement.setString(1, loja.getNr_cnpj());
    		preparedStatement.setString(2, loja.getNm_razao_social());
    		preparedStatement.setString(3, loja.getNm_loja());
    		preparedStatement.setString(4, loja.getNr_telefone());
    		preparedStatement.setString(5, loja.getDs_email());
    		preparedStatement.setString(6, loja.getCd_plano());
    		preparedStatement.setInt(7, loja.getId_categoria_loja());
    		
    		int affectedRows = preparedStatement.executeUpdate();
    		if (affectedRows == 0) {
    			throw new DBException("Creating loja failed, no rows affected.");
    		}
    		
    		ResultSet result = preparedStatement.getGeneratedKeys();
    		if (result.next()) {
    			loja.setId_loja(result.getInt(1));
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	return Optional.ofNullable(loja);
    }
    
    @Override
    public void update(Loja loja) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "UPDATE loja SET "
    			+ "		nr_cnpj = ?, "
    			+ "		nm_razao_social = ?, "
    			+ "		nm_loja = ?, "
    			+ "		nr_telefone = ?, "
    			+ "		ds_email = ?, "
    			+ "		cd_plano = ?, "
    			+ "		id_categoria_loja = ? "
    			+ "WHERE id_loja = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, loja.getNr_cnpj());
    		preparedStatement.setString(2, loja.getNm_razao_social());
    		preparedStatement.setString(3, loja.getNm_loja());
    		preparedStatement.setString(4, loja.getNr_telefone());
    		preparedStatement.setString(5, loja.getDs_email());
    		preparedStatement.setString(6, "1");
    		preparedStatement.setInt(7, loja.getId_categoria_loja());
    		preparedStatement.setInt(8, loja.getId_loja());
    		
    		preparedStatement.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
    @Override
    public void remove(Loja loja) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "DELETE FROM loja WHERE id_loja = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, loja.getId_loja());
    		preparedStatement.execute();
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }

}
