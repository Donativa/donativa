package model;

public class Permissoes {
	
	
	private int id_permissao;
	private String tipoPermissao;
	
	public Permissoes(){
		
	}

	public Permissoes(int id_permissao, String tipoPermissao) {
		super();
		this.id_permissao = id_permissao;
		this.tipoPermissao = tipoPermissao;
	}

	public int getId_permissao() {
		return id_permissao;
	}

	public void setId_permissao(int id_permissao) {
		this.id_permissao = id_permissao;
	}

	public String getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(String tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

	public boolean acessa_sistema() {
		return false;	
	}

}
