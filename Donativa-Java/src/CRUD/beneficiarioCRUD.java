package CRUD;

import java.util.Scanner;
import DAO.beneficiariosDAO;
import DAO.usuariosDAO;
import model.Beneficiario;
import model.Usuarios;

public class beneficiarioCRUD {
	
	public static void main(String[] args) {
		
		usuariosDAO usuariosDAO = new usuariosDAO();
		beneficiariosDAO beneficiariosDAO = new beneficiariosDAO();
		
		Scanner input = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
		
		int id = 0;
		String nome = "";
		int cpf = 0;
		int rg = 0;
		int telefone = 0;
		String data_nasc = "";
		String genero = "";
		int id_usuario = 0;
		boolean aceite_termos = true;
		
		do {
			System.out.println("--- Beneficiario ---");
			System.out.println("1 - Cadastrar Beneficiario");
			System.out.println("2 - Consultar Beneficiario");
			System.out.println("3 - Atualizar Beneficiario");
			System.out.println("4 - Deletar Beneficiario");
			System.out.println("5 - Buscar pro Id");
			System.out.println("0 - Sair");
			
			opcao = input.nextInt();
			input.nextLine();
			
			switch (opcao) {
			
			case 1: 
				System.out.println("--- Cadastrar Beneficiario ---");
				System.out.println("Digite o nome do Beneficiario: ");
				nome = input.next();
				System.out.println("Digite o CPF do Beneficiario: ");
				cpf = input.nextInt();
				System.out.println("Digite o RG do Beneficiario: ");
				rg = input.nextInt();
				System.out.println("Digite o Telefone do Beneficiario: ");
				telefone = input.nextInt();
				System.out.println("Digite a Data de nascimento do Beneficiario: ");
				data_nasc = input.next();
				System.out.println("Digite o Genero do Beneficiario: ");
				genero = input.next();
				System.out.println("Digite o ID do Usuario: ");
				id_usuario = input.nextInt();
				input.nextLine();
				
				Usuarios usuario = usuariosDAO.getUsuariosById(id_usuario);
				Beneficiario beneficiarios = new Beneficiario(id, nome, cpf, rg, data_nasc, telefone, genero, aceite_termos, usuario);
				beneficiariosDAO.save(beneficiarios);
				
				System.out.println("--- Beneficiario Cadastrado ---\n");
				break;
				
			case 2:
				System.out.println("--- Consultar Beneficiario ---");
				
				for (Beneficiario a : beneficiariosDAO.getBeneficiario()) {
					System.out.println("id: " + a.getId_beneficiario() + "\n" + "Beneficiario: " + a.getNome_beneficiario() + "\n" 
							+ "CPF: " + a.getCpf_beneficiario() + "\n" + "RG: " +a.getRg_beneficiario() + "\n" 
							+ "Telefone: " + a.getTelefone_beneficiaro() + "\n" + "Data Nascimento: " + a.getData_nascimento_beneficiario() + "\n" 
							+ "genero: " + a.getGenero_beneficiario() + "\n" + "Usuario: " + a.getUsuarios().getNome_usuario() + "\n"
							+ "email: " + a.getUsuarios().getEmail() + "\n" + "senha: " + a.getUsuarios().getSenha());
				}
				
				System.out.println("--- Consulta Realizada ---\n");
				break;
				
			case 3:
				System.out.println("--- Atualizar Beneficiario ---");
				System.out.println("Informe o id do Beneficiario: ");
				id = input.nextInt();
				System.out.println("Digite o nome Beneficiario: ");
				nome = input.next();
				System.out.println("Digite o CPF do Beneficiario: ");
				cpf = input.nextInt();
				System.out.println("Digite o Rg do Beneficiario: ");
				rg = input.nextInt();
				System.out.println("Digite a Data de nascimento: ");
				data_nasc = input.next();
				System.out.println("Digite o telefone do Beneficiario: ");
				telefone = input.nextInt();
				System.out.println("Digite o Genero do Beneficiario: ");
				genero = input.next();
				System.out.println("DIgite o id do Usuario: ");
				id_usuario = input.nextInt();
				input.nextLine();
				
				Usuarios usuario1 = usuariosDAO.getUsuariosById(id_usuario);
				Beneficiario beneficiario1 = new Beneficiario(posicao, nome, cpf, rg, data_nasc, telefone, genero, aceite_termos, usuario1);
				beneficiariosDAO.update(beneficiario1);
				
				System.out.println("--- Beneficiario Atualizado ---\n");
				break;
				
			case 4:
				System.out.println("--- Deletar o Beneficiario ---");
				System.out.println("informe o id para Deletar o Beneficiario: ");
				posicao = input.nextInt();
				
				beneficiariosDAO.deleteById(posicao);
				System.out.println("--- Beneficiario Excluido ---\n");
				break;
				
			case 5:
				System.out.println("--- Busque por Id ---");
				System.out.println("Digite o id do Beneficiario: ");
				posicao = input.nextInt();
				
				Beneficiario beneficiario3 = beneficiariosDAO.getBeneficiarioById(id_usuario);
				
				System.out.println("Id: " + beneficiario3.getId_beneficiario() + "\n" + "Nome: " + beneficiario3.getNome_beneficiario() + "\n"
						+ "CPF: " + beneficiario3.getCpf_beneficiario() + "RG: " + beneficiario3.getRg_beneficiario() + "Data Nacimento: " + beneficiario3.getData_nascimento_beneficiario() + "\n"
						+ "Telefone: " + beneficiario3.getTelefone_beneficiaro() + "\n" + "Genero: " + beneficiario3.getGenero_beneficiario() + "\n"
						+ "Usuario: " + beneficiario3.getNome_usuario() + "\n" + "Email: " + beneficiario3.getEmail() + "\n"
						+ "Senha: " + beneficiario3.getSenha());
				break;
				
			default: 
				System.out.println(opcao != 0 ? "Escolha uma opção válida" : "");
				break;
			}
		} while (opcao != 0);
		input.close();
		System.out.println("Operação Finalizada pelo Beneficiario");
	}

}
