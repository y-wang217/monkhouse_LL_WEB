package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class OntarioOvertime extends SOCSection{
	public OntarioOvertime(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.ONT_OVERTIME);

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
//		header.setText("Ontario Overtime");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that throughout <possessive_pronoun> employment with <employer_first_name>, <subjective_pronoun> regularly worked over forty-four (44) hours per week which was unpaid by <employer_first_name>."
//				+ "%%"
//				+ "%%<client_first_name> pleads that in total, <subjective_pronoun> worked <hoursOvertimeOwed> hours of overtime during her tenure with <employer_first_name>. <client_first_name> pleads that <subjective_pronoun> is entitled to overtime pay at 1.5 rate, for a total of $<overtimeOwed>.00. "
//				+ "%%"
//				+ "%%In the alternative, <client_first_name> pleads that <subjective_pronoun> would be entitled to ‘straight time’ for the hours of overtime worked, in accordance with the principle of quantum meruit for a total sum of [DOLLAR AMOUNT]. "
//				+ "%%"
//				+ "%%[if applicable] <client_first_name> further pleads that any limitation period begins to run from the date of discovery of the overtime claim which only occured after termination.");
//		content.add(text);

        this.setContents(content);
	}
}
