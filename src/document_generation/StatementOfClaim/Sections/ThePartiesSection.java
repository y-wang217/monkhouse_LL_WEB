package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class ThePartiesSection extends SOCSection{
	public ThePartiesSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.PARTIES);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("The Parties");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("The Plaintiff, [PLAINTIFF], is an individual residing in [CITY/TOWN], in the Province of Ontario. At all material times, [PLAINTIFF] was an employee of the Defendant. [PLAINTIFF] is [AGE] years old ([BIRRTHDAY]). "
				+ "%%"
				+ "%%The Defendant, [EMPLOYER + DESCRIPTION]. [EMPLOYER] carries on business in the Province of Ontario. ");
		content.add(text);

        this.setContents(content);
	}
}
