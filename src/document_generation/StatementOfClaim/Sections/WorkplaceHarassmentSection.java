package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class WorkplaceHarassmentSection extends SOCSection{
	public WorkplaceHarassmentSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.WORKPLACE_HARASSMENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Workplace Harassment");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("While working with [EMPLOYER], [PLAINTIFF] was subjected to harassment. The Plaintiff pleads that an employer owes a duty to treat employees fairly, decency, respect, and dignity. [EMPLOYER’S] conduct in this case breached this duty. ");
		content.add(text);

        this.setContents(content);
	}
}
