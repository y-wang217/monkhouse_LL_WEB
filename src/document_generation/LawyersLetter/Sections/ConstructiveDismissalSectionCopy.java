package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Yale Wang
 */
public class ConstructiveDismissalSectionCopy extends LLSection{

    public ConstructiveDismissalSectionCopy(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(LLSectionCode.CONSTRUCTIVE_DISMISSAL);

        ArrayList<LLParagraph> content = new ArrayList<>();

        //SQL RETRIEVAL
        this.setSql(this.getSectionCode().toString());
        HashMap<String, String>contents = dao.executeSelect(this.getSelectSql());
        
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,contents.get("1"));

        insertText(llpf,doc,content, ParaCode.REG,contents.get("2"));


        //TODO keep flag in doc to track which paragraph is needed
        if(doc.getFieldsMap().get("setAllParagraphs").equals("true") || Objects.equals( doc.getFieldsMap().get("isUseWageDeduction"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("3"));
            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("4"));

        }
        if(doc.getFieldsMap().get("setAllParagraphs").equals("true") || Objects.equals(doc.getFieldsMap().get("isUseLocation"), "on")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("5"));
            //body
            insertText(llpf,doc,content, ParaCode.REG,contents.get("6"));
            
        }
        if(doc.getFieldsMap().get("setAllParagraphs").equals("true") || Objects.equals(doc.getFieldsMap().get("isUseBreachOfFundamentalImpliedTerm"), "on")){

            //heading:

            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("7"));
            //body
            insertText(llpf,doc,content, ParaCode.REG,contents.get("8"));
            
        }
        if(doc.getFieldsMap().get("setAllParagraphs").equals("true") || Objects.equals(doc.getFieldsMap().get("isUseIntolerable"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("9"));
            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("10"));
            insertText(llpf,doc,content, ParaCode.QUOTE,contents.get("11"));
            insertText(llpf,doc,content, ParaCode.REG,contents.get("12"));
            
        }
        if(doc.getFieldsMap().get("setAllParagraphs").equals("true") || Objects.equals(doc.getFieldsMap().get("isUseWorkplaceHarassmentPoisonedWorkEnvironment"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("13"));
            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("14"));
            insertText(llpf,doc,content, ParaCode.QUOTE,contents.get("15"));
            insertText(llpf,doc,content, ParaCode.REG,contents.get("16"));
        }
        if(doc.getFieldsMap().get("setAllParagraphs").equals("true") || Objects.equals(doc.getFieldsMap().get("isUseWorkplaceHarassmentPoisonedWorkEnvironment"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("17"));
            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("18"));
            insertText(llpf,doc,content, ParaCode.QUOTE,contents.get("19"));
            insertText(llpf,doc,content, ParaCode.REG,contents.get("20"));
        }
        if(doc.getFieldsMap().get("setAllParagraphs").equals("true") || Objects.equals(doc.getFieldsMap().get("isUseRemovalFromManagementPosition"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("21"));
            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("22"));

        }

        this.setContents(content);
    }

}
