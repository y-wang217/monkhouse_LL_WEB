package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class CLCOvertimeSection extends SOCSection{
	public CLCOvertimeSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.CLC);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelect(this.getSelectSql());
		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText(resultSet.get("1"));
		content.add(header);

		LLParagraph header2 = llpf.getParagraph(doc, ParaCode.HEAD);
		header2.setText(resultSet.get("2"));
		content.add(header2);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText(resultSet.get("3"));
		content.add(text);
//		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText("Overtime");
//		content.add(header);
//		
//		LLParagraph header2 = llpf.getParagraph(doc, ParaCode.HEAD);
//		header2.setText("CLC Overtime under the Canada Labour Code");
//		content.add(header2);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that throughout <subjective_pronoun> employment with <employer_first_name>, <subjective_pronoun> regularly worked over forty (40) hours per week which was unpaid by <employer_first_name>."
//				+ "%%<client_first_name> pleads that in total, <subjective_pronoun> worked <hoursOvertimeOwed> hours of overtime during her tenure with <employer_first_name>. <client_first_name> pleads that <subjective_pronoun> is entitled to overtime pay at 1.5 rate, for a total of $<overtimeOwed>.00. "
//				+ "%%"
//				+ "%%In the alternative, <client_first_name> pleads that <subjective_pronoun> would be entitled to ‘straight time’ for the hours of overtime worked, in accordance with the principle of quantum meruit for a total sum of [DOLLAR AMOUNT]. "
//				+ "%%"
//				+ "%%[if applicable] <client_first_name> further pleads that <subjective_pronoun> would not be barred from bringing a claim for unpaid overtime due to a limitation period restriction as the date would begin to run from the date of discovery of the claim. ");
//		content.add(text);

        this.setContents(content);
	}
}

