package document_generation.LawyersLetter.Sections;

import java.util.ArrayList;

import document_generation.TextUI;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.util.CloseDocument;
import document_generation.util.ManipDocument;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Created by Yale Wang
 */
public class HeaderImageSection extends LLSection{

    private String headerImgFilePath = "/Users/monkhousemacbook6/Pictures/monkhouse_header.png";
    public HeaderImageSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(LLSectionCode.IMG);

        ArrayList<LLParagraph> content = new ArrayList<>();
        insertText(llpf,doc,content, ParaCode.IMAGE,"/Users/monkhousemacbook6/Pictures/monkhouse_header.png");
        this.setContents(content);

        //ManipDocument.addImage(doc, headerImgFilePath);

    }
}
