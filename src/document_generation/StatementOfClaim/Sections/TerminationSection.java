package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class TerminationSection extends SOCSection{
	public TerminationSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.TERMINATION);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Termination");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[no real default language here; this should be entirely context based and rewritten on a case-by-case basis.]"
				+ "%%"
				+ "%%[if applicable] As [PLAINTIFF] was terminated without cause, [HE/SHE] would be entitled to notice for the termination of [HIS/HER] employment.");
		content.add(text);

        this.setContents(content);
	}
}
