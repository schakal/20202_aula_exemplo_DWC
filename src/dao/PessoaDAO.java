package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Pessoa;

public class PessoaDAO implements PessoaDaoIn {

	private Connection conexao;
	
	public PessoaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Insert(Pessoa _objeto) throws SQLException {
		
		String SQL = "INSERT INTO pessoa (nome, cel) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getCel());
		
		ps.execute();

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Pessoa _objeto) throws SQLException {
		
		String SQL = "UPDATE pessoa SET nome = ?, cel = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getCel());
		ps.setInt(3, _objeto.getId());
		
		return ps.execute();
	}

	@Override
	public List<Pessoa> GetAll() throws SQLException {
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		String SQL = "SELECT id, nome, cel FROM pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String cel = rs.getString(3);
			
			EnderecoDAO daoEndereco = new EnderecoDAO(conexao);
			
			List<Endereco> listaEnderecosDaPessoa = daoEndereco.GetAllForPessoa(id);
			
			listaPessoas.add(new Pessoa(id, nome, cel, listaEnderecosDaPessoa));
		}
		
		
		return listaPessoas;
	}

	@Override
	public Pessoa GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT id, nome, cel FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String cel = rs.getString(3);
			
			EnderecoDAO daoEndereco = new EnderecoDAO(conexao);
			
			List<Endereco> listaEnderecosDaPessoa = daoEndereco.GetAllForPessoa(id);
			
			Pessoa pessoa = new Pessoa(id, nome, cel, listaEnderecosDaPessoa);
			
			return pessoa;
		}
		
		return null;
	}

}
