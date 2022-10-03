package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Pedido_beneficiario;
import model.Beneficiario;

public class pedido_beneficiarioDAO {
	
	public void save(Pedido_beneficiario pedido_beneficiario) {
		
		String sql = "INSERT INTO pedido_beneficiario(id_pedido, data_pedido, nome_beneficiario, num_pedido, quantidade_itens, id_beneficiario)"
		+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido_beneficiario.getId_pedido());
			pstm.setString(2, pedido_beneficiario.getNome_beneficiario());
			pstm.setInt(3, pedido_beneficiario.getNum_pedido());
			pstm.setInt(4, pedido_beneficiario.getQuantidade_itens());
			
			pstm.setInt(5, pedido_beneficiario.getBeneficiario().getId_beneficiario());
			pstm.setString(6, pedido_beneficiario.getBeneficiario().getNome_beneficiario());
			pstm.setString(7, pedido_beneficiario.getBeneficiario().getEmail());
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(8, new Date(formatter.parse(pedido_beneficiario.getData_pedido()).getTime()));
			
			pstm.setInt(9, pedido_beneficiario.getBeneficiario().getId_beneficiario());
			
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
		
		String sql = "DELETE FROM pedido_beneficiario WHERE id_pedido = ?";
		
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
	
	public void update(Pedido_beneficiario pedido_beneficiario) {
		
		String sql = "UPDATE pedido_beneficiario SET data_pedido, nome_beneficiario, num_pedido, quantidade_itens, id_beneficiario" + "WHERE id_pedido= ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido_beneficiario.getBeneficiario().getId_beneficiario());
			pstm.setString(2, pedido_beneficiario.getBeneficiario().getNome_beneficiario());
			pstm.setString(3, pedido_beneficiario.getBeneficiario().getEmail());
			
			pstm.setInt(4, pedido_beneficiario.getNum_pedido());
			pstm.setInt(5, pedido_beneficiario.getQuantidade_itens());
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(6, new Date(formatter.parse(pedido_beneficiario.getData_pedido()).getTime()));
			
			pstm.setInt(7, pedido_beneficiario.getId_pedido());
			pstm.setInt(8, pedido_beneficiario.getBeneficiario().getId_beneficiario());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(pstm !=  null) {
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
	
	public List<Pedido_beneficiario> getPedido_beneficiario() {
		
		String sql = "SELECT * FROM pedido_beneficiario";
						
		List<Pedido_beneficiario> pedido_beneficiario = new ArrayList<Pedido_beneficiario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Pedido_beneficiario pedido = new Pedido_beneficiario();
				Beneficiario beneficiario1 = new Beneficiario();
				
				pedido.setId_pedido(rset.getInt("id_pedido"));
				pedido.setNum_pedido(rset.getInt("num_pedido"));
				pedido.setQuantidade_itens(rset.getInt("quantidade_itens"));
				
				beneficiario1.setId_beneficiario(rset.getInt("id_beneficiario"));
				beneficiario1.setNome_beneficiario(rset.getString("nome_beneficiario"));
				beneficiario1.setEmail(rset.getString("email"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
				pedido.setData_pedido(dateFormat.format(rset.getDate("data_pedido")));
				
				pedido_beneficiario.add(pedido);
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
		
		return pedido_beneficiario;
	}
	
	public Pedido_beneficiario getPedido_beneficiarioById(int id) {
		
		String sql = "SELECT * \n"
				+ "FROM pedido_beneficiario AS l\n"
				+ "JOIN beneficiario AS e ON l.id_beneficiario = e.id_beneficiario \n";
		
		Pedido_beneficiario pedido = new Pedido_beneficiario();
		Beneficiario beneficiario = new Beneficiario();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			
			pedido.setId_pedido(rset.getInt("id_pedido"));
			pedido.setNum_pedido(rset.getInt("num_pedido"));
			pedido.setQuantidade_itens(rset.getInt("quantidade_itens"));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			pedido.setData_pedido(dateFormat.format(rset.getDate("data_pedido")));
			beneficiario.setId_beneficiario(rset.getInt("id_beneficiario"));
			beneficiario.setNome_beneficiario(rset.getString("nome_beneficiario"));
			pedido.setBeneficiario(beneficiario);
			
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
		
		return pedido;
	}
}
