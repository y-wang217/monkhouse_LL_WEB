package web.action;

import java.util.LinkedHashMap;

import document_generation.LawyersLetter.LLDocument;

public class DocumentAction {
	public static void createDocument(LinkedHashMap<String, String> params, String filePath){
		LLDocument doc = new LLDocument();
		doc.setFieldsMap(params);
		doc.writeDocFromFields();
		document_generation.util.CloseDocument.closeSimple(doc, filePath);
	}
}
