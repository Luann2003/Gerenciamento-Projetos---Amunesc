package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DTO.TabelaDTO;

public class ProjetosDAO extends MostraDados {

	private Connection conn;
	private PreparedStatement pstm;

	public void tabela(TabelaDTO tabeladto) {

		String sql = "INSERT INTO projetos (responsável, status, prazo, entrega) VALUES (?, ?, ?, ?)";

		try {
			conn = new ConexaoDAO().conectaBD();
			if (conn != null) {
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, tabeladto.getResponsavel());
				pstm.setString(2, tabeladto.getStatus());
				pstm.setString(3, tabeladto.getPrazoEstimado());
				pstm.setString(4, tabeladto.getEntrega());

				pstm.execute();
				pstm.close();
				conn.close();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados no banco de dados: " + e);
		}
	}

	public String recuperarValorDoBancoDeDadosRe1() {
		conn = new ConexaoDAO().conectaBD();
		String valor = null;
		String sql = "SELECT responsável FROM projetos"; // Consulta SQL para recuperar o valor do campo RE1

		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				valor = rs.getString("responsável");
			}

			rs.close();
			pstm.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar valor do banco de dados: " + e);
		}

		return valor;
	}

	public String recuperarValorDoBancoStatus() {
		conn = new ConexaoDAO().conectaBD();
		String valor = null;
		String sql = "SELECT status FROM projetos"; // Consulta SQL para recuperar o valor do campo RE1

		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				valor = rs.getString("status");
			}

			rs.close();
			pstm.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar valor do banco de dados: " + e);
		}

		return valor;
	}

	public String recuperarValorDoBancoPrazo() {
		conn = new ConexaoDAO().conectaBD();
		String valor = null;
		String sql = "SELECT prazo FROM projetos"; // Consulta SQL para recuperar o valor do campo RE1

		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				valor = rs.getString("prazo");
			}

			rs.close();
			pstm.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar valor do banco de dados: " + e);
		}

		return valor;
	}

	public String recuperarValorDoBancoEntrega() {
		conn = new ConexaoDAO().conectaBD();
		String valor = null;
		String sql = "SELECT entrega FROM projetos"; // Consulta SQL para recuperar o valor do campo RE1

		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				valor = rs.getString("entrega");
			}

			rs.close();
			pstm.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar valor do banco de dados: " + e);
		}

		return valor;
	}

	public void atualizar(TabelaDTO tabeladto) {

		String sql = "UPDATE projetos\r\n"
				+ "SET responsável = CASE \r\n"
				+ "                    WHEN id = 1 THEN ? \r\n"
				+ "                    ELSE responsável \r\n"
				+ "                 END,\r\n"
				+ "    status = CASE \r\n"
				+ "                WHEN id = 1 THEN ? \r\n"
				+ "                ELSE status \r\n"
				+ "             END,\r\n"
				+ "    prazo = CASE \r\n"
				+ "                WHEN id = 1 THEN ? \r\n"
				+ "                ELSE prazo \r\n"
				+ "            END,\r\n"
				+ "    entrega = CASE \r\n"
				+ "                WHEN id = 1 THEN ? \r\n"
				+ "                ELSE entrega \r\n"
				+ "              END\r\n"
				+ "WHERE id = 1;\r\n"
				+ "";

		try {
			conn = new ConexaoDAO().conectaBD();
			if (conn != null) {
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, tabeladto.getResponsavel());
				pstm.setString(2, tabeladto.getStatus());
				pstm.setString(3, tabeladto.getPrazoEstimado());
				pstm.setString(4, tabeladto.getEntrega());

				pstm.execute();
				pstm.close();
				conn.close();
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados no banco de dados: " + e);
		}

	}

}
