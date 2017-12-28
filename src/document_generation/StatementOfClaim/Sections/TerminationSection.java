package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class TerminationSection extends SOCSection{
	public TerminationSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.TERMINATION);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelect(this.getSelectSql());
		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText(resultSet.get("1"));
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText(resultSet.get("2"));
//		content.add(text);
//		
//		LLParagraph text2 = llpf.getParagraph(doc, ParaCode.REG);
//		text2.setText(resultSet.get("3"));
//		content.add(text2);
//		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Termination");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("The Plaintiff was notified of <possessive_pronoun> termination on <termination_date>."
				+ "%%"
				+ "%%[no real default language here; this should be entirely context based and rewritten on a case-by-case basis.]");
		content.add(text);
		
		LLParagraph text2 = llpf.getParagraph(doc, ParaCode.REG);
		text2.setText("if applicable] As <client_first_name> was terminated without cause, <subjective_pronoun> would be entitled to notice for the termination of <possessive_pronoun> employment.");
		content.add(text2);

        this.setContents(content);
	}
}
