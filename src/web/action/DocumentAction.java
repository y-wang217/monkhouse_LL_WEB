package web.action;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.StringUtils;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLDocument.gender;
import document_generation.LawyersLetter.Sections.ClosingSection;
import document_generation.LawyersLetter.Sections.MovingForwardSection;
import document_generation.util.message.ActionMessage;
import document_generation.util.message.MessageType;
import document_generation.util.message.ServletMessage;

public class DocumentAction {

	public static ActionMessage createDocument(
			LinkedHashMap<String, String> params, String filePath) {
		// check for mandatory fields:
		ActionMessage msg = new ActionMessage();
		if (StringUtils.isBlank(params.get("seniority_in_years"))) {
			msg.add(MessageType.ERROR, "Warning! field missing: seniority");
		}
		if (StringUtils.isBlank(params.get("wage_in_dollars"))) {
			msg.add(MessageType.ERROR, "Warning! field missing: wage");
		}
		if (StringUtils.isBlank(params.get("settlement"))) {
			msg.add(MessageType.ERROR, "Warning! field missing: settlement");
		}
		if (StringUtils.isBlank(params.get("age"))) {
			msg.add(MessageType.ERROR, "Warning! field missing: age");
		}
		if (StringUtils.isBlank(params.get("settlement"))) {
			msg.add(MessageType.ERROR, "Warning! field missing: settlement");
		}

		LLDocument doc = new LLDocument();

		doc.setFieldsMap(params);
		doc.setClientGender(params.get("client_gender").equals("male") ? gender.m
				: gender.f);
		// TextUI.init(doc);
		doc.writeDocFromFields();
		doc.writeToDoc(new MovingForwardSection(doc, new LLParagraphFactory()));
		doc.writeToDoc(new ClosingSection(doc, new LLParagraphFactory()));

		document_generation.util.CloseDocument.closeSimple(doc, filePath);

		msg.add(MessageType.SUCCESS, "file created.");
		return msg;
	}
}
