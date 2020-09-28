package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String cel;
	
	private List<Endereco> enderecos;
	
	public Pessoa() {
		this.enderecos = new ArrayList<Endereco>();
	}

	public Pessoa(int id, String nome, String cel, List<Endereco> _enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cel = cel;
		this.enderecos = _enderecos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa (id:" + id + ", nome:" + nome + ", cel:" + cel + ")";
	}	
}
