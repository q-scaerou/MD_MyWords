package fr.corell.mdmywords.m.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TranslatorToMD {
	
	private static TranslatorToMD instance;
	private static HashMap<String, String> htmlElementToMD = new HashMap<String, String>();
	
	private TranslatorToMD() {
		populateHashMap();
	}

	public static TranslatorToMD getInstance() {
		if (instance == null) {
			instance = new TranslatorToMD();
		}
		return instance;
	}
	
	private void populateHashMap() {
		htmlElementToMD.put("<h1>", "# ");
		htmlElementToMD.put("</h1>", System.lineSeparator());
		htmlElementToMD.put("<h2>", "## ");
		htmlElementToMD.put("</h2>", System.lineSeparator());
		htmlElementToMD.put("<h3>", "### ");
		htmlElementToMD.put("</h3>", System.lineSeparator());
		htmlElementToMD.put("<h4>", "#### ");
		htmlElementToMD.put("</h4>", System.lineSeparator());
		htmlElementToMD.put("<p>", "");
		htmlElementToMD.put("</p>", System.lineSeparator());
		htmlElementToMD.put("<strong>", "**");
		htmlElementToMD.put("</strong>", "**");
		htmlElementToMD.put("<em>", "*");
		htmlElementToMD.put("</em>", "*");
		htmlElementToMD.put("<blockquote>", ">");
		htmlElementToMD.put("</blockquote>", System.lineSeparator());
		htmlElementToMD.put("<pre spellcheck=\"false\">", "`");
		htmlElementToMD.put("</pre>", "`" + System.lineSeparator());
		htmlElementToMD.put("<ul>", "");
		htmlElementToMD.put("</ul>", "");
		htmlElementToMD.put("<ol>", "");
		htmlElementToMD.put("</ol>", "");
		htmlElementToMD.put("</li>", System.lineSeparator());
		htmlElementToMD.put("<br>", System.lineSeparator());
	}
	
	public String translateMD(String htmlText) {
		
		
		// Replacing titles
		htmlText = htmlText.replace("<h1>", htmlElementToMD.get("<h1>"));
		htmlText = htmlText.replace("</h1>", htmlElementToMD.get("</h1>"));
		htmlText = htmlText.replace("<h2>", htmlElementToMD.get("<h2>"));
		htmlText = htmlText.replace("</h2>", htmlElementToMD.get("</h2>"));
		htmlText = htmlText.replace("<h3>", htmlElementToMD.get("<h3>"));
		htmlText = htmlText.replace("</h3>", htmlElementToMD.get("</h3>"));
		htmlText = htmlText.replace("<h4>", htmlElementToMD.get("<h4>"));
		htmlText = htmlText.replace("</h4>", htmlElementToMD.get("</h4>"));
		
		// Replacing normal text
		htmlText = htmlText.replace("<p>", htmlElementToMD.get("<p>"));
		htmlText = htmlText.replace("</p>", htmlElementToMD.get("</p>"));
		
		// Replacing bold font style
		htmlText = htmlText.replace("<strong>", htmlElementToMD.get("<strong>"));
		htmlText = htmlText.replace("</strong>", htmlElementToMD.get("</strong>"));
		
		// Replacing italic font style
		htmlText = htmlText.replace("<em>", htmlElementToMD.get("<em>"));
		htmlText = htmlText.replace("</em>", htmlElementToMD.get("</em>"));
		
		// TODO Add replace for <ul></ul> and before replace " <" par "< ... "
		// TODO repair save file to desktop cause it doesn't work.
		
		// Replacing block quote
		htmlText = htmlText.replace("<blockquote>", htmlElementToMD.get("<blockquote>"));
		htmlText = htmlText.replace("</blockquote>", htmlElementToMD.get("</blockquote>"));
		
		// Replacing code blocks
		htmlText = htmlText.replace("<pre spellcheck=\"false\">", htmlElementToMD.get("<pre spellcheck=\"false\">"));
		htmlText = htmlText.replace("</pre>", htmlElementToMD.get("</pre>"));
		
		// Replacing line break
		htmlText = htmlText.replace("<br>", htmlElementToMD.get("<br>"));
		
		// Dealing with links
		int countLinks = 0;
		for (int i = 0; i < htmlText.length() - 8; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(htmlText.charAt(i));
			sb.append(htmlText.charAt(i + 1));
			sb.append(htmlText.charAt(i + 2));
			sb.append(htmlText.charAt(i + 3));
			sb.append(htmlText.charAt(i + 4));
			sb.append(htmlText.charAt(i + 5));
			sb.append(htmlText.charAt(i + 6));
			sb.append(htmlText.charAt(i + 7));
			if (sb.toString().equals("<a href=")) {
				countLinks++;
			}
		}
		
		if (countLinks > 0) {
			List<String> links = new ArrayList<String>();
			String croppedText = htmlText;
			String link = "";
			for (int i = 0; i < countLinks; i++) {
				
				// Substring to first appearance of '<a href=' tag
				int currentIndex = croppedText.indexOf("<a href=");
				croppedText = croppedText.substring(currentIndex);
				
				link = croppedText.substring(0, croppedText.indexOf("</a>") + 4);
				if (currentIndex + 1 <= croppedText.length()) {
					croppedText = croppedText.substring(currentIndex + 1);
				}
				
				links.add(link.trim());
				
			}	
			
			for (String currentLink : links) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				String title = currentLink.substring(currentLink.indexOf(">") + 1, currentLink.indexOf("</"));
				sb.append(title);
				sb.append("](");
				String href = currentLink.substring(currentLink.indexOf("\"") + 1, currentLink.indexOf("target=\"_bla") - 2);
				sb.append(href);
				sb.append(")");
				
				htmlText = htmlText.replace(currentLink, sb.toString());
				
			}
			
		}
		
		// Dealing with unordered lists
		int countUnorderedLists = 0;
		for (int i = 0; i < htmlText.length() - 8; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(htmlText.charAt(i));
			sb.append(htmlText.charAt(i + 1));
			sb.append(htmlText.charAt(i + 2));
			sb.append(htmlText.charAt(i + 3));
			if (sb.toString().equals("<ul>")) {
				countUnorderedLists++;
			}
		}
		
		if (countUnorderedLists > 0) {
			
			// STEP 1: Identify and store all unordered lists
			List<String> unorderedLists = new ArrayList<String>();
			String list = "";
			String croppedText = htmlText;
			for (int i = 0; i < countUnorderedLists; i++) {
				// Finding next occurrence of <ul> tag
				int currentIndex = croppedText.indexOf("<ul>");
				croppedText = croppedText.substring(currentIndex);
				list = croppedText.substring(0, croppedText.indexOf("</ul>") + 5);
				
				if (currentIndex + 1 <= croppedText.length()) {
					croppedText = croppedText.substring(currentIndex + 1);
				}
				unorderedLists.add(list.trim());
			}
			
			for (String currentList : unorderedLists) {
				String tmpList = currentList;
				currentList = currentList.replace("<ul>", htmlElementToMD.get("<ul>"));
				currentList = currentList.replace("</ul>", htmlElementToMD.get("</ul>"));
				currentList = currentList.replace("</li>", htmlElementToMD.get("</li>"));
				currentList = currentList.replace("<li>", "- ");
				
				htmlText = htmlText.replace(tmpList, currentList);
						
			}
			
		}
		
		
		// Dealing with ordered lists
		int countOrderedLists = 0;
		for (int i = 0; i < htmlText.length() - 8; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(htmlText.charAt(i));
			sb.append(htmlText.charAt(i + 1));
			sb.append(htmlText.charAt(i + 2));
			sb.append(htmlText.charAt(i + 3));
			if (sb.toString().equals("<ol>")) {
				countOrderedLists++;
			}
		}
		
		if (countOrderedLists > 0) {
			List<String> orderedLists = new ArrayList<String>();
			String list = "";
			String croppedText = htmlText;
			for (int i = 0; i < countOrderedLists; i++) {
				int currentIndex = croppedText.indexOf("<ol>");
				croppedText = croppedText.substring(currentIndex);
				list = croppedText.substring(0, croppedText.indexOf("</ol>") + 5);
				
				if (currentIndex + 1 <= croppedText.length()) {
					croppedText = croppedText.substring(currentIndex + 1);
				}
				orderedLists.add(list.trim());
			}
			int count = 1;
			for (String currentList : orderedLists) {
				String tmpList = currentList;
				currentList = currentList.replace("<ol>", htmlElementToMD.get("<ol>"));
				currentList = currentList.replace("</ol>", htmlElementToMD.get("</ol>"));
				currentList = currentList.replace("</li>", htmlElementToMD.get("</li>"));
				currentList = currentList.replace("<li>", count + ". ");
				
				htmlText = htmlText.replace(tmpList, currentList);
				count++;
				
			}
			
		}
		if (htmlText.indexOf("</div>") != -1) {
			htmlText = htmlText.substring(0, htmlText.indexOf("</div>"));
		}
		
		return htmlText;
		
	}

}
