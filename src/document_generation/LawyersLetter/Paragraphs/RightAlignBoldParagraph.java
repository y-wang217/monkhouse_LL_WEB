package document_generation.LawyersLetter.Paragraphs;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class RightAlignBoldParagraph extends RightAlignParagraph{

	public RightAlignBoldParagraph(XWPFDocument doc) {
		super(doc);
		this.setBold(true);
	}
	 

}
