package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class WrongfulDismissalSection extends SOCSection{
	public WrongfulDismissalSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.WRONGFUL);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Wrongful Dismissal");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("In light of [PLAINTIFF]'s position, the specialized nature of [HIS/HER] position, length of service, age, the current state of the economy, and the consequential scarcity of comparable employment in the marketplace, [PLAINTIFF] is entitled to a period of reasonable notice of the termination of [HIS/HER] employment of not less than [MONTHS OF NOTICE] months’ pay in lieu of notice, or the sum of approximately [MONETARY AMOUNT OF NOTICE]. "
				+ "%%"
				+ "%%Since [HIS/HER] termination from [EMPLOYER], [PLAINTIFF] has attempted to mitigate [HIS/HER] damages by seeking other reasonably comparable positions but has not had any success. Therefore, [PLAINTIFF] pleads that no amounts claimed should be reduced on account of any alleged failure to reasonably mitigate [HIS/HER] damages"
				+ "%%"
				+ "%%[PLAINTIFF] claims [HIS/HER] job search expenses and any relocation expenses that were incurred as special damages, the full particulars of which will be provided before trial. ");
		content.add(text);

        this.setContents(content);
	}
}

