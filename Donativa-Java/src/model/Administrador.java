package model;

public class Administrador extends Usuarios {

	private int id_adm;
	private String nome_adm;
	
	private Usuarios usuarios;

	public Administrador() {
		
	}

	public Administrador(int id_adm, String nome_adm, Usuarios usuarios) {
		this.id_adm = id_adm;
		this.nome_adm = nome_adm;
		this.usuarios = usuarios;
	}

	public int getId_adm() {
		return id_adm;
	}

	public void setId_adm(int id_adm) {
		this.id_adm = id_adm;
	}

	public String getNome_adm() {
		return nome_adm;
	}

	public void setNome_adm(String nome_adm) {
		this.nome_adm = nome_adm;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public String toString() {
		return "Administrador [id= " + id_adm + ", Nome= " + nome_adm + "\n"
				+ "Usuario= " + usuarios + "]";
		}

}

