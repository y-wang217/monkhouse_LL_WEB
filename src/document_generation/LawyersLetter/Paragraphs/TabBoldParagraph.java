package document_generation.LawyersLetter.Paragraphs;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.Codes.ParaCode;

public class TabBoldParagraph extends LLParagraph{

	public TabBoldParagraph(XWPFDocument doc){
        super(doc);
        this.setParaType(ParaCode.TAB_B);
    }
}
