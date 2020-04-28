package br.usjt.realnews.model;

public class Noticia implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id = -1;
	private String descricao;
	private String titulo;
	private String texto;
	
	
	public Noticia() {}
	
	public Noticia(int id, String descricao, String titulo, String texto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public boolean isValid() {
		return this.id != -1 && this.titulo != null && this.descricao != null && this.texto != null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	

}
