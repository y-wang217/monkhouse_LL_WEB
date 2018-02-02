package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class HumanRightsSection extends SOCSection{
	public HumanRightsSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.HUMAN_RIGHTS);

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
//
//		LLParagraph text2 = llpf.getParagraph(doc, ParaCode.REG);
//		text2.setText(resultSet.get("3"));
//		content.add(text2);
		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Human Rights");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.LIST);
		text.setText("In the absence of any legitimate reason for the termination of his employment, <client_first_name> pleads that <possessive_pronoun> [GROUND FOR DISCRIMINATION] played a significant factor in <employer_first_name>'s decision to terminate <object_pronoun>. Discrimination on the basis of <grounds_for_discrimination> is contrary to the provisions of the <human_rights_legislation> for which an award of damages for injury to dignity, feelings and self respect are rightfully owed."
				+ "%%"
				+ "%%<client_first_name> suggests that an appropriate amount should be allocated in respect to a claim for human rights violations. ");
		content.add(text);
		
		LLParagraph text2 = llpf.getParagraph(doc, ParaCode.REG);
		text2.setText("<client_first_name> pleads that <subjective_pronoun> will particularize the claim relating to human rights within 30 days of receiving the Affidavit of Documents form the Defendant, if requested, since only at that time would there be adequate documentation to detail the claim. "
				+ "%%"
				+ "%%<client_first_name> requests the Court to consider an award of back pay with the option of reinstatement as well as a lump sum payment regarding a human rights claim. ");
		content.add(text2);

        this.setContents(content);
	}
}
