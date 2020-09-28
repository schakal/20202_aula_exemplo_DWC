package model;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String descricao;
	private int pessoa_id;
	
	public Endereco() {
	}
	
	public Endereco(int id, String descricao, int _pessoa_id) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pessoa_id = _pessoa_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(int pessoa_id) {
		this.pessoa_id = pessoa_id;
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
		Endereco other = (Endereco) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
}
