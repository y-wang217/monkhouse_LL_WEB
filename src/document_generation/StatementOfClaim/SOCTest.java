package document_generation.StatementOfClaim;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;
import document_generation.util.CloseDocument;

public class SOCTest {
	public static void main(String[] args){
        SOCSectionFactory llsf = new SOCSectionFactory();
        SOCDocument_copy doc = new SOCDocument_copy();
        
        
        //
        //
        //
        
        
        LinkedHashMap<String, String> testMap = doc.getFieldsMap();
        testMap.put("dollarsNoticeOwed", "10000");
        testMap.put("dollarsBenefitsOwed", "10000");
        testMap.put("dollarsDamagesOwed", "10000");
        testMap.put("dollarsTotalOwed", "100000");
        testMap.put("wage_in_dollars", "100000");
        doc.setFieldsMap(testMap);
        ArrayList<SOCSection> s_arr = new ArrayList<>();
        SOCSection s1 = llsf.getSection(doc, SOCSectionCode.START_TEST);
        s_arr.add(s1);
        SOCSection s2 = llsf.getSection(doc, SOCSectionCode.PARTIES);
        s_arr.add(s2);
        SOCSection s3 = llsf.getSection(doc, SOCSectionCode.BACKGROUND);
        s_arr.add(s3);
        SOCSection s4 = llsf.getSection(doc, SOCSectionCode.CONSTRUCTIVE);
        s_arr.add(s4);
        SOCSection s5 = llsf.getSection(doc, SOCSectionCode.TERMINATION);
        s_arr.add(s5);
        SOCSection s6 = llsf.getSection(doc, SOCSectionCode.FIGHTING_TERM);
        s_arr.add(s6);
        
        for(SOCSection s : s_arr){
            doc.writeToDoc(s);
        }
        
        CloseDocument.closeSimple(doc, "SOCTest.docx");
    }
}
