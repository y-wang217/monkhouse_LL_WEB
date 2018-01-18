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
public class AppropriateNoticePeriodSectionCopy extends LLSection {

    public AppropriateNoticePeriodSectionCopy(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(LLSectionCode.APPROPRIATE_NOTICE_PERIOD);

        ArrayList<LLParagraph> content = new ArrayList<>();

        //SQL RETRIEVAL
        this.setSql(this.getSectionCode().toString());
        HashMap<String, String>contents = dao.executeSelectParagraphText(this.getSelectSql());
        
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,contents.get("1"));

        //body:
        insertText(llpf,doc,content,ParaCode.REG, contents.get("2"));
        insertText(llpf,doc,content,ParaCode.QUOTE, contents.get("3"));

        if(!doc.getFieldsMap().containsKey("age")){
        	doc.getFieldsMap().put("age", "40");
        }
        if(Integer.parseInt(doc.getFieldsMap().get("age"))>45 || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("4"));

            //body:
            insertText(llpf,doc,content,ParaCode.REG, contents.get("5"));
            insertText(llpf,doc,content,ParaCode.QUOTE, contents.get("6"));
            insertText(llpf,doc,content,ParaCode.REG, contents.get("7"));
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseNonSkilledPositions"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("8"));

            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("9"));
            insertText(llpf,doc,content, ParaCode.QUOTE,contents.get("10"));
            insertText(llpf,doc,content, ParaCode.QUOTE,contents.get("11"));
            
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseEconomicDownturn"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("12"));

            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("13"));
        }

        if(Objects.equals(doc.getFieldsMap().get("isFighting_cause"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("14"));

            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("15"));
        }

        boolean isExec = false;
        if (Objects.equals(doc.getFieldsMap().get("occupation_classification"), "Upper Management (>150k)")
        		|| Objects.equals(doc.getFieldsMap().get("occupation_classification"), "Middle Management (b/w 75k and 150k)")
				|| Objects.equals(doc.getFieldsMap().get("occupation_classification"), "Lower Management (<75k)")){
        	isExec = true;
        }
        if(!doc.getFieldsMap().containsKey("seniority_in_years")){
        	doc.getFieldsMap().put("seniority_in_years", "1");
        }
        if(Integer.parseInt(doc.getFieldsMap().get("seniority_in_years"))<5 && !isExec || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("16"));

            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("17"));
        }
//Use Short term Employees - Executives
        if(Integer.parseInt(doc.getFieldsMap().get("seniority_in_years"))<5 && isExec || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("18"));

            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("19"));
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseAppropriateNoticeConclusion"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("20"));

            //body:
            insertText(llpf,doc,content, ParaCode.REG,contents.get("21"));
        }//TODO: change xx to an equation

        if(Objects.equals(doc.getFieldsMap().get("isUseAppropriateNoticeAlternative"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("22"));

            //body:
            insertText(llpf,doc,content, ParaCode.HEAD,contents.get("23"));
        }
        this.setContents(content);
    }

}
