package br.usjt.realnews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.realnews.connection.ConnectionFactory;
import br.usjt.realnews.model.Comentario;

public class ComentarioDAO {

	private Connection conexao;

	public ComentarioDAO() {
		new ConnectionFactory();
		this.conexao = ConnectionFactory.conectar();
	}
	

	public void insereComentario(Comentario comentario) {

		String insert = "INSERT INTO comentario (nome,texto, fk_noticia_id) " + "VALUES (?,?,?)";

		try (PreparedStatement preparedStatement = conexao.prepareStatement(insert);) {

			preparedStatement.setString(1, comentario.getNome());
			preparedStatement.setString(2, comentario.getComentario());
			preparedStatement.setInt(3, comentario.getIdNoticia());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (SQLException ex) {
				System.out.println(ex.getStackTrace());
			}
		}
	}
	
	public void excluir(Comentario comentario) {

		String sql = "DELETE FROM comentario " + "WHERE id = ?;";

		try (PreparedStatement pst = conexao.prepareStatement(sql)) {

			pst.setInt(1, comentario.getIdComentario());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Comentario.");
			ex.printStackTrace();

		}
	}

	
	public ArrayList<Comentario> listaComentarios(int idNoticia) {

		String sqlSelect = "SELECT * FROM comentario WHERE fk_noticia_id = ?";

		ArrayList<Comentario> listaComentario = new ArrayList<>();

		try (PreparedStatement preparedStatement = conexao.prepareStatement(sqlSelect);) {
			
			preparedStatement.setInt(1, idNoticia);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Comentario comentario = new Comentario();
				comentario.setNome(resultSet.getString("nome"));
				comentario.setComentario(resultSet.getString("texto"));
				listaComentario.add(comentario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaComentario;
	}
}