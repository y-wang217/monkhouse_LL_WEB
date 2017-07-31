package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class BadFaithDutyOfHonestySection extends SOCSection{
	public BadFaithDutyOfHonestySection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.BAD_FAITH);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Bad Faith and Duty of Honesty");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that [EMPLOYER] has acted dishonestly by attempting to contract out of their statutory entitlements. In light of [EMPLOYER’S] conduct discussed above, [EMPLOYER] has failed to carry out their contractual duties in good faith.");
		content.add(text);

        this.setContents(content);
	}
}
