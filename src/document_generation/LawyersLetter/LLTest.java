package document_generation.LawyersLetter;

import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.util.CloseDocument;
import document_generation.util.ManipDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * Created by Yale Wang
 */
public class LLTest {

    public static void main(String[] args){
        LLSectionFactory llsf = new LLSectionFactory();
        LLDocument doc = new LLDocument();
        LLSection open = llsf.getSection(doc, SectionCode.OPENING);

        if(open.equals(null) || open.getContents().isEmpty()){
            //something went wrong
        }

        for(LLParagraph p : open.getContents()){

            for(String s : p.getText().split("%%")){
                System.out.println(p.getParaType()+ " : " + s);
                XWPFRun r = ManipDocument.createRun(p.getXwpfParagraph());
                ManipDocument.append(r,1, s);
            }
        }
        CloseDocument.closeSimple(doc, "LLTest.docx");
    }

}
