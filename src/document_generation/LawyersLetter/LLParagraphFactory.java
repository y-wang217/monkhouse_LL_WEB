package document_generation.LawyersLetter;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Paragraphs.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Created by Yale Wang
 */
public class LLParagraphFactory {

    public LLParagraph getParagraph(XWPFDocument doc, ParaCode type){
        switch (type){
            case REG:
                return new LLParagraph(doc);
            case QUOTE:
                return new QuoteParagraph(doc);
            case LIST:
                return new ListParagraph(doc);
            case HEAD:
                return new HeaderParagraph(doc);
            case SUBHEAD:
                return new SubHeaderParagraph(doc);
            case IMAGE:
                return new ImageParagraph(doc);
            case MHLNC:
                return new MonkhouseLawyerNameAndContactParagraph(doc);
            case TAB:
                return new TabInFrontParagraph(doc);
            case QATMP:
                return new QATempMsgParagraph(doc);
            default:
                System.err.println("No code given for paragraph creation.");
                return new LLParagraph(doc);

        }
    }
}
