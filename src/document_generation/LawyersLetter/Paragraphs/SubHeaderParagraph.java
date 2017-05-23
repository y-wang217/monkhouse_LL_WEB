package document_generation.LawyersLetter.Paragraphs;

import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.Codes.ParaCode;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Created by Yale Wang
 */
public class SubHeaderParagraph extends LLParagraph {

    public SubHeaderParagraph(XWPFDocument doc){
        super(doc);
        this.setParaType(ParaCode.SUBHEAD);
        this.setItalics(true);

    }

}
