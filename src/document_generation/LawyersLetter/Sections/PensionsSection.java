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
public class PensionsSection extends LLSection {

    public PensionsSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.PENSION);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Pensions");

        //body:
        insertText(llpf,doc,content,ParaCode.REG, "[CLIENT] was enrolled in Toyota’s Defined Benefit " +
                "Pension Plan under The Great-West Life Assurance Company (\"Great West Life\"). As per section " +
                "74 of the Pension Benefits Act, R.S.O. 1990, Chapter P.8, he is entitled to his pension grow-in " +
                "benefits given that the sum of his age (39 years old) and number of years to the date the Plan is " +
                "wound up (16) equal 55 points.  %%" +
                "%%" +
                "Therefore, as a result of being terminated without sufficient cause, [CLIENT] would be entitled " +
                "to a lump sum amount of the pension grow-in benefits he would have received till the retirement age " +
                "of sixty-five (65).\n");

        this.setContents(content);
    }

}
