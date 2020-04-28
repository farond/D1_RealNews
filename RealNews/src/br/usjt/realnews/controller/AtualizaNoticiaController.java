package br.usjt.realnews.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.realnews.model.Noticia;
import br.usjt.realnews.service.NoticiaService;


@WebServlet("/atualizaNoticia.do")
public class AtualizaNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final NoticiaService noticiaService = new NoticiaService();
       
	/**
	 * Método responsável por atualizar uma noticia a partir de seu id	 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticiaService noticiaService = new NoticiaService(); 
		int idNoticia = Integer.parseInt(request.getParameter("id"));
		Noticia noticia = noticiaService.consultarNoticia(idNoticia);
				
				// Saída:
				// Formulário para alterar os dados do produto:
				response.setContentType("text/html");
				
				// Criando um objeto para saída de caracteres:
				PrintWriter saida = response.getWriter();
				
				saida.println("<form action='atualizaNoticia.do' method='post'>");
				saida.println("<table>");
				saida.println("ID: " + noticia.getId());
				saida.println("<tr><td></td><td><input type=\"hidden\" name='id' value='"
								+ noticia.getId() + "'/></td></tr>");
				saida.println("<tr><td>Descrição:</td><td>");
				saida.println("<input type='text' name='descricao' value='" 
								+ noticia.getDescricao() + "'/></td></tr>");
				saida.println("<tr><td>Titulo:</td><td>");
				saida.println("<input type='text' name='titulo' value='" 
								+ noticia.getTitulo() + "'/></td></tr>");
				saida.println("<tr><td>Texto:</td><td>");
				saida.println("<input type='text' name='texto' value='"
								+ noticia.getTexto() + "'/></td></tr> ");
								saida.println("<tr><td colspan='2'><input type=\"submit\" value=\"Atualizar Noticia\"/></td></tr>");
				saida.println("</table>");
				saida.println("</form>");
		
	}

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out= response.getWriter();
		
		Noticia noticia = new Noticia();
		
		int idNoticia = Integer.parseInt(request.getParameter("id"));
		noticia.setDescricao(request.getParameter("descricao"));
		noticia.setTitulo(request.getParameter("titulo"));	
		noticia.setTexto(request.getParameter("texto"));	
		
		
		noticiaService.atualizarNoticia(idNoticia, noticia);
			
		 
			   response.sendRedirect("listaNoticias.do");
	            
	       // }else{  
	          // out.println("Desculpe não foi possivel Salvar");  
	           //request.getRequestDispatcher("atualizaNoticia.do").include(request, response);
	      //  }  
		
		// out.close();
		
	}	
	

}
