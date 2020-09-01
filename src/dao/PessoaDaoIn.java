package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pessoa;

public interface PessoaDaoIn {

	void Insert(Pessoa _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Pessoa _objeto) throws SQLException;
	
	List<Pessoa> getAll() throws SQLException;
	
	Pessoa get(int _id) throws SQLException;
}
