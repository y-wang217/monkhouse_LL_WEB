package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class OHSA168Section extends SOCSection{
	public OHSA168Section(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.OHSA);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Harassment");
		content.add(header);
		
		LLParagraph header2 = llpf.getParagraph(doc, ParaCode.HEAD);
		header2.setText("OHSA/Bill 168");
		content.add(header2);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that she was subjected to harassment in the workplace, contrary to the Occupational Health and Safety Act and “Bill 168”.  "
				+ "%%"
				+ "%%[facts about the harassment] "
				+ "%%"
				+ "%%[PLAINTIFF] pleads that [EMPLOYER] failed to ensure a safe and harassment-free workplace environment and condoned the harassment through their failure. ");
		content.add(text);

        this.setContents(content);
	}
}
