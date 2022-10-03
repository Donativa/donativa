package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Doacao {
	

	private int id_doacao;
	private String nome_doador;
	private int num_pedido;
	private LocalDate data_doacao;
	
	private Doador doador;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
	
	public Doacao(){
		
	}

	public Doacao(int id_doacao, String nome_doador, int num_pedido, String data_doacao, Doador doador) {
		super();
		this.id_doacao = id_doacao;
		this.nome_doador = nome_doador;
		this.num_pedido = num_pedido;
		this.data_doacao = LocalDate.parse(data_doacao, formatter);
		this.doador = doador;
	}

	public int getId_doacao() {
		return id_doacao;
	}

	public void setId_doacao(int id_doacao) {
		this.id_doacao = id_doacao;
	}

	public String getNome_doador() {
		return nome_doador;
	}

	public void setNome_doador(String nome_doador) {
		this.nome_doador = nome_doador;
	}

	public int getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	public String getData_doacao() {
		return formatter.format(data_doacao);
	}

	public void setData_doacao(String data_doacao) {
		this.data_doacao = LocalDate.parse(data_doacao, formatter);
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	@Override
	public String toString() {
		return "Doacao [id=" + id_doacao + "nome doador=" + nome_doador + "numero do pedido=" + num_pedido + "data doacao=" + data_doacao + "]";
	}
}
