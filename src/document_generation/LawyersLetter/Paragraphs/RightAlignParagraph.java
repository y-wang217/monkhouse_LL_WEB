package document_generation.LawyersLetter.Paragraphs;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.Codes.ParaCode;

public class RightAlignParagraph extends LLParagraph {

    public RightAlignParagraph(XWPFDocument doc) {

        super(doc);
        this.setParaType(ParaCode.RIGHT);
        XWPFParagraph p = this.getXwpfParagraph();
        p.setAlignment(ParagraphAlignment.RIGHT);
    }
}
