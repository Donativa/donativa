package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connector.ConnectionMySQL;
import model.Beneficiario;
import model.Doador;
import model.Endereco;

public class enderecoDAO {

	public void save(Endereco endereco) {

		String sql = "INSERT INTO endereco (id_endereco, rua, numero, cep, bairro, cidade, estado, id_beneficiario, id_doador)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, endereco.getId_endereco());
			pstm.setString(2, endereco.getRua());
			pstm.setInt(3, endereco.getNumero());
			pstm.setString(4, endereco.getCep());
			pstm.setString(5, endereco.getBairro());
			pstm.setString(6, endereco.getCidade());
			pstm.setString(7, endereco.getEstado());
			pstm.setInt(8, endereco.getBeneficiario().getId_beneficiario());
			pstm.setInt(9, endereco.getDoador().getId_doador());

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

		String sql = "DELETE FROM endereco WHERE id_endereco = ?";

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

	public void update(Endereco endereco) {

		String sql = "UPDATE endereco SET rua, numero, cep, bairro, cidade, estado, id_beneficiario, id_doador" + "WHERE id_endereco = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, endereco.getRua());
			pstm.setInt(2, endereco.getNumero());
			pstm.setString(3, endereco.getCep());
			pstm.setString(4, endereco.getBairro());
			pstm.setString(5, endereco.getCidade());
			pstm.setString(6, endereco.getEstado());
			
			pstm.setInt(7, endereco.getId_endereco());
			pstm.setInt(8, endereco.getBeneficiario().getId_beneficiario());
			pstm.setInt(9, endereco.getDoador().getId_doador());
			
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

	public List<Endereco> getEndereco() {
		
		String sql = "SELECT * \n"
				+ "FROM endereco AS l\n"
				+ "JOIN beneficiario AS e ON l.id_beneficiario = e.id_beneficiario\n"
				+ "JOIN doador AS e ON l.id_doador = a.id_doador";
		
		List<Endereco> endereco = new ArrayList<Endereco>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Beneficiario beneficiario = new Beneficiario();
				Doador doador = new Doador();
				Endereco endereco1 = new Endereco();
				
				endereco1.setId_endereco(rset.getInt("id_doador"));
				endereco1.setRua(rset.getString("rua"));
				endereco1.setNumero(rset.getInt("numero"));
				endereco1.setCep(rset.getString("cep"));
				endereco1.setBairro(rset.getString("bairro"));
				endereco1.setCidade(rset.getString("cidade"));
				endereco1.setEstado(rset.getString("estado"));
				
				beneficiario.setId_beneficiario(rset.getInt("id_beneficiario"));
				beneficiario.setNome_beneficiario(rset.getString("nome_beneficiario"));
				endereco1.setBeneficiario(beneficiario);
				doador.setId_doador(rset.getInt("id_doador"));
				doador.setNome_doador(rset.getString("nome_doador"));
				endereco1.setDoador(doador);
				endereco.add(endereco1);
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
		return endereco;
	}
	
	public Endereco getEnderecoById(int id) {
		
		String sql = "SELECT * \n"
				+ "FROM endereco AS l\n"
				+ "JOIN beneficiario AS e ON l.id_beneficiario = e.id_beneficiario \n"
				+ "JOIN doador AS e ON l.id_beneficiario = a.id_doador \n"
				+ "WHERE id_endereco = ?";
		
		Beneficiario beneficiario = new Beneficiario();
		Doador doador = new Doador();
		Endereco endereco = new Endereco();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			rset.next();
			
			endereco.setId_endereco(rset.getInt("id_endereco"));
			endereco.setRua(rset.getString("rua"));
			endereco.setNumero(rset.getInt("numero"));
			endereco.setCep(rset.getString("cep"));
			endereco.setBairro(rset.getString("bairro"));
			endereco.setCidade(rset.getString("cidade"));
			endereco.setEstado(rset.getString("estado"));
			
			beneficiario.setId_beneficiario(rset.getInt("id_beneficiario"));
			beneficiario.setNome_beneficiario(rset.getString("nome_beneficiario"));
			endereco.setBeneficiario(beneficiario);
			doador.setId_doador(rset.getInt("id_doador"));
			doador.setNome_doador(rset.getString("nome_doador"));
			endereco.setDoador(doador);
			
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
		
		return endereco;
	}
}
	