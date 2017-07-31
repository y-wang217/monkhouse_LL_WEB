package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class NoContractESASection extends SOCSection{
	public NoContractESASection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.NO_CONTRACTING);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("No Contracting Out of ESA");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("Pursuant to the Employment Standards Act, 2000 (“ESA”), an employer cannot contract out of the minimum requirements established by the ESA. Under section 5(1) of the ESA, any provisions that provide less than the minimums prescribed are void.  ");
		content.add(text);

        this.setContents(content);
	}
}
