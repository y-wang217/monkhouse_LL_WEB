package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class IndependentContractorVsEmployeeSection extends SOCSection{
	public IndependentContractorVsEmployeeSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.INDEPENDENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelect(this.getSelectSql());
//		
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
		header.setText("Independent Contractor vs Employee");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("Despite the fact that <employer_first_name> categorized <client_first_name> as an independent contractor, <client_first_name> is actually an employee based on the relationship between the parties. "
				+ "%%"
				+ "%%Jurisprudence is clear that it is the substance of the relationship that determines the employment status of the worker. Factors such as exclusivity of work, control over the worker, ownership of tools, assumption of business risks, and ownership of business are considered to determine whether a worker is an employee or contract. "
				+ "%%"
				+ "%%In this case, based on the character of the Plaintiffs, <subjective_pronoun> would be categorized as an employee based on the following factors:"
				+ "%%<independent_vs_employee>");
		content.add(text);
		LLParagraph text2 = llpf.getParagraph(doc, ParaCode.REG);
		text2.setText("Alternatively, even if <client_first_name> is not found to be an employee, at the very least <subjective_pronoun> would be categorized as a dependent contractor. As a dependent contractor, <client_first_name> is still entitled to reasonable common law notice. ");
		content.add(text2);

        this.setContents(content);
	}
}
