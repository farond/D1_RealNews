package br.usjt.realnews.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.realnews.model.Noticia;
import br.usjt.realnews.service.NoticiaService;

/**
 * Servlet implementation class ExcluiNoticiaController
 */
@WebServlet("/excluirNoticia.do")
public class ExcluiNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final NoticiaService noticiaService = new NoticiaService();
    

	/**
	 * Método para excluir noticia
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noticia noticia = new Noticia();
		noticia.setId(Integer.parseInt(request.getParameter("id")));
		
		noticiaService.deletarNoticia(noticia);
		
		response.sendRedirect("listaNoticias.do");
	}
		

	

}
