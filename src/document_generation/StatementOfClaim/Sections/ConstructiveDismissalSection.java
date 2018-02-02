package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class ConstructiveDismissalSection extends SOCSection{
	public ConstructiveDismissalSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.CONSTRUCTIVE);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelectParagraphText(this.getSelectSql());
		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText(resultSet.get("1"));
//		content.add(header);
//
//		LLParagraph header2 = llpf.getParagraph(doc, ParaCode.HEAD);
//		header2.setText(resultSet.get("2"));
//		content.add(header2);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText(resultSet.get("3"));
//		content.add(text);
//		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Constructive Dismissal");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.LIST);
		text.setText("<client_first_name> pleads that for the actions of <employer_first_name>, <subjective_pronoun> has been constructively dismissed. The actions of <employer_first_name> have demonstrated an intention not to abide by the original terms of the employment agreement between the parties. ");
		content.add(text);
		
		LLParagraph text2 = llpf.getParagraph(doc, ParaCode.LIST);
		text2.setText("[contextual assessment of the facts that may establish constructive dismissal: wage deductions, location changes, intolerable workplace, workplace harassment, poisoned worked environment, demotion, etc] ");
		content.add(text2);

        this.setContents(content);
	}
}
