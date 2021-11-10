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
import br.com.ifood.models.Endereco;
import br.com.ifood.singleton.ConnectionFactory;

public class EnderecoDAO implements DAO<Endereco> {
    	
    @Override
    public Optional<Endereco> get(int id) {
    	Endereco endereco = null;
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, id);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			endereco = new Endereco(
    					// result.getInt("id_categoria"),
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
    	
        return Optional.ofNullable(endereco);
    }
    
    @Override
    public List<Endereco> getAll() {
    	List<Endereco> enderecos = new ArrayList<>();
        Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		ResultSet result = preparedStatement.executeQuery();
    		
    		while(result.next()) {
    			Endereco categoria = new Endereco(
    					// result.getInt("id_categoria"),
					);
    			enderecos.add(categoria);
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
    	
        return enderecos;
    }
    
    @Override
    public void save(Endereco endereco) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "INSERT INTO endereco (nr_cep, cd_uf, nm_cidade, nm_bairro, nm_endereco, nr_numero, ds_complemento, id_loja_endereco) "
    			+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		 preparedStatement.setString(1, endereco.getNr_cep());
    		 preparedStatement.setString(2, endereco.getCd_uf());
    		 preparedStatement.setString(3, endereco.getNm_cidade());
    		 preparedStatement.setString(4, endereco.getNm_bairro());
    		 preparedStatement.setString(5, endereco.getNm_endereco());
    		 preparedStatement.setInt(6, endereco.getNr_numero());
    		 preparedStatement.setString(7, endereco.getDs_complemento());
    		 preparedStatement.setInt(8, endereco.getEndereco_loja().getId_loja());
    		
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
    public void update(Endereco endereco) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "UPDATE endereco SET nm_endereco = ? WHERE id_endereco= ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);

    		 preparedStatement.setString(1, endereco.getNm_endereco());
    		 preparedStatement.setInt(2, endereco.getId_endereco());
    		
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
    public void remove(Endereco endereco) throws DBException {
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	String sql = "DELETE FROM endereco WHERE id_endereco= ?";
    	
    	try {
    		connection = ConnectionFactory.getInstance();
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, endereco.getId_endereco());
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
