package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class FightingCauseSection extends SOCSection{
	public FightingCauseSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.FIGHTING_CAUSE);

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
//		header.setText("Fighting Cause");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that <employer_first_name> has not satisfied the strict legal tests in place that an employer must satisfy in order to terminate an employee for just cause. Furthermore, <client_first_name> pleads that <employer_first_name> did not conduct an adequate investigation into any allegations pertaining to the reasons for <possessive_pronoun> termination. <client_first_name> pleads that insufficient disciplinary action was taken prior to the decision to terminate.");
//		content.add(text);

        this.setContents(content);
	}
}
