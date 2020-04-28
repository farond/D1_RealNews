package br.usjt.realnews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.realnews.connection.ConnectionFactory;
import br.usjt.realnews.model.Noticia;


public class NoticiaDAO {
private Connection conexao;
	
	public NoticiaDAO() {
		new ConnectionFactory();
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Noticia noticia) {
			
		String inserir = "INSERT INTO noticia "
				+ " (descricao, titulo, texto) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			//pst.setInt(1, noticia.getId());
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());			
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular a tabela Noticia.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(int idNoticia, Noticia noticia) {
		
		String alterar = "UPDATE noticia "
				+ "SET descricao = ?, titulo = ?, texto = ? WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {			
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			pst.setInt(4, idNoticia);
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular a tabela Noticia.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Noticia noticia) {
		
		String excluir = "DELETE FROM noticia "
				+ " WHERE id = ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, noticia.getId());			
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível excluir "
					+ "a noticia.");
			ex.printStackTrace();
		}
	}
	
	public Noticia consultar(int id) {
		
		String consultar = "SELECT * FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Noticia n = new Noticia();
			if (resultado.next()) {
				n.setId(id);
				n.setDescricao(resultado.getString("descricao"));
				n.setTitulo(resultado.getString("titulo"));
				n.setTexto(resultado.getString("texto"));
			}
			return n;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Noticia> listarnoticias() {
		
		String consultar = "SELECT * FROM noticia";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia n = new Noticia();
				n.setId(resultado.getInt("id"));
				n.setDescricao(resultado.getString("descricao"));
				n.setTitulo(resultado.getString("titulo"));
				n.setTexto(resultado.getString("texto"));				
				lista.add(n);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
