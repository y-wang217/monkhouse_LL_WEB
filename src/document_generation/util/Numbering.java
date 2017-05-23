package document_generation.util;

import document_generation.LawyersLetter.LLDocument;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * Created by Yale Wang
 */
public class Numbering {

    public static void insertNumberedList(LLDocument doc, String content) {
        doc.createNumbering();
        for (String value : content.split("%%")) {
            XWPFParagraph para = doc.createParagraph();
            para.setNumID(doc.resetNumbering().addNum(BigInteger.ONE));

            XWPFRun run = para.createRun();
            run.setFontFamily("Times New Roman");

            setSingleLineSpacing(para);
            run.setText(value);
//            para.setIndentFromLeft(50);
        }

    }

    public static void setSingleLineSpacing(XWPFParagraph para) {

        CTPPr ppr = para.getCTP().getPPr();
        if (ppr == null) ppr = para.getCTP().addNewPPr();
        CTSpacing spacing = ppr.isSetSpacing() ? ppr.getSpacing() : ppr.addNewSpacing();
        spacing.setAfter(BigInteger.valueOf(0));
        spacing.setBefore(BigInteger.valueOf(0));
        spacing.setLineRule(STLineSpacingRule.AUTO);
        spacing.setLine(BigInteger.valueOf(240));
    }

    public static void main(String[] args) throws Exception {

        LLDocument doc = new LLDocument();
        new Numbering().insertNumberedList(doc, "First Level%%Second Level%%Second Level%%First Level%%five%%six%%seven%%eight");

        CloseDocument.closeSimple(doc, "numberingTest.docx");
    }
}