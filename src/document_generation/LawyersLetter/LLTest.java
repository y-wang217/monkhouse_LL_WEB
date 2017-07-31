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
        LLDocument doc = new LLDocument();
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
        testMap.put("contractor_vs_emp", "on");
        doc.setFieldsMap(testMap);
        LLSection s = llsf.getSection(doc, LLSectionCode.CONTRACTOR_VS_EMP);
        doc.writeToDoc(s);
        
        CloseDocument.closeSimple(doc, "LLTest.docx");
    }

}
