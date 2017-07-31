package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

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

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Independent Contractor vs Employee");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("Despite the fact that [EMPLOYER] categorized [PLAINTIFF] as an independent contractor, [PLAINTIFF] is actually an employee based on the relationship between the parties. "
				+ "%%"
				+ "%%Jurisprudence is clear that it is the substance of the relationship that determines the employment status of the worker. Factors such as exclusivity of work, control over the worker, ownership of tools, assumption of business risks, and ownership of business are considered to determine whether a worker is an employee or contract. "
				+ "%%"
				+ "%%[insert factual information in relation to the above noted factors]"
				+ "%%"
				+ "%%Alternatively, even if [PLAINTIFF] is not found to be an employee, at the very least [HE/SHE] would be categorized as a dependent contractor. As a dependent contractor, [PLAINTIFF] is still entitled to reasonable common law notice. ");
		content.add(text);

        this.setContents(content);
	}
}
