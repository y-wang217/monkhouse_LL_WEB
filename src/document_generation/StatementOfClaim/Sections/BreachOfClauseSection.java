package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class BreachOfClauseSection extends SOCSection{
	public BreachOfClauseSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.ABoCDSR);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Alternatively, Breach of Clause Disallows Subsequent Reliance");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("The Plaintiff pleads that as the termination clause within [HIS/HER] employment agreement is unenforceable, [HE/SHE] is entitled to reasonable notice for the termination of [HIS/HER] employment pursuant to common law. "
				+ "%%"
				+ "%%In the alternative, the Defendant breached the termination clause [REASONS FOR POSSIBLE BREACH] and cannot rely on same to limit the liability of their breach. As such, [PLAINTIFF] would be entitled to common law reasonable notice for the termination of [HIS/HER] employment. ");
		content.add(text);

        this.setContents(content);
	}
}
