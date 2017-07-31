package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class HumanRightsSection extends SOCSection{
	public HumanRightsSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.HUMAN_RIGHTS);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Human Rights");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("In the absence of any legitimate reason for the termination of his employment, [PLAINTIFF] pleads that [HIS/HER] [GROUND FOR DISCRIMINATION] played a significant factor in [EMPLOYER’S] decision to terminate [HIM/HER]. Discrimination on the basis of [GROUND FOR DISCRIMINATION] is contrary to the provisions of the [APPROPRIATE HUMAN RIGHTS LEGISLATION] for which an award of damages for injury to dignity, feelings and self respect are rightfully owed."
				+ "%%"
				+ "%%[insert factual circumstances relating to allegations of discrimination]"
				+ "%%"
				+ "%%[PLAINTIFF] suggests that an appropriate amount should be allocated in respect to a claim for human rights violations. "
				+ "%%"
				+ "%%[if necessary] [PLAINTIFF] Pleads that [HE/SHE] will particularize the claim relating to human rights within 30 days of receiving the Affidavit of Documents form the Defendant, if requested, since only at that time would there be adequate documentation to detail the claim. "
				+ "%%"
				+ "%%[PLAINTIFF] requests the Court to consider an award of back pay with the option of reinstatement as well as a lump sum payment regarding a human rights claim. ");
		content.add(text);

        this.setContents(content);
	}
}
