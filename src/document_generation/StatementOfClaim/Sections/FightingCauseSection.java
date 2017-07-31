package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class FightingCauseSection extends SOCSection{
	public FightingCauseSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.FIGHTING_CAUSE);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Fighting Cause");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("[contextual information about allegations of cause – harassment, poor performance, absenteeism, etc]"
				+ "%%"
				+ "%%[PLAINTIFF] pleads that [EMPLOYER] has not satisfied the strict legal tests in place that an employer must satisfy in order to terminate an employee for just cause. Furthermore, [PLAINTIFF] pleads that [EMPLOYER] did not conduct an adequate investigation into any allegations pertaining to the reasons for [HIS/HER] termination. [PLAINTIFF] pleads that insufficient disciplinary action was taken prior to the decision to terminate. ");
		content.add(text);

        this.setContents(content);
	}
}
