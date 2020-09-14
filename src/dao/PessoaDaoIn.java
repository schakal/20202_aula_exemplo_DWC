package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pessoa;

public interface PessoaDaoIn {

	void Insert(Pessoa _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Pessoa _objeto) throws SQLException;
	
	List<Pessoa> GetAll() throws SQLException;
	
	Pessoa GetForID(int _id) throws SQLException;
}
