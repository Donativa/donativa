package CRUD;

import java.util.Scanner;

import DAO.administradorDAO;
import DAO.usuariosDAO;
import model.Administrador;
import model.Usuarios;

public class AdministradorCRUD {
	
	public static void main(String[] args) {
		
		administradorDAO administradorDAO = new administradorDAO();
		usuariosDAO usuariosDAO = new usuariosDAO();
		
		Scanner input = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
		
		int id_adm = 0;
		String nome_adm = "";
		int id_usuario = 0;
		
		do {
			System.out.println("--- Administrador ---");
			System.out.println("1 - Cadastrar Administrador");
			System.out.println("2 - Consultar Administrador");
			System.out.println("3 - Atualizar Administrador");
			System.out.println("4 - Deletar Administrador");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = input.nextInt();
			input.nextLine();
			
			switch (opcao) {
			
			case 1: 
				System.out.println("--- Cadastrar Administrador ---");
				System.out.println("Digite o nome do Administrador: ");
				nome_adm = input.nextLine();
				System.out.println("Digite o Id do Usuário: ");
				id_usuario = input.nextInt();
				input.nextLine();
				
				Usuarios usuario = usuariosDAO.getUsuariosById(id_usuario);
				Administrador admin = new Administrador(id_adm, nome_adm, usuario);
				administradorDAO.save(admin);
				
				System.out.println("--- Administrador Cadastrado ---\n");
				break;
				
			case 2:
				System.out.println("--- Consultar Administrador ---");
				
				for (Administrador a : administradorDAO.getAdmin()) {
					System.out.println("id: " + a.getId_adm() + "\n"
							+ "Administrador: " + a.getNome_adm() + "\n"
							+ "Usuario: " + a.getUsuarios().getNome_usuario());
				}
				
				System.out.println("--- Consulta Realizada ---\n");
				break;
				
			case 3:
				System.out.println("--- Atualizar ---");
				System.out.println("Digite o id do Administrador: ");
				posicao = input.nextInt();
				System.out.println("Digite o nome do Administrador: ");
				nome_adm = input.next();
				System.out.println("Digite o id do Usuario: ");
				id_usuario = input.nextInt();
				input.nextLine();
				
				Usuarios usuario1 = usuariosDAO.getUsuariosById(id_usuario);
				Administrador admin1 = new Administrador(posicao, nome_adm, usuario1);
				administradorDAO.update(admin1);
				
				System.out.println("--- Administrador Atualizado --- \n");
				break;
				
			case 4:
				System.out.println("--- Deletar Administrador ---");
				System.out.println("Informe o Id para Deletar o Administrador: ");
				posicao = input.nextInt();
				
				administradorDAO.deleteById(posicao);
				System.out.println("--- Administrador excluido ---\n");
				break;
				
			case 5: 
				System.out.println("Digite o id do Administrador: ");
				posicao = input.nextInt();
				Administrador admin2 = administradorDAO.getAdministradorById(posicao);
				
				System.out.println("Id: " + admin2.getId_adm() + "\n" + "Nome: " + admin2.getNome_adm() + "\n"
									+ "Usuario: " + admin2.getUsuarios().getNome_usuario()  + "\n"
									+ "Email: " + admin2.getUsuarios().getEmail());
				break;
				
			default:
					System.out.println(opcao != 0 ? "Escolha uma opção válida" : "");
					break;
			}
		} while (opcao != 0);
		input.close();
		System.out.println("Operação Finalizada pelo Administrador");
	}
}