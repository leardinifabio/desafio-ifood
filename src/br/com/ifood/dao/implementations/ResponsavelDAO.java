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
import br.com.ifood.models.Responsavel;
import br.com.ifood.singleton.ConnectionFactory;

public class ResponsavelDAO implements DAO<Responsavel> {
    	
    @Override
    public Optional<Responsavel> get(int id) {
    	Responsavel responsavel = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_responsavel,"
    			+ "    	nm_responsavel,"
    			+ "		nr_cpf,"
    			+ "		nr_rg,"
    			+ "		id_loja_responsavel "
    			+ "FROM responsavel"
    			+ "		WHERE id_responsavel = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			responsavel = new Responsavel(
    					result.getInt("id_responsavel"),
    					result.getString("nm_responsavel"),
    					result.getString("nr_cpf"),
    					result.getString("nr_rg"),
    					result.getInt("id_loja_responsavel")
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
    	
        return Optional.ofNullable(responsavel);
    }
    
    public Optional<Responsavel> getByLojaId(int id) {
    	Responsavel responsavel = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_responsavel,"
    			+ "    	nm_responsavel,"
    			+ "		nr_cpf,"
    			+ "		nr_rg,"
    			+ "		id_loja_responsavel "
    			+ "FROM responsavel"
    			+ "		WHERE id_loja_responsavel = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			responsavel = new Responsavel(
    					result.getInt("id_responsavel"),
    					result.getString("nm_responsavel"),
    					result.getString("nr_cpf"),
    					result.getString("nr_rg"),
    					result.getInt("id_loja_responsavel")
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
    	
        return Optional.ofNullable(responsavel);
    }
    
    @Override
    public List<Responsavel> getAll() {
    	List<Responsavel> responsaveis = new ArrayList<>();
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT"
    			+ "	   	id_responsavel,"
    			+ "    	nm_responsavel,"
    			+ "		nr_cpf,"
    			+ "		nr_rg,"
    			+ "		id_loja_responsavel "
    			+ "FROM responsavel";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			Responsavel responsavel = new Responsavel(
    					result.getInt("id_responsavel"),
    					result.getString("nm_responsavel"),
    					result.getString("nr_cpf"),
    					result.getString("nr_rg"),
    					result.getInt("id_loja_responsavel")
					);
    			responsaveis.add(responsavel);
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
    	
        return responsaveis;
    }
    
    @Override
    public Optional<Responsavel> save(Responsavel responsavel) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "INSERT INTO responsavel (nm_responsavel, nr_cpf, nr_rg, id_loja_responsavel) VALUES (?, ?, ?, ?)";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql, new String[] {"id_responsavel"});

    		preparedStatement.setString(1, responsavel.getNm_responsavel());
    		preparedStatement.setString(2, responsavel.getNr_cpf());
    		preparedStatement.setString(3, responsavel.getNr_rg());
    		preparedStatement.setInt(4, responsavel.getId_loja_responsavel());
    		
    		int affectedRows = preparedStatement.executeUpdate();
     		if (affectedRows == 0) {
     			throw new DBException("Creating responsavel failed, no rows affected.");
     		}
     		
     		ResultSet result = preparedStatement.getGeneratedKeys();
     		if (result.next()) {
     			responsavel.setId_responsavel(result.getInt(1));
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
    	
    	return Optional.ofNullable(responsavel);
    }
    
    @Override
    public void update(Responsavel responsavel) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "UPDATE responsavel SET nm_responsavel = ?, nr_cpf = ?, nr_rg = ? WHERE id_responsavel = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		preparedStatement.setString(1, responsavel.getNm_responsavel());
    		preparedStatement.setString(2, responsavel.getNr_cpf());
    		preparedStatement.setString(3, responsavel.getNr_rg());
    		preparedStatement.setInt(4, responsavel.getId_responsavel());
    		
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
    public void remove(Responsavel responsavel) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "DELETE FROM responsavel WHERE id_responsavel = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, responsavel.getId_responsavel());
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
