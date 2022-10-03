package CRUD;

import java.util.Scanner;

import DAO.doacaoDAO;
import DAO.doadorDAO;
import model.Doacao;
import model.Doador;

public class doacaoCRUD {

	public static void main(String[] args) {
		
		doacaoDAO doacaoDAO = new doacaoDAO();
		doadorDAO doadorDAO = new doadorDAO();
		
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;
		
		int id_doacao = 0;
		int id_doador = 0;
		int num_pedido = 0;
		String nomeD = "";
		String data = "";
		
		do {
			System.out.println("--- Doação ---");
			System.out.println("1 - Cadastrar Doação");
			System.out.println("2 - Consultar Doação");
			System.out.println("3 - Atualizar Doação");
			System.out.println("4 - Deletar Doação");
			System.out.println("5 - Buscar por Id");
			System.out.println("0 - Sair");
			opcao = input.nextInt();
			input.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("--- Cadastrar Doação ---");
				System.out.println("Digite o N° do Pedido: ");
				num_pedido = input.nextInt();
				System.out.println("Digite a Data da Doação: ");
				data = input.next();
				System.out.println("Digite o Id do Doador: ");
				id_doador = input.nextInt();
				input.nextLine();
				System.out.println("Digite o Nome do Doador: ");
				nomeD = input.next();
				input.nextLine();
				
				Doador doador = doadorDAO.getDoadorById(id_doador);
				Doacao doacao = new Doacao(id_doacao, data, id_doador, nomeD, doador);
				doacaoDAO.save(doacao);
				
				System.out.println("--- Doação Cadastradas ---\n");
				break;
				
			case 2:
				System.out.println("--- Consultar Doação ---");
				for (Doacao l : doacaoDAO.getDoacao()) {
					System.out.println("Id: " + l.getId_doacao() + "\n" + "N° da Doação: " + l.getNum_pedido() + ", Data Doação: " + "\n"
										+ ", Nome Doador: " + l.getDoador().getNome_doador() + "\n");
				}
				System.out.println("--- Consulta Realizada ---\n");
				break;
				
			case 3:
				System.out.println("--- Atualizar Doação ---");
				System.out.println("Digite o id da Doação: ");
				posicao = input.nextInt();
				input.nextLine();
				System.out.println("Digite o nome do Doador: ");
				nomeD = input.next();
				System.out.println("Digite o N° do Pedido: ");
				num_pedido = input.nextInt();
				System.out.println("Digite a Data da Doação: ");
				data = input.next();
				input.nextLine();
				
				Doador doador1 = doadorDAO.getDoadorById(id_doador);
				Doacao doacao1 = new Doacao(posicao, nomeD, num_pedido, data, doador1);
				doacaoDAO.update(doacao1);
				
				System.out.println("--- Doação Atualizada ---\n");
				break;
				
			case 4:
				System.out.println("--- Deletar Doação ---");
				System.out.println("Digite o Id da doação: ");
				posicao = input.nextInt();
				doacaoDAO.deleteById(posicao);
				
				System.out.println("--- Doação Deletada ---\n");
				break;
				
			case 5:
				System.out.println("--- Buscar Doação ---");
				System.out.println("Digite o Id da Doação: ");
				posicao = input.nextInt();
				Doacao doacao2 = doacaoDAO.getDoacaoById(posicao);
				
				System.out.println("Id: " + doacao2.getId_doacao() + "\n" + ", N° do Pedido: " + doacao2.getNum_pedido() + "\n"
									+ ", Data da Doação: " + doacao2.getData_doacao() 
									+ "Doador: " + doacao2.getNome_doador());
				
				System.out.println("--- Busca Realizada ---\n");
				break;
				
			default: 
				System.out.println(opcao != 0 ? "Opção inválida, escolha uma opção válida" : "");
				break;
			}
		} while (opcao != 0);
	
		System.out.println("--- Operação Finalizada ---\n");
	}
}
