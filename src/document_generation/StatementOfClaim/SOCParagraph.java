package document_generation.StatementOfClaim;

import document_generation.LawyersLetter.LLParagraph;

public class SOCParagraph extends LLParagraph{

	private String alignment;
	
	public SOCParagraph(){
		super();
		this.setAlignment("left");
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
}
