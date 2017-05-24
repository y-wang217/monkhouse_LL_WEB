package web.action;

import java.util.LinkedHashMap;

import document_generation.TextUI;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLDocument.gender;
import document_generation.LawyersLetter.Sections.MovingForwardSection;

public class DocumentAction {
	public static void createDocument(LinkedHashMap<String, String> params, String filePath){
    message1();
		LLDocument doc = new LLDocument();
	message2(params);	
		doc.setClientGender(params.get("client_gender").equals("male")?gender.m:gender.f);
		doc.setFieldsMap(params);
		TextUI.init(doc);
		doc.writeDocFromFields();
        doc.writeToDoc(new MovingForwardSection(doc, new LLParagraphFactory()));
		document_generation.util.CloseDocument.closeSimple(doc, filePath);
	}
	
	private final static void message1(){
		System.out.println("CREATING DOCUMENT"
				+ "..."
				+ "..."
				+ "...");
	}

	private final static void message2(LinkedHashMap<String, String> params){
		System.out.println("gender: " + params.get("client_gender")
				+ "..."
				+ "..."
				+ "...");
	}
}
