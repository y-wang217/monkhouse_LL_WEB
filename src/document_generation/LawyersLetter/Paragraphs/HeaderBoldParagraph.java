package document_generation.LawyersLetter.Paragraphs;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.Codes.ParaCode;

public class HeaderBoldParagraph extends LLParagraph{

	public HeaderBoldParagraph(XWPFDocument doc){
        super(doc);
        this.setParaType(ParaCode.HEAD_B);
    }
}
