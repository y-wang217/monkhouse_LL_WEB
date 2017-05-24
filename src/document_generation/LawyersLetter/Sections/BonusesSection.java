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
public class BonusesSection extends LLSection {

    public BonusesSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.BONUS);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Bonuses");

        //body:
        insertText(llpf,doc,content,ParaCode.REG, "It is my position that compensation for <client_first_name>'s " +
                "bonus ought to be included in <possessive_pronoun> reasonable notice period from Trailcon, regardless of whether " +
                "he is considered to be actively employed at the time it is paid out. This position is supported " +
                "in the case of Schumacher v. Toronto Dominion Bank, [1997] O.J. No. 2004, wherein the Court " +
                "determined that the Plaintiff’s involuntariness to comply with the requirement to be actively " +
                "employed did not release the Bank from its obligation to pay the bonus, and the Plaintiff was " +
                "awarded <possessive_pronoun> bonus for the time he worked, as well as throughout the notice period. %%" +
                "%%" +
                "More recently, the same principle was upheld in the Court of Appeal Case of Paquette v. " +
                "TeraGo Networks Inc. 2016 ONCA 618 (CanLII): ");
        insertText(llpf,doc,content,ParaCode.QUOTE, "In the present case, as in Taggart, Schumacher " +
                "and Bernier, the requirement for active employment does not prevent the appellant from receiving " +
                "as part of <possessive_pronoun> wrongful dismissal damages, compensation for the bonuses he would have received " +
                "had <possessive_pronoun> employment continued during the period of reasonable notice. ");

        this.setContents(content);
    }

}
