package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.TabelaDTO;

public class AtualizarDAO {

	private Connection conn;
	private PreparedStatement pstm;

	public void atualizarTop(TabelaDTO tabeladto) {

		String sql = "UPDATE projetos\r\n"
				+ "SET responsável = CASE \r\n"
				+ "                    WHEN id = 2 THEN ? \r\n"
				+ "                    ELSE responsável \r\n"
				+ "                 END,\r\n"
				+ "    status = CASE \r\n"
				+ "                WHEN id = 2 THEN ? \r\n"
				+ "                ELSE status \r\n"
				+ "             END,\r\n"
				+ "    prazo = CASE \r\n"
				+ "                WHEN id = 2 THEN ? \r\n"
				+ "                ELSE prazo \r\n"
				+ "            END,\r\n"
				+ "    entrega = CASE \r\n"
				+ "                WHEN id = 2 THEN ? \r\n"
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
