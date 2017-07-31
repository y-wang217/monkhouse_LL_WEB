package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class PoisonedWorkEnvSection extends SOCSection{
	public PoisonedWorkEnvSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.POISONED);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Poisoned Work Environment");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that it is an implied term of [HIS/HER] employment agreement that [HE/SHE] be treated with civility, decency, respect, and dignity. In this case, [EMPLOYER’S] conduct has breached this implied term and created an poisoned working environment for [PLAINTIFF]. ");
		content.add(text);

        this.setContents(content);
	}
}