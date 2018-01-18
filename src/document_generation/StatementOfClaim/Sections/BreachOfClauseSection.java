package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class BreachOfClauseSection extends SOCSection{
	public BreachOfClauseSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.ABoCDSR);

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
//		header.setText("Alternatively, Breach of Clause Disallows Subsequent Reliance");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("The Plaintiff pleads that as the termination clause within <possessive_pronoun> employment agreement is unenforceable, <subjective_pronoun> is entitled to reasonable notice for the termination of <possessive_pronoun> employment pursuant to common law. "
//				+ "%%"
//				+ "%%In the alternative, the Defendant breached the termination clause <reason_possible_breach> and cannot rely on same to limit the liability of their breach. As such, <client_first_name> would be entitled to common law reasonable notice for the termination of <possessive_pronoun> employment. ");
//		content.add(text);

        this.setContents(content);
	}
}
