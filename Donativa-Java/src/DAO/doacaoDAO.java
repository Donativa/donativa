package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Doacao;
import model.Doador;

public class doacaoDAO {
	
	public  void save(Doacao doacao) {
		
		String sql = "INSERT INTO doacao(id_doacao, data_doacao, id_doador, num_pedido, id_doador" + "VALUES(?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, doacao.getId_doacao());
			pstm.setInt(2, doacao.getNum_pedido());
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(3, new Date(formatter.parse(doacao.getData_doacao()).getTime()));
			
			pstm.setInt(4, doacao.getDoador().getId_doador());
			
			
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
		
		String sql = "DELETE FROM doacao WHERE id_doacao = ?";
		
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
	
	public void update(Doacao doacao) {
	
		String sql = "UPDATE doador SET data_doacao, nome_doador, num_pedido" + "WHERE id_doacao = ?";
	
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
		
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
			pstm.setDate(1, new Date(formatter.parse(doacao.getData_doacao()).getTime()));
			
			pstm.setInt(2, doacao.getNum_pedido());
			
			pstm.setInt(3, doacao.getDoador().getId_doador());
			pstm.setString(4, doacao.getDoador().getNome_doador());
			pstm.setString(5, doacao.getDoador().getEmail());
			pstm.setString(6, doacao.getDoador().getSenha());
			
			pstm.setInt(4, doacao.getId_doacao());
			
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
	
	public List<Doacao> getDoacao() {
		
		String sql = "SELECT * \n"
				+ "FROM doacao AS l\n"
				+ "JOIN doador AS e ON l.id_doador = a.id_doador";
				
		List<Doacao> doacao = new ArrayList<Doacao>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Doacao doacao1 = new Doacao();
				Doador doador = new Doador();
				
				doacao1.setId_doacao(rset.getInt("id_doacao"));
				doacao1.setNum_pedido(rset.getInt("num_pedido"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
				doacao1.setData_doacao(dateFormat.format(rset.getDate("data_doacao")));
				
				doador.setId_doador(rset.getInt("id_doador"));
				doador.setNome_doador(rset.getString("nome_doador"));
				
				doacao.add(doacao1);
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
		
		return doacao;
	}
	
	public Doacao getDoacaoById(int id) {
		
		String sql = "SELECT * \n"
				+ "FROM doacao AS l\n"
				+ "JOIN doador AS e ON l.id_doador = e.id_doador"
				+ "WHERE id_doacao = ?";
		
		Doacao doacao = new Doacao();
		Doador doador = new Doador();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			rset.next();
			
			doacao.setId_doacao(rset.getInt("id_doacao"));
			doacao.setNum_pedido(rset.getInt("num_pedido"));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
			doacao.setData_doacao(dateFormat.format(rset.getDate("data_doacao")));
			
			doador.setId_doador(rset.getInt("id_doador"));
			doador.setNome_doador(rset.getString("nome_doador"));
			doacao.setDoador(doador);

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
		
		return doacao;
	} 
}

