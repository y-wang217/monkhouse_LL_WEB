package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class CLCOvertimeSection extends SOCSection{
	public CLCOvertimeSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.CLC);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Overtime");
		content.add(header);
		
		LLParagraph header2 = llpf.getParagraph(doc, ParaCode.HEAD);
		header2.setText("CLC Overtime");
		content.add(header2);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that throughout [HIS/HER] employment with [EMPLOYER], [HE/SHE] regularly worked over forty (40) hours per week which was unpaid by [EMPLOYER].");
		content.add(text);

        this.setContents(content);
	}
}

