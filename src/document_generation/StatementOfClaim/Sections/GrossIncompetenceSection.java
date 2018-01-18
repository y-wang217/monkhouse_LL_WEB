package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class GrossIncompetenceSection extends SOCSection{
	public GrossIncompetenceSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.GROSS);

		ArrayList<LLParagraph> content = new ArrayList<>();
		
		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelectParagraphText(this.getSelectSql());
		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText(resultSet.get("1"));
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText(resultSet.get("2"));
		content.add(text);

//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText("Gross Incompetence");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that <subjective_pronoun> performed well in <possessive_pronoun> position and was not aware that <possessive_pronoun> performance was a significant issue while employed with <employer_first_name>. The Plaintiff pleads that if <possessive_pronoun> performance was an issue, <subjective_pronoun> ought to have provided <object_pronoun> with additional training and/or coaching prior to terminating <object_pronoun> for cause. ");
//		content.add(text);

        this.setContents(content);
	}
}
