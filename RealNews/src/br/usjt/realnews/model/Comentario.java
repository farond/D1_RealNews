package br.usjt.realnews.model;

public class Comentario implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;	
	
	private int idComentario = -1;
	private String nome;
	private String comentario;
	private int idNoticia = -1;
	
	public Comentario() {}
	
	public Comentario(int idComentario, String nome, String texto, int idNoticia) {
		super();
		this.idComentario = idComentario;
		this.nome = nome;
		this.comentario = texto;
		this.idNoticia = idNoticia;	
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	
	
	
	

}
