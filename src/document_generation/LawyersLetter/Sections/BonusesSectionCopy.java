package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yale Wang
 */
public class BonusesSectionCopy extends LLSection {

    public BonusesSectionCopy(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(LLSectionCode.BONUS);

        ArrayList<LLParagraph> content = new ArrayList<>();

        //SQL RETRIEVAL
        this.setSql(this.getSectionCode().toString());
        HashMap<String, String>contents = dao.executeSelect(this.getSelectSql());
        
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,contents.get("1"));

        //body:
        insertText(llpf,doc,content, ParaCode.REG,contents.get("2"));
        insertText(llpf,doc,content, ParaCode.QUOTE,contents.get("3"));

        this.setContents(content);
    }

}
