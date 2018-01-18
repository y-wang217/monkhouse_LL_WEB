package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class HightStandardForCauseSection extends SOCSection{
	public HightStandardForCauseSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.HIGH_STANDARD);

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
//		header.setText("High Standard for Cause");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that the standard for just cause is very high, and only a finding of wilful misconduct will be sufficient to support a termination with just cause. An employee’s termination for cause must come after other alternatives, such as progressive discipline, have been contemplated and implemented. ");
//		content.add(text);

        this.setContents(content);
	}
}
