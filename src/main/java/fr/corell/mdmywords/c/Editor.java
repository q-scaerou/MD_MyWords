package fr.corell.mdmywords.c;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.corell.mdmywords.m.bll.NoteBookManager;
import fr.corell.mdmywords.m.bo.Notebook;
import fr.corell.mdmywords.m.tools.TranslatorToMD;


public class Editor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Notebook> recentNB = NoteBookManager.getInstance().selectRecent();
		request.setAttribute("recentNB", recentNB);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editor.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDateTime creationDate = LocalDateTime.now();
		String notebookTitle = request.getParameter("title");
		String formNbPage = request.getParameter("nbPage");
		
		int nbPage = Integer.valueOf(formNbPage);
		System.out.println("nb Pages: " + nbPage);
		
		List<String> notesContents = new ArrayList<String>();
		
		for (int i = 1; i <= nbPage; i++) {
			notesContents.add(TranslatorToMD.getInstance().translateMD(request.getParameter("rawText" + i)));
			System.out.println("notecontent: " + request.getParameter("rawText" + i));
		}
		System.out.println(notesContents);
		NoteBookManager.getInstance().insert(notebookTitle, creationDate, notesContents);
		
				
		RequestDispatcher rd = request.getRequestDispatcher("notebooks");
		rd.forward(request, response);
		
	}

}
