package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Doador extends Usuarios {
	
	private int id_doador;
	private String nome_doador;
	private int cpf_doador;
	private int cnpj_doador;
	private int rg_doador;
	private String genero_doador;
	private int telefone_doador;
	private LocalDate data_nascimento_doador;
	private boolean aceite_termos_doador;
	
	private Usuarios usuarios;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");

	public Doador(){
		
	}

	public Doador(int id_doador, String nome_doador, int cpf_doador, int cnpj_doador, int rg_doador,
			String genero_doador, int telefone_doador, String data_nascimento_doador, boolean aceite_termos_doador,
			Usuarios usuarios) {
		this.id_doador = id_doador;
		this.nome_doador = nome_doador;
		this.cpf_doador = cpf_doador;
		this.cnpj_doador = cnpj_doador;
		this.rg_doador = rg_doador;
		this.genero_doador = genero_doador;
		this.telefone_doador = telefone_doador;
		this.data_nascimento_doador = LocalDate.parse(data_nascimento_doador, formatter);
		this.aceite_termos_doador = aceite_termos_doador;
		this.usuarios = usuarios;
	}



	public int getId_doador() {
		return id_doador;
	}

	public void setId_doador(int id_doador) {
		this.id_doador = id_doador;
	}

	public String getNome_doador() {
		return nome_doador;
	}

	public void setNome_doador(String nome_doador) {
		this.nome_doador = nome_doador;
	}

	public int getCpf_doador() {
		return cpf_doador;
	}

	public void setCpf_doador(int cpf_doador) {
		this.cpf_doador = cpf_doador;
	}

	public int getCnpj_doador() {
		return cnpj_doador;
	}

	public void setCnpj_doador(int cnpj_doador) {
		this.cnpj_doador = cnpj_doador;
	}

	public int getRg_doador() {
		return rg_doador;
	}

	public void setRg_doador(int rg_doador) {
		this.rg_doador = rg_doador;
	}

	public String getGenero_doador() {
		return genero_doador;
	}

	public void setGenero_doador(String genero_doador) {
		this.genero_doador = genero_doador;
	}

	public int getTelefone_doador() {
		return telefone_doador;
	}

	public void setTelefone_doador(int telefone_doador) {
		this.telefone_doador = telefone_doador;
	}

	public String getData_nascimento_doador() {
		return formatter.format(data_nascimento_doador);
	}

	public void setData_nascimento_doador(String data_nascimento_doador) {
		this.data_nascimento_doador = LocalDate.parse(data_nascimento_doador, formatter);
	}

	public boolean isAceite_termos_doador() {
		return aceite_termos_doador;
	}

	public void setAceite_termos_doador(boolean aceite_termos_doador) {
		this.aceite_termos_doador = aceite_termos_doador;
	}
	
	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@Override 
	public String toString() {
		return "Doador [Id= " + id_doador + ", nome= " + nome_doador + ", cpf= " + cpf_doador + ", rg= " + rg_doador + ", cnpj= " + cnpj_doador + ", Data de Nascimento= " + data_nascimento_doador + ", telefone= " + telefone_doador + ", Genero= " + genero_doador 
				+ ", Usuários= " + usuarios + "]";
	}
}
	