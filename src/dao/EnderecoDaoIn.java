package dao;

import java.sql.SQLException;
import java.util.List;

import model.Endereco;

public interface EnderecoDaoIn {

	void Insert(Endereco _objeto) throws SQLException;
	
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Endereco _objeto) throws SQLException;
	
	List<Endereco> GetAll() throws SQLException;
	
	List<Endereco> GetAllForPessoa(int _pessoaID) throws SQLException;
	
	Endereco GetForID(int _id) throws SQLException;
}
