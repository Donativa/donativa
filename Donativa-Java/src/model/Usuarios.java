package model;

public class Usuarios {
	

	private int id_usuario;
	private String nome_usuario;
	private String email;
	private String senha;
	
	public Usuarios(){
		
	}

	public Usuarios(int id_usuario, String nome_usuario, String email, String senha) {
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
		this.email = email;
		this.senha = senha;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	
	@Override
	public String toString() {
		return "Usuarios [id=" + id_usuario + ", nome=" + nome_usuario + ", email=" + email + ", senha=" + senha + "]";
	}
	
}