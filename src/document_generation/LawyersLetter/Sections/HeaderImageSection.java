package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.util.ManipDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Created by Yale Wang
 */
public class HeaderImageSection extends LLSection{

    private String headerImgFilePath = "/Users/monkhousemacbook6/Pictures/monkhouse_header.png";
    public HeaderImageSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.IMG);

        ManipDocument.addImage(doc, headerImgFilePath);

    }
}
