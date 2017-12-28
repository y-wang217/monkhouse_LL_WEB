package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.util.ArrayList;

/**
 * Created by Yale Wang
 */
public class OpeningSection extends LLSection {
    public OpeningSection(LLDocument doc, LLParagraphFactory llpf){
        this.setSectionCode(LLSectionCode.OPENING);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //Date:
        insertText(llpf,doc,content,ParaCode.REG,"Date: ");

        //Monkhouse Lawyer name and email
        insertText(llpf,doc,content,ParaCode.MHLNC,"<monkhouse_lawyer_name>%%" +
                                                        "<monkhouse_lawyer_email>");

        LLParagraph disclaimer = llpf.getParagraph(doc, ParaCode.HEAD);
        disclaimer.setText("Personal, Confidential & Without Prejudice");
        disclaimer.setUnderline(true);
        content.add(disclaimer);

        if(!doc.getFieldsMap().containsKey("isDraft")){
        	doc.getFieldsMap().put("isDraft", "true");
        }
        if(doc.getFieldsMap().get("isDraft").equals("true")){
            insertText(llpf,doc,content,ParaCode.HEAD,"Via Email");
            
        }else{
            insertText(llpf,doc,content,ParaCode.HEAD,"Via Personal Service");
            
        }


        this.setContents(content);
    }
}
