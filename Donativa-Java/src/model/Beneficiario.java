package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Beneficiario extends Usuarios {

	private int id_beneficiario;
	private String nome_beneficiario;
	private int cpf_beneficiario;
	private int rg_beneficiario;
	private LocalDate data_nascimento_beneficiario;
	private int telefone_beneficiaro;
	private String genero_beneficiario;
	private boolean aceite_termos_beneficiario;
	
	private Usuarios usuarios;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");

	public Beneficiario(){
		
	}

	public Beneficiario(int id_beneficiario, String nome_beneficiario, int cpf_beneficiario, int rg_beneficiario,
			String data_nascimento_beneficiario, int telefone_beneficiaro, String genero_beneficiario,
			boolean aceite_termos_beneficiario, Usuarios usuarios) {
		this.id_beneficiario = id_beneficiario;
		this.nome_beneficiario = nome_beneficiario;
		this.cpf_beneficiario = cpf_beneficiario;
		this.rg_beneficiario = rg_beneficiario;
		this.data_nascimento_beneficiario = LocalDate.parse(data_nascimento_beneficiario, formatter);
		this.telefone_beneficiaro = telefone_beneficiaro;
		this.genero_beneficiario = genero_beneficiario;
		this.aceite_termos_beneficiario = aceite_termos_beneficiario;
		this.usuarios = usuarios;
	}

	public Beneficiario(int id, String nome, int cpf, int rg, int telefone, String data_nasc, String genero,
			Usuarios usuario) {
		// TODO Auto-generated constructor stub
	}

	public int getId_beneficiario() {
		return id_beneficiario;
	}

	public void setId_beneficiario(int id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}

	public String getNome_beneficiario() {
		return nome_beneficiario;
	}

	public void setNome_beneficiario(String nome_beneficiario) {
		this.nome_beneficiario = nome_beneficiario;
	}

	public int getCpf_beneficiario() {
		return cpf_beneficiario;
	}

	public void setCpf_beneficiario(int cpf_beneficiario) {
		this.cpf_beneficiario = cpf_beneficiario;
	}

	public int getRg_beneficiario() {
		return rg_beneficiario;
	}

	public void setRg_beneficiario(int rg_beneficiario) {
		this.rg_beneficiario = rg_beneficiario;
	}

	public String getData_nascimento_beneficiario() {
		return formatter.format(data_nascimento_beneficiario);
	}

	public void setData_nascimento_beneficiario(String data_nascimento_beneficiario) {
		this.data_nascimento_beneficiario = LocalDate.parse(data_nascimento_beneficiario, formatter);
	}

	public int getTelefone_beneficiaro() {
		return telefone_beneficiaro;
	}

	public void setTelefone_beneficiaro(int telefone_beneficiaro) {
		this.telefone_beneficiaro = telefone_beneficiaro;
	}

	public String getGenero_beneficiario() {
		return genero_beneficiario;
	}

	public void setGenero_beneficiario(String genero_beneficiario) {
		this.genero_beneficiario = genero_beneficiario;
	}

	public boolean isAceite_termos_beneficiario() {
		return aceite_termos_beneficiario;
	}

	public void setAceite_termos_beneficiario(boolean aceite_termos_beneficiario) {
		this.aceite_termos_beneficiario = aceite_termos_beneficiario;
	}
	
	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Beneficiario [id=" + ", nome= " + nome_beneficiario + ", cpf= " + cpf_beneficiario + ", rg= " + rg_beneficiario + ", Data Nascimento= " + data_nascimento_beneficiario + ", genero= " + genero_beneficiario + "Usuario= " + usuarios + "]"; 
	}
	
}
