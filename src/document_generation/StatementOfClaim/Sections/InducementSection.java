package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class InducementSection extends SOCSection{
	public InducementSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.INDUCEMENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelectParagraphText(this.getSelectSql());
		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText(resultSet.get("1"));
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText(resultSet.get("2"));
		content.add(text);
//		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText("Inducement");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("Prior to <possessive_pronoun> employment with <employer_first_name>, <client_first_name> was employed with <previous_employer> for <previous_employment_tenure> years. <client_first_name> pleads that <subjective_pronoun> was induced by the Defendant to leave <possessive_pronoun> previous company and join the Defendant."
//				+ "%%"
//				+ "%%<client_first_name> pleads that as <subjective_pronoun> was induced to leave a prior position for the Defendant company, the tenure accrued at the prior position must be considered in any assessment of a reasonable notice period. ");
//		content.add(text);

        this.setContents(content);
	}
}

