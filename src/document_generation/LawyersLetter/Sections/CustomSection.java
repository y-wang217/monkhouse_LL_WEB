package document_generation.LawyersLetter.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

/**
 * Created by Yale Wang
 */
public class CustomSection extends LLSection {
    public CustomSection(LLDocument doc, LLParagraphFactory llpf){
        this.setSectionCode(LLSectionCode.CUSTOM);
        ArrayList<LLParagraph> empty = new ArrayList<>();
        empty.add(new LLParagraph(ParaCode.EMPTY));
        this.setContents(empty);
    }
}
