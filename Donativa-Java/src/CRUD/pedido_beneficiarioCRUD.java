package CRUD;

import java.util.Scanner;

import DAO.beneficiariosDAO;
import DAO.pedido_beneficiarioDAO;
import model.Beneficiario;
import model.Pedido_beneficiario;

public class pedido_beneficiarioCRUD {

	public static void main(String[] args) {
		pedido_beneficiarioDAO pedido_beneficiarioDAO = new pedido_beneficiarioDAO();
		beneficiariosDAO beneficiariosDAO = new beneficiariosDAO();
	
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;
		
		int num_pedido = 0;
		int quantidade_itens = 0;
		String data = "";
		String nomeB = "";
		int id_beneficiario = 0;
		
		do {
			System.out.println("--- Pedido Beneficiario ---");
			System.out.println("1 - Cadastrar Pedido");
			System.out.println("2 - Consultar Pedido");
			System.out.println("3 - Atualizar Pedido");
			System.out.println("4 - Deletar Pedido");
			System.out.println("5 - Buscar Pedido por Id");
			System.out.println("0 - Sair");
			opcao = input.nextInt();
			input.nextLine();
			
			switch (opcao) {
			case 1: 
				System.out.println("--- Cadastrar Pedido ---");
				System.out.println("Digite o N° do pedido: ");
				num_pedido = input.nextInt();
				System.out.println("Digite a quantidade de Itens: ");
				quantidade_itens = input.nextInt();
				System.out.println("Digite a data do pedido: ");
				data = input.next();
				System.out.println("Digite o nome do Beneficiario: ");
				nomeB = input.next();
				input.nextLine();
				
				Beneficiario beneficiario = beneficiariosDAO.getBeneficiarioById(id_beneficiario);
				Pedido_beneficiario pedido1 = new Pedido_beneficiario(num_pedido, quantidade_itens, data, nomeB, id_beneficiario, beneficiario, null);
				pedido_beneficiarioDAO.save(pedido1);
				
				System.out.println("--- Pedido Cadastrado ---\n");
				break;
				
			case 2:
				for (Pedido_beneficiario l : pedido_beneficiarioDAO.getPedido_beneficiario()) {
					System.out.println("Id: " + l.getId_pedido() + " Nº Pedido: " + l.getNum_pedido() + "Quantida de Itens: " + l.getQuantidade_itens() + "Data: " + l.getData_pedido()
					+ "Beneficiario: " + l.getBeneficiario().getNome_beneficiario());
				}
				System.out.println("--- Consulta Realizada ---\n");
				break;
				
			case 3:
				System.out.println("--- Atualizar Pedido ---");
				System.out.println("Digite o id do Pedido: ");
				posicao = input.nextInt();
				input.nextLine();
				System.out.println("Digite o Nº do Pedido: ");
				num_pedido = input.nextInt();
				System.out.println("Digite a Quantidade de Itens: ");
				quantidade_itens = input.nextInt();
				System.out.println("Digite a Data do Pedido: ");
				data = input.next();
				System.out.println("Digite o Id do beneficiario: ");
				id_beneficiario = input.nextInt();
				System.out.println("Digite o nome do Beneficiario: ");
				nomeB = input.next();
				input.nextLine();
				
				Beneficiario beneficiario1 = beneficiariosDAO.getBeneficiarioById(id_beneficiario);
				Pedido_beneficiario pedido2 = new Pedido_beneficiario(posicao, num_pedido, data, nomeB, id_beneficiario, beneficiario1, null);
				pedido_beneficiarioDAO.update(pedido2);
				
				System.out.println("--- Pedido Atualizado ---\n");
				break;
				
			case 4: 
				System.out.println("--- Deletar Pedido ---");
				System.out.println("Digite o Id do Pedido: ");
				posicao = input.nextInt();
				pedido_beneficiarioDAO.deleteById(posicao);
				
				System.out.println("--- Pedido Deletado ---\n");
				break;
				
			case 5:
				System.out.println("--- Buscar por Id ---");
				System.out.println("Digite o Id do Pedido: ");
				posicao = input.nextInt();
				Pedido_beneficiario pedido3 = pedido_beneficiarioDAO.getPedido_beneficiarioById(posicao);
				
				System.out.println("Id: " + pedido3.getId_pedido() + "N° Pedido: " + pedido3.getNum_pedido() + "Quantidade de Itens: " + pedido3.getQuantidade_itens() + "Data: " + pedido3.getData_pedido() 
				+ "Beneficiario: " + pedido3.getBeneficiario().getNome_beneficiario() + "\n");
				
				System.out.println("--- Busca Realizada ---");
				break;
				
			default: 
				System.out.println(opcao != 0 ? "Opção inválida, escolha uma opção válida" : "");
				break;
			}
		} while (opcao != 0);
		
		System.out.println("Operação finalizada");
		input.close();
	}
}
