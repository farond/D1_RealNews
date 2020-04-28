package br.usjt.realnews.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.usjt.realnews.model.Comentario;
import br.usjt.realnews.model.Noticia;
import br.usjt.realnews.service.ComentarioService;
import br.usjt.realnews.service.NoticiaService;


/**
 * Servlet implementation class NoticiaPageController
 */
@WebServlet("/noticiaPage.do")
public class NoticiaPageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final NoticiaService noticiaService = new NoticiaService();
	private final ComentarioService comentarioService = new ComentarioService();	 
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		response.getWriter().println("<a href='homeRealNews.do'>Voltar a Home</a>");

		String parameterId = request.getParameter("id") != null && !request.getParameter("id").isEmpty()
				? request.getParameter("id")
				: "-1";
		int id = Integer.parseInt(parameterId);

		if (id <= 0) {
			saida.println("<h1>Noticia Não encontrada.</h1>");
			return;
		}
		
		Noticia resultado = noticiaService.consultarNoticia(id);

		if (!resultado.isValid()) {
			saida.println("<h1>Noticia não encontrada.</h1>");
		} else {
			saida.println("<h1>RealNews<h1>");
			saida.println("<hr>");
			saida.println("<h1>" + resultado.getTitulo() + "</h1>");
			saida.println("<h3>" + resultado.getDescricao() + "</h3>");
			saida.println("<p>" + resultado.getTexto() + "</p>");
			saida.println("<hr>");
			saida.println("<h4>Comentários</h4>");

			
			List<Comentario> comentarios = comentarioService.listar(id);

			if (comentarios.isEmpty()) {
				saida.println("<p>Nenhum Comentário.</p>");
			} else {
				for (Comentario comentario : comentarios) {
					saida.println("<h5>" + comentario.getNome() + "</h5>");
					saida.println("<p>" + comentario.getComentario() + "</p>");
					saida.println("<hr>");
				}
			}

			saida.println("<form method='post'");
			saida.println("<label>Adicionar comentário:</label>");
			saida.println("<br>");
			saida.println("<input type='hidden' name='idNoticia' value='" + id + "'>");
			saida.println("<input type='text' name='nome' placeholder='Seu nome' required>");
			saida.println("<br>");
			saida.println("<textarea name='texto' placeholder='Seu comentário' required></textarea>");
			saida.println("<br>");
			saida.println("<input type='submit' value='Enviar'>");
			saida.println("</form>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome"),
				texto = request.getParameter("texto"),
				parameterIdNoticia = request.getParameter("idNoticia") != null && !request.getParameter("idNoticia").isEmpty()
						? request.getParameter("idNoticia")
								: "-1";
						
		int idNoticia = Integer.parseInt(parameterIdNoticia);

		Comentario comentario = new Comentario();
		comentario.setIdNoticia(idNoticia);
		comentario.setNome(nome);
		comentario.setComentario(texto);
		
		ComentarioService comentarioService = new ComentarioService();
		comentarioService.inserir(comentario);
		
		
		
		doGet(request, response);
	}

}
