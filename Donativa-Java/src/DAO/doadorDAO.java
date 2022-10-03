package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Doador;
import model.Usuarios;

public class doadorDAO {
	
	public void save(Doador doador) {
		
		String sql = "INSERT INTO doador(id_doador, nome_doador, cpf_doador, cnpj_doador, rg_doador, data_nascimento_doador, genero_doador, telefone_doador, aceite_termos_doador, id_usuario)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, doador.getId_doador());
			pstm.setString(2, doador.getNome_doador());
			pstm.setInt(3, doador.getCpf_doador());
			pstm.setInt(4, doador.getCnpj_doador());
			pstm.setInt(5, doador.getRg_doador());
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(6, new Date(formatter.parse(doador.getData_nascimento_doador()).getTime()));
			
			pstm.setInt(7, doador.getTelefone_doador());
			pstm.setString(8, doador.getGenero_doador());
			
			pstm.setInt(9, doador.getUsuarios().getId_usuario());
			
			pstm.execute();
		 
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteById(int id) {
		
		String sql = "DELETE FROM doador WHERE id_doador = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try { 
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Doador doador) {
		
		String sql = "UPDADE doador SET nome_doador = ?, cpf_doador = ?, cnpj_doador = ?, rg_doador = ?, data_nascimento_doador = ?,  telefone_doador = ?, genero_doador = ?, aceite-termos_doador = ?, id_usuario = ? WHERE id_doador = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, doador.getNome_doador());
			pstm.setInt(2, doador.getCnpj_doador());
			pstm.setInt(3, doador.getCpf_doador());
			pstm.setInt(4, doador.getTelefone_doador());
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(5, new Date(formatter.parse(doador.getData_nascimento_doador()).getTime()));
			pstm.setString(6, doador.getGenero_doador());
			pstm.setBoolean(7, doador.isAceite_termos_doador());
			
			pstm.setInt(8, doador.getUsuarios().getId_usuario());
			
			pstm.setInt(9, doador.getId_doador());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Doador> getDoador() {
		
		String sql = "SELECT * FROM doador"
				+ "FROM doador AS l\n"
				+"JOIN usuarios AS e ON l.id_usuario = e.id_usuario\n";
		
		List<Doador> doador = new ArrayList<Doador>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Usuarios usuario = new Usuarios();
				Doador doador1 = new Doador();
				
				doador1.setId_doador(rset.getInt("id_doador"));
				doador1.setNome_doador(rset.getString("nome_doador"));
				doador1.setCpf_doador(rset.getInt("cpf_doador"));
				doador1.setCnpj_doador(rset.getInt("cnpj_doador"));
				doador1.setRg_doador(rset.getInt("rg_doador"));
				doador1.setTelefone_doador(rset.getInt("telefone_doador"));
				doador1.setGenero_doador(rset.getString("genero_doador"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
				doador1.setData_nascimento_doador(dateFormat.format(rset.getDate("data_nascimento_doador")));
					
				doador1.setAceite_termos_doador(rset.getBoolean("aceite_termos_doador"));
				usuario.setId_usuario(rset.getInt("id_usuario"));
				usuario.setNome_usuario(rset.getString("nome_usuario"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				doador1.setUsuarios(usuario);

				doador.add(doador1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return doador;
	}
	
	public Doador getDoadorById(int id) {
		
		String sql = "SELECT * \n"
				+ "FROM doador AS l\n"
				+ "JOIN usuarios AS e ON l.id_usuario = e.id_usuario \n"
				+ "WHERE id_doador = ?";
		
		Doador doador2 = new Doador();
		Usuarios usuario1 = new Usuarios();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			rset.next();
			
			doador2.setId_doador(rset.getInt("id_doador"));
			doador2.setNome_doador(rset.getString("nome_doador"));
			doador2.setCnpj_doador(rset.getInt("cpf_doador"));
			doador2.setCpf_doador(rset.getInt("cpf_doador"));
			doador2.setRg_doador(rset.getInt("rg_doador"));
			doador2.setTelefone_doador(rset.getInt("telefone_doador"));
			doador2.setGenero_doador(rset.getString("genero_doador"));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			doador2.setData_nascimento_doador(dateFormat.format(rset.getDate("data_nascimento_doador")));
			
			usuario1.setId_usuario(rset.getInt("id_usuario"));
			usuario1.setNome_usuario(rset.getString("nome_usuario"));
			usuario1.setEmail(rset.getString("email"));
			usuario1.setSenha(rset.getString("senha"));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return doador2;
	}
}
