package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class PunitiveDamagesHarassmentSection extends SOCSection{
	public PunitiveDamagesHarassmentSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.PUNITIVE_HARASSMENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Punitive Damages - Harassment");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("Furthermore, the harassment experienced by [PLAINTIFF] while employed with [EMPLOYER] is grounds for punitive, aggravated, and/or moral damages."
				+ "%%"
				+ "%%[PLAINTIFF] pleads that [EMPLOYER’S] failure to maintaining a safe environment effectively condoned the harassment in the workplace and is liable for significant punitive, aggravated, and/or moral damages. ");
		content.add(text);

        this.setContents(content);
	}
}
