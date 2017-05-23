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
public class TerminationSection extends LLSection{

    public TerminationSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.TERMINATION);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Termination");

        //body:
        insertText(llpf,doc,content,ParaCode.REG, "<client_first_name> worked diligently throughout the course of " +
                "<possessive_pronoun> employment. Background leading to dismissal…%%" +
                "[Factual circumstances of dismissal]%%" +
                "As noted above, <client_first_name> did not have a written employment contract with <employer_first_name> which " +
                        "limited <possessive_pronoun> entitlements upon termination to the statutory minimums under the " +
                        "Employment Standards Acts, 2000, SO 2000, c. 41 (“ESA”). In the absence of such a clause, " +
                        "<client_first_name> would be entitled to a reasonable notice period under common law.");

        this.setContents(content);
    }
}
