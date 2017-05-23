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
public class InducementSection extends LLSection{

    public InducementSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.INDUCEMENT);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Inducement");

        //body:
        insertText(llpf,doc,content,ParaCode.REG, "Inducement is an aggravating factor that elongates " +
                "a notice period as the previous employment ought to be included in the calculation for tenure. " +
                "In Egan v. Alcatel Canada Inc., [2006] O.J. No. 34, the plaintiff left a position after twenty " +
                "years to commence employment with the defendant. The Court of Appeal held that the plaintiff was " +
                "entitled to an elongated notice period, taking into account the seniority she accrued from her " +
                "previous employment, as the plaintiff relied on the defendant’s promises of a substantial increase " +
                "in salary, a secure position, and “tremendous opportunities” in a company that planned on entering " +
                "new global markets. Magdy’s situation is similar, as he was promised a role with increased earnings, " +
                "an opportunity to move up through the company, and job security in an organization that supposedly " +
                "had a great future. \n");

        this.setContents(content);
    }

}
