package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.util.ArrayList;

/**
 * Created by Yale Wang
 */
public class ReCaseSection extends LLSection{
    public ReCaseSection(LLDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(SectionCode.RE);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        LLParagraph heading = llpf.getParagraph(doc,ParaCode.HEAD);
        heading.setText("RE: Termination of <client_first_name> <client_last_name>");
        content.add(heading);

        //i wish to confirm etc.
        LLParagraph body = llpf.getParagraph(doc,ParaCode.REG);
        body.setText("I wish to confirm that I have been retained as legal counsel on behalf of " +
                "<client_first_name> <client_last_name> (“<client_first_name>”). I have reviewed the circumstances " +
                "surrounding <client_first_name>’s termination, and it is my position that <subjective_pronoun> has been wrongfully " +
                "dismissed in that <subjective_pronoun> was terminated without sufficient cause, and as such is entitled to reasonable " +
                "pay in lieu of notice of the termination of <possessive_pronoun> employment. ");
        content.add(body);

        //the salient factors...
        LLParagraph factorsIntro = llpf.getParagraph(doc,ParaCode.HEAD);
        factorsIntro.getXwpfParagraph().setAlignment(ParagraphAlignment.LEFT);
        factorsIntro.setText("The salient factors of this case are:");
        content.add(factorsIntro);

        //factors list
        LLParagraph factorsList = llpf.getParagraph(doc,ParaCode.TAB);
        factorsList.getXwpfParagraph().setAlignment(ParagraphAlignment.LEFT);
        factorsList.setText("Seniority: <seniority_in_years> years%%" +
                "Wage: $<wage_in_dollars>%%" +
                "Age: <age>%%" +
                "Position: <position>");
        content.add(factorsList);

        this.setContents(content);
    }

}
