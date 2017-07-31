package document_generation.StatementOfClaim;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class SOCSection extends LLSection{

	private SOCSectionCode sectionCode;
	private ArrayList<LLParagraph> contents;
	
	public SOCSectionCode getSectionCodeSOC() {

		return this.sectionCode;
	}
	public void setSectionCode(SOCSectionCode sectionCode) {

		this.sectionCode = sectionCode;
	}
}
