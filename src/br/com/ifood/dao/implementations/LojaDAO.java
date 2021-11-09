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

	/* PROPERTIES */
	
	private List<Loja> lojas = new ArrayList<Loja>();
    
	/* METHODS */
	
    @Override
    public Optional<Loja> get(int id) {
    	Loja user = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT user_id,"
    			+ "    user_name,"
    			+ "    email,"
    			+ "    user_access,"
    			+ "    active,"
    			+ "    user_password,"
    			+ "    created_at "
    			+ "FROM tb_user "
    			+ "WHERE user_id = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			/*user = new Loja(
    					result.getInt("user_id"),
    					result.getString("user_name"), 
    					result.getString("email"), 
    					result.getInt("user_access"),
    					result.getBoolean("active"),
    					result.getString("user_password"),
    					result.getDate("created_at")
					);*/
    		}
    	} catch (Exception e) {
    		System.err.println("[User] " + e.getMessage());
    		// e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				System.err.println("[Connection Factory] " + e.getMessage());
	    		// e.printStackTrace();
			}
    	}
    	
        return Optional.ofNullable(user);
    }
    
    @Override
    public List<Loja> getAll() {
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "SELECT user_id,"
    			+ "    user_name,"
    			+ "    email,"
    			+ "    user_access,"
    			+ "    active,"
    			+ "    user_password,"
    			+ "    created_at "
    			+ "FROM tb_user";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			/*Loja user = new Loja(
    					result.getInt("user_id"),
    					result.getString("user_name"), 
    					result.getString("email"), 
    					result.getInt("user_access"),
    					result.getBoolean("active"),
    					result.getString("user_password"),
    					result.getDate("created_at")
					);
    			users.add(user);*/
    		}
    	} catch (Exception e) {
    		System.err.println("[User] " + e.getMessage());
    		// e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				System.err.println("[Connection Factory] " + e.getMessage());
	    		// e.printStackTrace();
			}
    	}
    	
        return lojas;
    }
    
    @Override
    public void save(Loja user) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "INSERT INTO tb_user(user_id, user_name, email, user_access, active, user_password, created_at) "
    			+ "    VALUES (user_id_seq.nextval, ?, ?, ?, ?, ?, ?)";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		
    		/*user.setAccess(1);
        	user.setActive(true);
        	user.setCreated_at(new Date());

    		preparedStatement.setString(1, user.getName());
    		preparedStatement.setString(2, user.getEmail());
    		preparedStatement.setInt(3, user.getAccess());
    		preparedStatement.setBoolean(4, user.isActive());
    		preparedStatement.setString(5, user.getPassword());
    		preparedStatement.setDate(6, new java.sql.Date(user.getCreated_at().getTime()));*/
    		
    		preparedStatement.execute();
    	} catch (Exception e) {
    		System.err.println("[User] " + e.getMessage());
    		// e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				System.err.println("[Connection Factory] " + e.getMessage());
	    		// e.printStackTrace();
			}
    	}
    }
    
    @Override
    public void update(Loja user) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "UPDATE tb_user SET active = ? WHERE user_id = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		/*preparedStatement.setBoolean(1, user.isActive());
    		preparedStatement.setInt(2, user.getUser_id());*/
    		
    		preparedStatement.execute();
    	} catch (Exception e) {
    		System.err.println("[User] " + e.getMessage());
    		// e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				System.err.println("[Connection Factory] " + e.getMessage());
	    		// e.printStackTrace();
			}
    	}
    }
    
    @Override
    public void remove(Loja user) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "DELETE FROM tb_user WHERE user_id = ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		// preparedStatement.setInt(1, user.getUser_id());
    		preparedStatement.execute();
    	} catch (Exception e) {
    		System.err.println("[User] " + e.getMessage());
    		// e.printStackTrace();
    	} finally {
    		try {
				ConnectionFactory.closeConnection();
			} catch (SQLException e) {
				System.err.println("[Connection Factory] " + e.getMessage());
	    		// e.printStackTrace();
			}
    	}
    }

}
