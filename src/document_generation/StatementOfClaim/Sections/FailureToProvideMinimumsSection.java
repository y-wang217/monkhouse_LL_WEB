package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

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

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Failure to Provide Statutory Minimums");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that [EMPLOYER] has failed in their obligation to provide [HIS/HER] statutory entitlements at termination, including but not limited to termination pay, severance pay, overtime pay, or Record of Employment. "
				+ "%%"
				+ "%%As such, [EMPLOYER] has conducted independent actionable wrongs for which the award of punitive, aggravated, Bhasin, and/or moral damages would be justified. ");
		content.add(text);

        this.setContents(content);
	}
}
