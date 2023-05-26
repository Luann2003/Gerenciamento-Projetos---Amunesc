package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MostraDados {

	private Connection conn;
	private PreparedStatement pstm;

	public String recuperarValorDoBancoRespoTop1() {
		conn = new ConexaoDAO().conectaBD();
		String valor = null;
		String sql = "SELECT responsável FROM projetos LIMIT 1, 1"; // Consulta SQL para recuperar o valor do campo RE1

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

}
