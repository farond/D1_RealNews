package br.usjt.realnews.service;

import java.util.List;

import br.usjt.realnews.dao.NoticiaDAO;
import br.usjt.realnews.model.Noticia;



public class NoticiaService {
	
	private NoticiaDAO noticiaDao = new NoticiaDAO();
	
	public void cadastrarNoticia(Noticia noticia) {
		noticiaDao.cadastrar(noticia);
	}
	
	public Noticia consultarNoticia(int id) {
		
		return noticiaDao.consultar(id);	
	}
	
	public void atualizarNoticia(int idNoticia, Noticia noticia) {
		noticiaDao.alterar(idNoticia, noticia);
	}

	
	public void deletarNoticia(Noticia noticia) {
		noticiaDao.excluir(noticia);
	}
	
	
	public List<Noticia> listarNoticias() {
		
		return noticiaDao.listarnoticias();	
	}

	


}
