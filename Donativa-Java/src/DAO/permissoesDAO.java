package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Permissoes;

public class permissoesDAO {
	
	public void save(Permissoes permissoes) {
		
		String sql = "INSERT INTO permissoes(id_permissao, tipoPermissao)" + "VALUES(?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, permissoes.getId_permissao());
			pstm.setString(2, permissoes.getTipoPermissao());
			
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
		
		String sql = "DELETE FROM permissoes WHERE id = ?";
		
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
	
	public void update(Permissoes permissoes) {
		
		String sql = "UPDATE permissoes SET tipoPermissao" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, permissoes.getTipoPermissao());

			pstm.setInt(2, permissoes.getId_permissao());
			
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
	
	public List<Permissoes> getPermissoes() {
		
		String sql = "SELECT * FROM permissoes";
		
		List<Permissoes> permissoes = new ArrayList<Permissoes>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Permissoes permissao = new Permissoes();
				
				permissao.setId_permissao(rset.getInt("id_permissao"));
				permissao.setTipoPermissao(rset.getString("tipoPermissao"));
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
		
		return permissoes;
	}
}
