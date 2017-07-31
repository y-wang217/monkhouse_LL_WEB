package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class NonContinuationOfBenefitsSection extends SOCSection{
	public NonContinuationOfBenefitsSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.NON_BENEFITS);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Non-Continuation of Benefits");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("The termination clause does not account for sufficient benefit continuation as required by the Employment Standards Act, (2000) (“ESA”). Pursuant to the ESA, benefits must continue throughout the duration of the statutory notice period. "
				+ "%%"
				+ "%%Failure to do so will render the entire clause invalid pursuant to section 5(1) of the ESA."
				+ "%%"
				+ "%%[PLAINTIFF] pleads that as the clause does not adhere to the ESA standards, it cannot be relied on by the Defendant to limit [HIS/HER] common law entitlements.  ");
		content.add(text);

        this.setContents(content);
	}
}
