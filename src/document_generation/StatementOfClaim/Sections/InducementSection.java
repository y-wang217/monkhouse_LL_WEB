package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class InducementSection extends SOCSection{
	public InducementSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.INDUCEMENT);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Inducement");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("Prior to [HIS/HER] employment with [DEFENDANT], [PLAINTIFF] was employed with [PREVIOUS EMPLOYER] for [PREVIOUS TENURE]. [PLAINTIFF] pleads that [HE/SHE] was induced by the Defendant to leave [HIS/HER] previous company and join the Defendant. "
				+ "%%"
				+ "%%[information how inducement happened – long recruitment process, promises of long employment, etc]"
				+ "%%"
				+ "%%[PLAINTIFF] pleads that as [HE/SHE] was induced to leave a prior position for the Defendant company, the tenure accrued at the prior position must be considered in any assessment of a reasonable notice period. ");
		content.add(text);

        this.setContents(content);
	}
}

