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
		htmlElementToMD.put("</h1>", "");
		htmlElementToMD.put("<h2>", "## ");
		htmlElementToMD.put("</h2>", "");
		htmlElementToMD.put("<h3>", "### ");
		htmlElementToMD.put("</h3>", "");
		htmlElementToMD.put("<h4>", "#### ");
		htmlElementToMD.put("</h4>", "");
		htmlElementToMD.put("<p>", "");
		htmlElementToMD.put("</p>", "");
		htmlElementToMD.put("<strong>", "**");
		htmlElementToMD.put("</strong>", "**");
		htmlElementToMD.put("<em>", "*");
		htmlElementToMD.put("</em>", "*");
		htmlElementToMD.put("<blockquote>", ">");
		htmlElementToMD.put("</blockquote>", "");
		htmlElementToMD.put("<pre spellcheck=\"false\">", "`");
		htmlElementToMD.put("</pre>", "`");
		
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
		
		// Replacing block quote
		htmlText = htmlText.replace("<blockquote>", htmlElementToMD.get("<blockquote>"));
		htmlText = htmlText.replace("</blockquote>", htmlElementToMD.get("</blockquote>"));
		
		// Replacing code blocks
		htmlText = htmlText.replace("<pre spellcheck=\"false\">", htmlElementToMD.get("<pre spellcheck=\"false\">"));
		htmlText = htmlText.replace("</pre>", htmlElementToMD.get("</pre>"));
		
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
			// TODO time to code it :D
		}
		
		
		// Dealing with ordered lists
				int countOrderedLists = 0;
				for (int i = 0; i < htmlText.length() - 8; i++) {
					StringBuilder sb = new StringBuilder();
					sb.append(htmlText.charAt(i));
					sb.append(htmlText.charAt(i + 1));
					sb.append(htmlText.charAt(i + 2));
					sb.append(htmlText.charAt(i + 3));
					if (sb.toString().equals("<ul>")) {
						countOrderedLists++;
					}
				}
				
				if (countOrderedLists > 0) {
					// TODO time to code it :D
				}
		
				
		return htmlText;
		
	}

}
