package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Administrador;
import model.Usuarios;

public class administradorDAO {

	public void save(Administrador admin) {

		String sql = "INSERT INTO administrador(id_adm, nome_adm, id_usuario)" + "VALUES(?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, admin.getId_adm());
			pstm.setString(2, admin.getNome_adm());

			pstm.setInt(3, admin.getUsuarios().getId_usuario());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteById(int id) {

		String sql = "DELETE FROM administrador WHERE id_adm = ?";

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
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Administrador admin) {

		String sql = "UPDATE administrador SET nome_adm = ?" + "WHERE id_adm = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, admin.getNome_adm());
			pstm.setInt(2, admin.getId_adm());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Administrador> getAdmin() {
		
		String sql = "SELECT * \n"
				+ "FROM administrador AS l\n"
				+"JOIN usuarios AS e ON l.id_usuario = e.id_usuario \n";

		List<Administrador> admin = new ArrayList<Administrador>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Administrador admin1 = new Administrador();
				Usuarios usuario = new Usuarios();
				
				admin1.setId_adm(rset.getInt("id_adm"));
				admin1.setNome_adm(rset.getString("nome_adm"));
				
				usuario.setId_usuario(rset.getInt("id_usuario"));
				usuario.setNome_usuario(rset.getString("nome_usuario"));
				usuario.setEmail(rset.getString("email"));
				admin1.setUsuarios(usuario);
						
				admin.add(admin1);
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
		
		return admin;
	}

	public Administrador getAdministradorById(int id) {
			String sql = "SELECT * \n"
					+ "FROM administrador AS l\n"
					+ "JOIN usuarios AS e ON l.id_usuario = e.id_usuario \n"
					+ "WHERE id_adm = ?";
			
			Administrador admin = new Administrador();
			Usuarios usuario = new Usuarios();
			
			Connection conn =null;
			PreparedStatement pstm = null;
			ResultSet rset = null; 
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				pstm = conn.prepareStatement(sql);
			
				pstm.setInt(1, id);
				rset = pstm.executeQuery();
				rset.next();
				
				admin.setId_adm(rset.getInt("id_adm"));
				admin.setNome_adm(rset.getString("nome_adm"));
				
				usuario.setId_usuario(rset.getInt("id_usuario"));
				usuario.setNome_usuario(rset.getString("nome_usuario"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				admin.setUsuarios(usuario);
								
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				
				try {
					
					if(rset != null) {
						rset.close();
					}
					
					if (pstm != null) {
						pstm.close();
					}
					
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		return admin;  
	}
}
