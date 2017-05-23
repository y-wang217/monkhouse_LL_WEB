package document_generation.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Created by Yale Wang
 */
public class GenericParagraphFactory {
    XWPFParagraph p;

    XWPFParagraph createParagraph(XWPFDocument doc, String code){

        XWPFParagraph p = doc.createParagraph();

        switch (code){
            case "AAA":
                break;
            case "BBB":
                break;
            case "CCC":
                break;
            case "DDD":
                break;

        }

        return p;
    }
}
