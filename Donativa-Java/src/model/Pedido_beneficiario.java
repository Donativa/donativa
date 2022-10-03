package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido_beneficiario {

	private int id_pedido;
	private int num_pedido;
	private LocalDate data_pedido;
	private String nome_beneficiario;
	private int quantidade_itens;

	private Beneficiario beneficiario;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");

	public Pedido_beneficiario() {

	}

	public Pedido_beneficiario(int id_pedido, int num_pedido, String data_pedido, String nome_beneficiario,
			int quantidade_itens, Beneficiario beneficiario, DateTimeFormatter formatter) {
		this.id_pedido = id_pedido;
		this.num_pedido = num_pedido;
		this.data_pedido = LocalDate.parse(data_pedido, formatter);
		this.nome_beneficiario = nome_beneficiario;
		this.quantidade_itens = quantidade_itens;
		this.beneficiario = beneficiario;
		this.formatter = formatter;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	public String getData_pedido() {
		return formatter.format(data_pedido);
	}

	public void setData_pedido(String data_pedido) {
		this.data_pedido = LocalDate.parse(data_pedido, formatter);
	}

	public String getNome_beneficiario() {
		return nome_beneficiario;
	}

	public void setNome_beneficiario(String nome_beneficiario) {
		this.nome_beneficiario = nome_beneficiario;
	}

	public int getQuantidade_itens() {
		return quantidade_itens;
	}

	public void setQuantidade_itens(int quantidade_itens) {
		this.quantidade_itens = quantidade_itens;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
	
	@Override
	public String toString() {
		return "Pedidos [id=" + id_pedido + ", nome=" + nome_beneficiario + ", data do pedido=" + data_pedido + ", numero do pedido=" + num_pedido + "quantidade de itens=" + quantidade_itens + "]";
	}
}