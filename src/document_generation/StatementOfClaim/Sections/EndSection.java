package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class EndSection extends SOCSection {
	public EndSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.END);

		ArrayList<LLParagraph> content = new ArrayList<>();

		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("End Firm Name");
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("Date:");
		content.add(text);

		LLParagraph ending = llpf.getParagraph(doc, ParaCode.REG);
		ending.getXwpfParagraph().setIndentationLeft(30);
		ending.setText("Monkhouse Law" + "%%Barristers & Solicitors"
				+ "%%357 Bay Street, Suite 804" + "%%Toronto, Ontario, M5H 2T7"
				+ "%%" + "%%Andrew H. Monkhouse (64529L)"
				+ "%%andrew@monkhouselaw.com" + "%%" + "%%[ADDITIONAL LAWYERS]"
				+ "%%" + "%%Tel.:  416-644-8687" + "%%Fax:  888-501-7235"
				+ "%%" + "%%Lawyers for the Plaintiff [PLAINTIFF’S NAME]");
		content.add(ending);

		this.setContents(content);
	}
}
