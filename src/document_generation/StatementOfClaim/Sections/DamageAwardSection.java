package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class DamageAwardSection extends SOCSection{
	public DamageAwardSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.DAMAGE_AWARD);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Damage Award");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that [EMPLOYER’S] decision to terminate [HIM/HER] was done so in an effort to avoid obligations to compensate the Plaintiff as required by law. The unsubstantiated allegations of cause have further made it increasingly difficult for [PLAINTIFF] to obtain new employment. As such, [PLAINTIFF] pleads that [EMPLOYER] is liable for punitive, aggravated, and/or moral damages for their improper allegation of cause. "
				+ "%%"
				+ "%%[PLAINTIFF] pleads that in the absence of sufficient cause for the termination of [HIS/HER] employment, [HE/SHE] is entitled to a reasonable notice period for the termination of [HIS/HER] employment.  ");
		content.add(text);

        this.setContents(content);
	}
}
