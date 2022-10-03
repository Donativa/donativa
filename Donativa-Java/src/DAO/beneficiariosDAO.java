package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Beneficiario;
import model.Usuarios;

public class beneficiariosDAO {

	public void save(Beneficiario beneficiario) {
		
		String sql = "INSERT INTO beneficiarios(id_beneficiario, nome_beneficiario, rg_beneficiario, cpf_beneficiario, data_nascimento_beneficiario, telefone_beneficiario, genero_beneficiario, aceite_termos_beneficiario, id_usuario)" 
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, beneficiario.getId_beneficiario());
			pstm.setString(2, beneficiario.getNome_beneficiario());
			pstm.setInt(3, beneficiario.getCpf_beneficiario());
			pstm.setInt(4, beneficiario.getRg_beneficiario());
			pstm.setInt(5, beneficiario.getTelefone_beneficiaro());
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(6, new Date(formatter.parse(beneficiario.getData_nascimento_beneficiario()).getTime()));
			
			pstm.setString(7, beneficiario.getGenero_beneficiario());
			pstm.setBoolean(8, beneficiario.isAceite_termos_beneficiario());
			
			pstm.setInt(9, beneficiario.getUsuarios().getId_usuario());
			
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
		
		String sql = "DELETE FROM beneficiario WHERE id_beneficiario = ?";
		
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
	
	public void update(Beneficiario beneficiario) {
		
		String sql = "UPDATE beneficiario SET nome_beneficiario = ?, cpf_beneficiario = ?, rg_beneficiario = ?,"
				+ " data_nascimento_beneficiario = ?, telefone_beneficiario = ?, genero_beneficiario = ?, aceite_termos_beneficiario = ?"
				+ "WHERE id_beneficiario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, beneficiario.getNome_beneficiario());
			pstm.setInt(2, beneficiario.getCpf_beneficiario());
			pstm.setInt(3, beneficiario.getRg_beneficiario());
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(4, new Date(formatter.parse(beneficiario.getData_nascimento_beneficiario()).getTime()));
			
			pstm.setInt(5, beneficiario.getTelefone_beneficiaro());
			pstm.setString(6, beneficiario.getGenero_beneficiario());
			pstm.setBoolean(7, beneficiario.isAceite_termos_beneficiario());
			
			pstm.setInt(8, beneficiario.getId_beneficiario());
			
			pstm.setInt(9, beneficiario.getUsuarios().getId_usuario());
			
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
	
	public List<Beneficiario> getBeneficiario() {
		
		String sql = "SELECT * \n"
				+ "FROM beneficiario AS l\n"
				+ "JOIN usuarios AS e ON l.id_usuario = e.id_usuario \n";
		
		List<Beneficiario> beneficiario = new ArrayList<Beneficiario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Usuarios usuario = new Usuarios();
				Beneficiario beneficiario1 = new Beneficiario();
				
				beneficiario1.setId_beneficiario(rset.getInt("id_beneficiario"));
				beneficiario1.setNome_beneficiario(rset.getString("nome_beneficiario"));
				beneficiario1.setCpf_beneficiario(rset.getInt("cpf_beneficiario"));
				beneficiario1.setRg_beneficiario(rset.getInt("rg_beneficiario"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
				beneficiario1.setData_nascimento_beneficiario(dateFormat.format(rset.getDate("data_nascimento_beneficiario")));
				
				beneficiario1.setGenero_beneficiario(rset.getString("genero_beneficiario"));
				beneficiario1.setTelefone_beneficiaro(rset.getInt("telefone_beneficiario"));
				beneficiario1.setAceite_termos_beneficiario(rset.getBoolean("aceite_termos_beneficiario"));
				
				usuario.setId_usuario(rset.getInt("id_ususario"));
				usuario.setNome_usuario(rset.getString("nome_usuario"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				beneficiario1.setUsuarios(usuario);
				
				beneficiario.add(beneficiario1);
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
		
		return beneficiario;
	}
	
	public Beneficiario getBeneficiarioById(int id) {
		
		String sql = "SELECT \n"
				+ "FROM beneficiarios AS l\n"
				+ "JOIN usuarios AS e ON l.id_usuario = e.id_usuario\n"
				+ "WHERE id_beneficiario = ?";
		
		Usuarios usuario1 = new Usuarios();
		Beneficiario beneficiario2 = new Beneficiario();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			rset.next();
			
			beneficiario2.setId_beneficiario(rset.getInt("id_beneficiario"));
			beneficiario2.setNome_beneficiario(rset.getString("nome_beneficiario"));
			beneficiario2.setCpf_beneficiario(rset.getInt("cpf_beneficiario"));
			beneficiario2.setRg_beneficiario(rset.getInt("rg_beneficiario"));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			beneficiario2.setData_nascimento_beneficiario(dateFormat.format(rset.getDate("data_nascmineto_beneficiario")));
			
			beneficiario2.setGenero_beneficiario("genero_beneficiario");
			
			usuario1.setId_usuario(rset.getInt("id_usuario"));
			usuario1.setEmail(rset.getString("email"));
			usuario1.setNome_usuario(rset.getString("nome_usuario"));
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
		
			return beneficiario2;
	}
}
