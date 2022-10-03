package model;

public class Endereco {

	private int id_endereco;
	private String rua;	
	private int numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	
	private Beneficiario beneficiario;
	private Doador doador;
	
	public Endereco(){

	}

	public Endereco(int id_endereco, String rua, int numero, String cep, String bairro, String cidade, String estado,
			Beneficiario beneficiario, Doador doador) {
		this.id_endereco = id_endereco;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.beneficiario = beneficiario;
		this.doador = doador;
	}

	public Endereco(int posicao, String rua2, int numero2, String cep2, String bairro2, String cidade2, String estado2,
			Beneficiario beneficiario1) {
		// TODO Auto-generated constructor stub
	}

	public Endereco(int id_endereco2, String rua2, int numero2, String cep2, String bairro2, String cidade2,
			String estado2, String nomeB, Beneficiario beneficiario2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	
	@Override
	public String toString() {
		return "Enderecos [id= " + id_endereco + "Rua= " + rua + "numero= " + numero + "CEP= " + cep + "Bairro= " + bairro + "Cidade= " + cidade + "Estado= " + estado
				+ "Beneficiario= " + beneficiario + "Doador= " + doador + "]";
	}
}
