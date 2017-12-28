package document_generation.LawyersLetter.Paragraphs;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class CenterAlignBoldParagraph extends CenterAlignParagraph{

	public CenterAlignBoldParagraph(XWPFDocument doc) {
		super(doc);
		this.setBold(true);
	}

}
