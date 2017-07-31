package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class RemovalFromManagementSection extends SOCSection{
	public RemovalFromManagementSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.REMOVAL_MANAGEMENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Removal from Management Position");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTIFF] pleads that [HIS/HER] employment agreement with [EMPLOYER] was unilaterally altered due to [HIS/HER] removal from a position of seniority. "
				+ "%%"
				+ "%%As a result of [EMPLOYER’S] conduct, [PLAINTIFF] pleads that [HE/SHE] has been constructively dismissed. [Summing up reasons for allegation of constructive dismissal]."
				+ "%%"
				+ "%%[PLAINTIFF] pleads that [EMPLOYER’S] conduct has resulted in a breach of the employment agreement and that [HIS/HER] employment has been effectively terminated. As such, [PLAINTIFF] pleads that [HE/SHE] is entitled to reasonable notice for the termination of [HIS/HER] employment."
				+ "%%"
				+ "%%[if applicable] In the alternative, if the Court were to find that [PLAINTIFF] has not been constructively dismissed, [PLAINTIFF] pleads that her contract has been frustrated because the duties can no longer be fulfilled due to medical reasons. As such, at the very least, "
				+ "%%"
				+ "%%[PLAINTIFF] is owed her minimum entitlements in termination notice and severance pay under the Employment Standards Act, 2000, that being [NUMBER OF WEEKS] weeks. ");
		content.add(text);

        this.setContents(content);
	}
}
