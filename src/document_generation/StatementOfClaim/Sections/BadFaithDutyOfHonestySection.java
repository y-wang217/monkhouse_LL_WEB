package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class BadFaithDutyOfHonestySection extends SOCSection{
	public BadFaithDutyOfHonestySection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.BAD_FAITH);

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
//		header.setText("Bad Faith and Duty of Honesty");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that <employer_first_name> has acted dishonestly by attempting to contract out of their statutory entitlements. In light of <employer_first_name>'s conduct discussed above, <employer_first_name> has failed to carry out their contractual duties in good faith.");
//		content.add(text);

        this.setContents(content);
	}
}
