package fr.corell.mdmywords.m.tools;

import java.util.HashMap;


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
		htmlElementToMD.put("<pre spellcheck=\"false\">", "`");
		htmlElementToMD.put("</pre>", "`");
		
	}
	public String translateMD(String htmlText) {
		
		
		
		htmlText = htmlText.replace("<h1>", htmlElementToMD.get("<h1>"));
		htmlText = htmlText.replace("</h1>", htmlElementToMD.get("</h1>"));
		htmlText = htmlText.replace("<h2>", htmlElementToMD.get("<h2>"));
		htmlText = htmlText.replace("</h2>", htmlElementToMD.get("</h2>"));
		htmlText = htmlText.replace("<h3>", htmlElementToMD.get("<h3>"));
		htmlText = htmlText.replace("</h3>", htmlElementToMD.get("</h3>"));
		htmlText = htmlText.replace("<h4>", htmlElementToMD.get("<h4>"));
		htmlText = htmlText.replace("</h4>", htmlElementToMD.get("</h4>"));
		
		return htmlText;
		
	}

}
