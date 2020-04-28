package br.usjt.realnews.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.realnews.model.Comentario;
import br.usjt.realnews.service.ComentarioService;


/**
 * Servlet implementation class CadastrarComentarioController
 */
@WebServlet("/cadastrarComentario.do")
public class CadastrarComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ComentarioService comentarioService = new ComentarioService();       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int fk_noticia_id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession sessao= request.getSession();
		int fk_noticia_id = (Integer) sessao.getAttribute("fk");		
		
		Comentario comentario =  new Comentario();
		comentario.setNome(request.getParameter("nome"));
		comentario.setComentario(request.getParameter("comentario"));	
		comentario.setIdNoticia(fk_noticia_id);

		comentarioService.inserir(comentario);
		
		response.sendRedirect("homeRealNews.do");
		
	}

}
