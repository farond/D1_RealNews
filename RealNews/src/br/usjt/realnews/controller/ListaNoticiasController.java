package br.usjt.realnews.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.realnews.model.Noticia;
import br.usjt.realnews.service.NoticiaService;

/**
 * Servlet implementation class ListaNoticiasController
 */
@WebServlet("/listaNoticias.do")
public class ListaNoticiasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private final NoticiaService noticiaService = new NoticiaService();
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		response.getWriter().println("<a href='index.html'>Adicionar Nova Noticia</a>");
		response.getWriter().println("<a href='homeRealNews.do'>Home User</a>");
		response.getWriter().println("<h1>Lista de Noticias</h1>");
		response.getWriter().println("<title>Gerenciador de Noticias</title>");
		
		List<Noticia> listaNoticia = noticiaService.listarNoticias();
		
		
		for(Noticia noticia : listaNoticia) {
			response.getWriter().println(
					"<table border='1px'width='100%'>"
							+"<tr>"
								+"<th>Código Noticia</th>"								
								+"<th>Descrição</th>"
								+"<th>Titulo</th>"
								+"<th>Texto</th>"
								+"<th>Atualizar</th>"
								+"<th>Deletar</th>"
							+"</tr>"
							+"<tr>"
								+"<td>"+noticia.getId()+"</td>"
								+"<td>"+noticia.getDescricao()+"</td>"
								+"<td>"+noticia.getTitulo()+"</td>"
								+"<td>"+noticia.getTexto()+"</td>"								
								+"<td><a href=atualizaNoticia.do?id="+noticia.getId()+">Atualizar</a></td>"
								+"<td><a href=excluirNoticia.do?id="+noticia.getId()+">Excluir</a></td>"
							+"</tr>"
					+"</table>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
