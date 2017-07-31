package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class GrossIncompetenceSection extends SOCSection{
	public GrossIncompetenceSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.GROSS);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Gross Incompetence");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that [HE/SHE] performed well in [HIS/HER] position and was not aware that [HIS/HER] performance was a significant issue while employed with [EMPLOYER]. The Plaintiff pleads that if [HIS/HER] performance was an issue, [EMPLOYER] ought to have provided [HIM/HER] with additional training and/or coaching prior to terminating [HIM/HER] for cause. ");
		content.add(text);

        this.setContents(content);
	}
}
