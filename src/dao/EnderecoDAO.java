package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;

public class EnderecoDAO implements EnderecoDaoIn {

	private Connection conexao;
	
	public EnderecoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Insert(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Update(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> GetAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco GetForID(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> GetAllForPessoa(int _pessoaID) throws SQLException {

		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		
		String SQL = "SELECT id, descricao FROM endereco WHERE pessoa_id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _pessoaID);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String descricao = rs.getString(2);
						
			listaEnderecos.add(new Endereco(id, descricao));
		}
		
		
		return listaEnderecos;
	}

}
