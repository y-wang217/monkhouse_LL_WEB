package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class RemovalFromManagementSection extends SOCSection{
	public RemovalFromManagementSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.REMOVAL_MANAGEMENT);

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
//		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Removal from Management Position");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("<client_first_name> pleads that <possessive_pronoun> employment agreement with <employer_first_name> was unilaterally altered due to <possessive_pronoun> removal from a position of seniority. "
				+ "%%"
				+ "%%As a result of <employer_first_name>'s conduct, <client_first_name> pleads that <subjective_pronoun> has been constructively dismissed. [Summing up reasons for allegation of constructive dismissal]."
				+ "%%"
				+ "%%<client_first_name> pleads that <employer_first_name>'s conduct has resulted in a breach of the employment agreement and that <possessive_pronoun> employment has been effectively terminated. As such, <client_first_name> pleads that <subjective_pronoun> is entitled to reasonable notice for the termination of <possessive_pronoun> employment.");
		content.add(text);
		
		LLParagraph text2 = llpf.getParagraph(doc, ParaCode.REG);
		text2.setText("[if applicable] In the alternative, if the Court were to find that <client_first_name> has not been constructively dismissed, <client_first_name> pleads that her contract has been frustrated because the duties can no longer be fulfilled due to medical reasons. As such, at the very least, "
				+ "%%"
				+ "%%<client_first_name> is owed her minimum entitlements in termination notice and severance pay under the Employment Standards Act, 2000, that being [NUMBER OF WEEKS] weeks. ");
		content.add(text2);

        this.setContents(content);
	}
}
