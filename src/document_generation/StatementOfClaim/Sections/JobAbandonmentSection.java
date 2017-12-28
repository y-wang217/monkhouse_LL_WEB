package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class JobAbandonmentSection extends SOCSection{
	public JobAbandonmentSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.ABANDONMENT);

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
//		header.setText("Job Abandonment");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that <subjective_pronoun> did not abandon <possessive_pronoun> position. On multiple occasions, <client_first_name> attempted to contact <employer_first_name> regarding the status of <possessive_pronoun> employment and to return to work. "
//				+ "%%"
//				+ "%%<client_first_name> pleads that an employer has the duty to investigate the reasons behind an employee’s absence and not to immediately conclude that the employee abandoned <possessive_pronoun> position. <client_first_name> pleads that <employer_first_name> did not fulfill their duty in this case prior to alleging job abandonment and terminated <object_pronoun> for cause. ");
//		content.add(text);

        this.setContents(content);
	}
}
