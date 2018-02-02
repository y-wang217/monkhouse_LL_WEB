package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class OpenAndHonestMannerSection extends SOCSection{
	public OpenAndHonestMannerSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.OPEN_HONEST);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelectParagraphText(this.getSelectSql());
		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText(resultSet.get("1"));
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText(resultSet.get("2"));
//		content.add(text);
		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Open and Honest Matter");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.LIST);
		text.setText("<client_first_name> pleads that <employer_first_name> has a duty to carry out an employee’s termination in an open and honest manner and has failed to do so in this case. ");
		content.add(text);

        this.setContents(content);
	}
}
