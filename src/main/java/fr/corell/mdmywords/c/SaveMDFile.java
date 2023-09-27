package fr.corell.mdmywords.c;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import fr.corell.mdmywords.m.tools.TranslatorToMD;


public class SaveMDFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rawText = request.getParameter("rawText");
		String noteTitle = request.getParameter("title");
		if (noteTitle.indexOf(" ") != -1) {
			noteTitle = noteTitle.replaceAll(" ", "");
		}
		
		String textMarkDown = TranslatorToMD.getInstance().translateMD(rawText);
		List<String> lines = Arrays.asList(textMarkDown.split(System.lineSeparator()));
		FileWriter writer = new FileWriter(System.getProperty("user.home") + "\\desktop\\" + noteTitle + ".md");
		writer.write(textMarkDown);

		writer.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("home");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
