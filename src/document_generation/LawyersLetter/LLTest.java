package document_generation.LawyersLetter;

import java.util.LinkedHashMap;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.util.CloseDocument;
import document_generation.util.ManipDocument;

/**
 * Created by Yale Wang
 */
public class LLTest {

    public static void main(String[] args){
        LLSectionFactory llsf = new LLSectionFactory();
        LLDocument_copy doc = new LLDocument_copy();
//        LLSection open = llsf.getSection(doc, SectionCode.OPENING);
//
//        if(open.equals(null) || open.getContents().isEmpty()){
//            //something went wrong
//        }
//
//        for(LLParagraph p : open.getContents()){
//
//            for(String s : p.getText().split("%%")){
//                System.out.println(p.getParaType()+ " : " + s);
//                XWPFRun r = ManipDocument.createRun(p.getXwpfParagraph());
//                ManipDocument.append(r,1, s);
//            }
//        }
//        
        LinkedHashMap<String, String> testMap = doc.getFieldsMap();
        testMap.put("dollarsNoticeOwed", "10000");
        testMap.put("dollarsBenefitsOwed", "10000");
        testMap.put("dollarsDamagesOwed", "10000");
        testMap.put("dollarsTotalOwed", "100000");
        doc.setFieldsMap(testMap);
        LLSection s = llsf.getSection(doc, LLSectionCode.NUM_TEST);
        doc.writeToDoc(s);
        
        CloseDocument.closeSimple(doc, "LLTest.docx");
    }

}
