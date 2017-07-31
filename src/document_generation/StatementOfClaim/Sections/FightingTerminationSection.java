package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class FightingTerminationSection extends SOCSection{
	public FightingTerminationSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.FIGHTING_TERM);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Fighting a Termination Clause");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[Plaintiff] pleads that any attempts by the Defendant to rely on a contractual provision to limit [HIS/HER] entitlements are without merit as his employment agreement is invalid. ");
		content.add(text);

        this.setContents(content);
	}
}
