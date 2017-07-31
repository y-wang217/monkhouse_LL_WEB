package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class OntarioOvertime extends SOCSection{
	public OntarioOvertime(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.ONT_OVERTIME);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Ontario Overtime");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that throughout [HIS/HER] employment with [EMPLOYER], [HE/SHE] regularly worked over forty-four (44) hours per week which was unpaid by [EMPLOYER]."
				+ "%%"
				+ "%%[PLAINTIFF] pleads that in total, [HE/SHE] worked [NUMBER OF HOURS] hours of overtime during her tenure with [EMPLOYER]. [PLAINTIFF] pleads that [HE/SHE] is entitled to overtime pay at 1.5 rate, for a total of [OVERTIME CLAIMED DOLLAR AMOUNT]. "
				+ "%%"
				+ "%%In the alternative, [PLAINTIFF] pleads that [HE/SHE] would be entitled to ‘straight time’ for the hours of overtime worked, in accordance with the principle of quantum meruit for a total sum of [DOLLAR AMOUNT]. "
				+ "%%"
				+ "%%[if applicable] [PLAINTIFF] further pleads that [HE/SHE] would not be barred from bringing a claim for unpaid overtime due to a limitation period restriction as the date would begin to run from the date of discovery of the claim. ");
		content.add(text);

        this.setContents(content);
	}
}
