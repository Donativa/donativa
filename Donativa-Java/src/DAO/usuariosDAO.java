package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Usuarios;

public class usuariosDAO {

	public void save(Usuarios usuarios) {

		String sql = "INSERT INTO usuarios(id_usuario, nome_usuario, email, senha)" + "VALUES(?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, usuarios.getId_usuario());
			pstm.setString(2, usuarios.getNome_usuario());
			pstm.setString(3, usuarios.getEmail());
			pstm.setString(4, usuarios.getSenha());
			

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

	public void deleteById(int id_usuario) {

		String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_usuario);

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

	public void update(Usuarios usuarios) {

		String sql = "UPDATE usuarios SET nome_usuario = ?, email = ?, senha = ? " + "WHERE id_usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuarios.getNome_usuario());
			pstm.setString(2, usuarios.getEmail());
			pstm.setString(3, usuarios.getSenha());

			pstm.setInt(4, usuarios.getId_usuario());

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

	public List<Usuarios> getUsuarios() {
		
		String sql = "SELECT * FROM usuarios";
		
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Usuarios usuario = new Usuarios();
				
				usuario.setId_usuario(rset.getInt("id_usuario"));
				usuario.setNome_usuario(rset.getString("nome_usuario"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				
				usuarios.add(usuario);
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
		return usuarios;
	}
	
	public Usuarios getUsuariosById(int id) {
		
		String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
		
		Usuarios usuario = new Usuarios();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			rset.next();
			
			usuario.setId_usuario(rset.getInt("id_usuario"));
			usuario.setNome_usuario(rset.getString("nome_usuario"));
			usuario.setEmail(rset.getString("email"));
			usuario.setSenha(rset.getString("senha"));
			
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
		
		return usuario;
	}
}