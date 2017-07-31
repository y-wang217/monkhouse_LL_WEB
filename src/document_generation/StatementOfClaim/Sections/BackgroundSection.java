package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class BackgroundSection extends SOCSection{
	public BackgroundSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.BACKGROUND);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Background");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[THE PLAINTIFF] began [HIS/HER] employment with [EMPLOYER] on [START DATE] pursuant to a [WRITTEN OR VERBAL AGREEMENT] and held the position of [POSITION]. [background information if required on position, promotions, etc]. "
				+ "%%"
				+ "%%In [HIS/HER] position, [PLAINTIFF] received a salary of approximately [COMPENSATION] per year [and if applicable, benefits, bonuses, etc]. "
				+ "%%"
				+ "%%Throughout [HIS/HER] employment, [PLAINTIFF] was a hard-working and dedicated employee. ");
		content.add(text);

        this.setContents(content);
	}
}
