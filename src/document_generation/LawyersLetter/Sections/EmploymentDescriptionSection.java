package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;

/**
 * Created by Yale Wang
 */
public class EmploymentDescriptionSection extends LLSection {
    public EmploymentDescriptionSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.EMP_DESC);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content,ParaCode.HEAD,"<client_first_name>'s Employment");

        //body:
        insertText(llpf,doc,content,ParaCode.REG, "<client_first_name> began <possessive_pronoun> employment with " +
                "<employer_first_name> (“<employer_first_name> ”) by way of written offer of employment/employment " +
                "contract/verbal agreement approximately TIME <seniority_in_years> years ago where <subjective_pronoun> started out as … . " +
                "<employer_first_name> was promoted to <client_position> and continued in this capacity until <possessive_pronoun> termination on " +
                "<termination_date>.%%" +
                "At the time of <possessive_pronoun> termination, <client_first_name> was earning approximately $<wage> per year and was " +
                "<age> years of age. Throughout <possessive_pronoun> employment, <client_first_name> was a dedicated and hard-working " +
                "employee as demonstrated by <possessive_pronoun> lengthy tenure.");

        this.setContents(content);
    }
}
