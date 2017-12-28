package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class FailureToProvideMinimumsSection extends SOCSection{
	public FailureToProvideMinimumsSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.FAIL_MINIMUMS);

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
//		header.setText("Failure to Provide Statutory Minimums");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("<client_first_name> pleads that <employer_first_name> has failed in their obligation to provide <possessive_pronoun> statutory entitlements at termination, including but not limited to termination pay, severance pay, overtime pay, or Record of Employment. "
//				+ "%%"
//				+ "%%As such, <employer_first_name> has conducted independent actionable wrongs for which the award of punitive, aggravated, Bhasin, and/or moral damages would be justified. ");
//		content.add(text);

        this.setContents(content);
	}
}
