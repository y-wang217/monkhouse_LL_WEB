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
public class AddresseeSection extends LLSection {
    public AddresseeSection(LLDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(LLSectionCode.ADDRESSEE);

        ArrayList<LLParagraph> content = new ArrayList<>();

        LLParagraph addressee = llpf.getParagraph(doc, ParaCode.REG);
        //the first line  is supposed to be bold, but the rest should be not-bold
        
        this.setSql(this.getSectionCode().toString());
        HashMap<String, String>contents = dao.executeSelectParagraphText(this.getSelectSql());
        
        addressee.setText(contents.get("1"));
        content.add(addressee);

        this.setContents(content);

    }

}
