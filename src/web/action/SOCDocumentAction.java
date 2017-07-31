package web.action;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.StringUtils;

import document_generation.LawyersLetter.LLDocument.gender;
import document_generation.StatementOfClaim.SOCDocument;
import document_generation.util.message.ActionMessage;
import document_generation.util.message.MessageType;

public class SOCDocumentAction {
	
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

		SOCDocument doc = new SOCDocument();

		doc.setFieldsMap(params);
		doc.setClientGender(params.get("client_gender").equals("male") ? gender.m
				: gender.f);
		// TextUI.init(doc);
		doc.writeDocFromFields();

		document_generation.util.CloseDocument.closeSimple(doc, filePath);

		msg.add(MessageType.SUCCESS, "file created.");
		return msg;
	}
}
