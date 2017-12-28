package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class PunitiveDamagesHarassmentSection extends SOCSection{
	public PunitiveDamagesHarassmentSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.PUNITIVE_HARASSMENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelect(this.getSelectSql());
		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText(resultSet.get("1"));
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText(resultSet.get("2"));
		content.add(text);
//		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText("Punitive Damages - Harassment");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("Furthermore, the harassment experienced by <client_first_name> while employed with <employer_first_name> is grounds for punitive, aggravated, and/or moral damages."
//				+ "%%"
//				+ "%%<client_first_name> pleads that <employer_first_name>'s failure to maintaining a safe environment effectively condoned the harassment in the workplace and is liable for significant punitive, aggravated, and/or moral damages. ");
//		content.add(text);

        this.setContents(content);
	}
}
