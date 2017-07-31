package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class BonusesAndOtherBenefitsSection extends SOCSection{
	public BonusesAndOtherBenefitsSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.BONUSES_OTHERS);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Bonuses and Other Benefits");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that as part of [HIS/HER] employment agreement, [HE/SHE] is entitled to receive a bonus periodically throughout her employment. The bonus played an integral part of [PLAINTIFF’S] compensation package. "
				+ "%%"
				+ "%%[PLAINTIFF] pleads that [HE/SHE] is entitled to full compensation for his bonus and all employment related benefits, including but not limited to medical benefits, life insurance, and disability benefits throughout the entirety of the notice period as [HE/SHE] would have received these entitlements had [EMPLOYER] not breached the employment agreement.  ");
		content.add(text);

        this.setContents(content);
	}
}
