package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class DoesNotExcludeCommonLawSection extends SOCSection{
	public DoesNotExcludeCommonLawSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.NOT_EXCLUDE);

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
//		header.setText("Does Not Exclude Common Law Notice");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("The termination clause in <client_first_name>'s employment contract does not explicitly exclude the entitlement to common law notice. <client_first_name> pleads that as the clause does not exclude reasonable common law notice, it is ambiguous and ought to be construed as the Defendant. ");
//		content.add(text);

        this.setContents(content);
	}
}
