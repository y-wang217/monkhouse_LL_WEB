package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class DamageAwardSection extends SOCSection{
	public DamageAwardSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.DAMAGE_AWARD);

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
//
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText("Damage Award");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that <employer_first_name>'s decision to terminate <object_pronoun> was done so in an effort to avoid obligations to compensate the Plaintiff as required by law. The unsubstantiated allegations of cause have further made it increasingly difficult for <client_first_name> to obtain new employment. As such, <client_first_name> pleads that <employer_first_name> is liable for punitive, aggravated, and/or moral damages for their improper allegation of cause. "
//				+ "%%"
//				+ "%%<client_first_name> pleads that in the absence of sufficient cause for the termination of <possessive_pronoun> employment, <subjective_pronoun> is entitled to a reasonable notice period for the termination of <possessive_pronoun> employment.  ");
//		content.add(text);

        this.setContents(content);
	}
}
