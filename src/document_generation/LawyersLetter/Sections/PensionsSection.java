package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;

/**
 * Created by Yale Wang
 */
public class PensionsSection extends LLSection {

    public PensionsSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(LLSectionCode.PENSION);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Defined Benefit Pension Grow-In");

        //body:
        insertText(llpf,doc,content,ParaCode.REG, "<client_first_name> was enrolled in the Defined Benefit Pension Plan of <employer_first_name>" +
                "As per section " +
                "74 of the _Pension Benefits Act_, R.S.O. 1990, Chapter P.8, he is entitled to <possessive_pronoun> pension grow-in " +
                "benefits given that the sum of <possessive_pronoun> age (<age> years old) and <seniority_in_years> years of service equal 55 points.  %%" +
                "%%" +
                "Therefore, as a result of being terminated without sufficient cause, <client_first_name> would be entitled " +
                "to a pension grow-in such that he would be eligible for his unreduced pension at the regular time.");

        insertText(llpf,doc,content,ParaCode.REG, "Please confirm if you agree that John is eligible for unreduced grow-in pension.");


        this.setContents(content);
    }

}
