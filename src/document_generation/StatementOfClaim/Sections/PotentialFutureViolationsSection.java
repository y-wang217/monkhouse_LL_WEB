package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class PotentialFutureViolationsSection extends SOCSection{
	public PotentialFutureViolationsSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.POT_VIOLATIONS);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Potential Future Violations");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("The Plaintiff pleads that the termination clause is unenforceable as it has the potential to provide less than is required by the Employment Standards Act, (2000) (“ESA”). Regardless of whether the Plaintiff’s actual purported entitlement pursuant to the clause is in accordance with the ESA, a clause that may potentially run afoul of the law is unenforceable");
		content.add(text);

        this.setContents(content);
	}
}
