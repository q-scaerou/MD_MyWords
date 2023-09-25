package fr.corell.mdmywords.c;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


public class Editor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editor.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDateTime creationDate = LocalDateTime.now();
		String notebookTitle = request.getParameter("title");
		String rawText = request.getParameter("rawText");
		System.out.println(creationDate);
		System.out.println(notebookTitle);
		System.out.println(rawText);
		
		RequestDispatcher rd = request.getRequestDispatcher("notebooks");
		rd.forward(request, response);
		
	}

}
