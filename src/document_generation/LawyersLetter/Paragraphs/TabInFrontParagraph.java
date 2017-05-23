package document_generation.LawyersLetter.Paragraphs;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.LLParagraph;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Created by Yale Wang
 */
public class TabInFrontParagraph extends LLParagraph {

    public TabInFrontParagraph(XWPFDocument doc){
        super(doc);
        this.setParaType(ParaCode.TAB);
    }
}
