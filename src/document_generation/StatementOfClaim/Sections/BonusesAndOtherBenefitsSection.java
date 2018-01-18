package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class BonusesAndOtherBenefitsSection extends SOCSection{
	public BonusesAndOtherBenefitsSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.BONUSES_OTHERS);

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
//		header.setText("Bonuses and Other Benefits");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that as part of <possessive_pronoun> employment agreement, <subjective_pronoun> is entitled to receive a bonus periodically throughout her employment. The bonus played an integral part of <client_first_name>'s compensation package. "
//				+ "%%"
//				+ "%%<client_first_name> pleads that <subjective_pronoun> is entitled to full compensation for his bonus and all employment related benefits, including but not limited to medical benefits, life insurance, and disability benefits throughout the entirety of the notice period as <subjective_pronoun> would have received these entitlements had <employer_first_name> not breached the employment agreement.  ");
//		content.add(text);

        this.setContents(content);
	}
}
