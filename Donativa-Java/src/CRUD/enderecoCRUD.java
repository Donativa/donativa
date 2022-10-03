package CRUD;

import java.util.Scanner;

import DAO.beneficiariosDAO;
import DAO.enderecoDAO;
import model.Beneficiario;
import model.Endereco;

public class enderecoCRUD {
	
	public static void main(String[] args) {
		
		beneficiariosDAO beneficiariosDAO = new beneficiariosDAO();
		enderecoDAO enderecoDAO = new enderecoDAO();
		
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;
		
		int id_endereco = 0;
		String rua = "";
		int numero = 0;
		String cep = "";
		String bairro = "";
		String estado = "";
		String cidade = "";
		String nomeB = "";
		int id_beneficiario = 0;
		
		do {
			System.out.println("--- Endereco ---");
			System.out.println("1 - Cadastrar Endereço");
			System.out.println("2 - Consultar Endereço");
			System.out.println("3 - Atualizar Endereco");
			System.out.println("4 - Deletar Endereço");
			System.out.println("5 - Buscar por Id");
			System.out.println("0 - Sair");
			opcao = input.nextInt();
			input.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("--- Cadastrar Endereço ---");
				System.out.println("Digite o nome da Rua: ");
				rua = input.nextLine();
				System.out.println("Digite o número: ");
				numero = input.nextInt();
				System.out.println("Digite o Cep: ");
				cep = input.next();
				System.out.println("Digite o Bairro: ");
				bairro = input.next();
				System.out.println("Digite a Cidade: ");
				cidade = input.next();
				System.out.println("Digite o Estado: ");
				estado = input.next();
				System.out.println("Digite o nome do Beneficiario: ");
				nomeB = input.next();
				
				Beneficiario beneficiario = beneficiariosDAO.getBeneficiarioById(id_beneficiario);
				Endereco endereco = new Endereco(id_endereco, rua, numero, cep, bairro, cidade, estado, nomeB, beneficiario);
				enderecoDAO.save(endereco);
				
				System.out.println("--- Endereço Cadastrado ---\n");
				break;
				
			case 2:
				System.out.println("--- Consultar Endereço ---");
				for (Endereco l : enderecoDAO.getEndereco()){
					System.out.println("Id: " + l.getId_endereco() + "Rua: " + l.getRua() + "N°: " + l.getNumero() 
					+ "CEP: " + l.getCep() + "Bairro: " + l.getBairro() + "Cidade: " + l.getCidade()
					+ "Estado: " + l.getEstado() + "Beneficiario: " + l.getBeneficiario().getNome_beneficiario() + "\n");
				}
				System.out.println("--- Consulta Realizada ---\n");
				break;
				
			case 3: 
				System.out.println("--- Atualizar Endereço ---");
				posicao = input.nextInt();
				input.nextLine();
				System.out.println("Digite a Rua: ");
				rua = input.next();
				System.out.println("Digite o número: ");
				numero = input.nextInt();
				System.out.println("Digite o Cep: ");
				cep = input.next();
				System.out.println("Digite o Bairro: ");
				bairro = input.next();
				System.out.println("Digite a Cidade: ");
				cidade = input.next();
				System.out.println("Digite o Estado: ");
				estado = input.next();
				System.out.println("Digite o nome do Beneficiario: ");
				nomeB = input.next();
				input.nextLine();
				
				Beneficiario beneficiario1 = beneficiariosDAO.getBeneficiarioById(id_beneficiario);
				Endereco endereco1 = new Endereco(posicao, rua, numero, cep, bairro, cidade, estado, beneficiario1);
				enderecoDAO.update(endereco1);
				
				System.out.println("--- Endereco Atualizado ---\n");
				break;
				
			case 4:
				System.out.println("--- Deletar Endereço ---");
				posicao = input.nextInt();
				enderecoDAO.deleteById(posicao);
				
				System.out.println("--- Endereco Deletado ---\n");
				break;
				
			case 5:
				System.out.println("--- Buscar por ID ---");
				System.out.println("Digite o id do endereço: ");
				posicao = input.nextInt();
				Endereco endereco2 = enderecoDAO.getEnderecoById(posicao);
				
				System.out.println("Id: " + endereco2.getId_endereco() + "Rua: " + endereco2.getRua() + "N°: " + endereco2.getNumero() + "cep: " + endereco2.getCep() + "Bairro: " + endereco2.getBairro() + "Cidade: " + endereco2.getCidade() + "Estado: " + endereco2.getEstado() 
				+ "Beneficiario: " + endereco2.getBeneficiario().getNome_beneficiario());
				
				System.out.println("--- Busca por Id Reaizada ---\n");
				break;
				
			default:
				System.out.println(opcao != 0 ? "Opção inválida, digite uma opção válida!" : "");
				break;
			}
		} while (opcao != 0);
		
		System.out.println("Sistema finalizado");
		input.close();
	}
}
