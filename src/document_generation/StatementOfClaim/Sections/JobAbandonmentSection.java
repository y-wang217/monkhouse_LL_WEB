package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class JobAbandonmentSection extends SOCSection{
	public JobAbandonmentSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.ABANDONMENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Job Abandonment");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[PLAINTiFF] pleads that [HE/SHE] did not abandon [HIS/HER] position. On multiple occasions, the Plaintiff attempted to contact [EMPLOYER] regarding the status of [HIS/HER] employment and to return to work. "
				+ "%%"
				+ "%%The Plaintiff pleads that an employer has the duty to investigate the reasons behind an employee’s absence and not to immediately conclude that the employee abandoned his/her position. [PLAINTIFF] pleads that [EMPLOYER] did not fulfill their duty in this case prior to alleging job abandonment and terminated [HIM/HER] for cause. ");
		content.add(text);

        this.setContents(content);
	}
}
