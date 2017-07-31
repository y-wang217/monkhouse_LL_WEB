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
public class ClosingSection extends LLSection{

    public ClosingSection(LLDocument doc, LLParagraphFactory llpf){
        this.setSectionCode(LLSectionCode.CLOSE);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //Date:
        //insertText(llpf,doc,content, ParaCode.IMAGE,"/Users/monkhousemacbook6/Pictures/miguel_signature.png");

        //Closing sign-off
        insertText(llpf,doc,content,ParaCode.REG,"");
        
        insertText(llpf,doc,content,ParaCode.REG,"Sincerely,");

        insertText(llpf,doc,content,ParaCode.HEAD,"Monkhouse Law");
        insertText(llpf,doc,content,ParaCode.REG,"");
        insertText(llpf,doc,content,ParaCode.REG,"");

        insertText(llpf,doc,content,ParaCode.REG,"<monkhouse_lawyer_name>%%"
        		+ "<monkhouse_lawyer_position>");

        insertText(llpf,doc,content,ParaCode.REG,"<monkhouse_lawyer>/<monkhouse_paralegal>");


        this.setContents(content);
    }
}
