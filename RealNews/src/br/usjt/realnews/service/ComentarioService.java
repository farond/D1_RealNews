package br.usjt.realnews.service;

import java.util.List;
import br.usjt.realnews.dao.ComentarioDAO;
import br.usjt.realnews.model.Comentario;

public class ComentarioService {
private ComentarioDAO comentarioDao;
	
	public ComentarioService() {
		this.comentarioDao = new ComentarioDAO();
	}

	public List<Comentario> listar(int idNoticia){
		return comentarioDao.listaComentarios(idNoticia);	
	}

		public void inserir(Comentario comentario) {
		comentarioDao.insereComentario(comentario);
	}


}
