/*
### Created by Yale Wang ###

Initial document creation syntax
Sandbox for document manipulation
 */
package document_generation.util;

import java.io.*;
import java.lang.management.ManagementPermission;
import java.math.BigInteger;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;

public class BlankDocument {

    private String path = "/Users/monkhousemacbook6/Documents/JavaCreatedFiles/";

    public static XWPFDocument createDocument() {

        XWPFDocument document = new XWPFDocument();
        return document;
    }

    public XWPFDocument createDocument(String fileName) {

        fileName = path + fileName;
        XWPFDocument document = BlankDocument.createDocument();

        try {

            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(new File(fileName));
            document.write(out);
            out.close();
            System.out.println(fileName + " created successully");
        } catch (FileNotFoundException e) {

            System.err.println("Creation of: " + fileName + " failed, \'file not found\'");
            e.printStackTrace();
        } catch (IOException e) {

            System.err.println("Creation of: " + fileName + " failed, \'IO error\'");
            e.printStackTrace();
        }
        return document;
    }

    public static BigInteger addListStyle(CTAbstractNum abstractNum, XWPFDocument doc, XWPFNumbering numbering) {
        try {

            XWPFAbstractNum abs = new XWPFAbstractNum(abstractNum, numbering);
            BigInteger id = BigInteger.valueOf(0);
            boolean found = false;
            while (!found) {
                Object o = numbering.getAbstractNum(id);
                found = (o == null);
                if (!found)
                    id = id.add(BigInteger.ONE);
            }
            abs.getAbstractNum().setAbstractNumId(id);
            id = numbering.addAbstractNum(abs);
            return doc.getNumbering().addNum(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void extractParagraphs() {

        try {
            FileInputStream fis = new FileInputStream("/Users/monkhousemacbook6/Documents/lawyerlettercopy.docx");
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            List<XWPFParagraph> paragraphList = xdoc.getParagraphs();
            for (XWPFParagraph paragraph : paragraphList) {
                System.out.println(paragraph.getText());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {

        XWPFDocument doc = new XWPFDocument();

        InputStream in = null;
        XWPFParagraph p = doc.createParagraph();
        CTAbstractNum abstractNum = null;

        try {
            in = BlankDocument.class.getResourceAsStream("numbering.xml");
            abstractNum = CTAbstractNum.Factory.parse(in);
        } catch (XmlException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //p.setStyle("ListParagraph");
        //p.setNumID(BigInteger.valueOf(1));

        XWPFNumbering numbering=null;
        numbering=doc.createNumbering();
        p.setVerticalAlignment(TextAlignment.CENTER);
        p.setNumID(addListStyle(abstractNum, doc, numbering));

        XWPFRun r = ManipDocument.createRun(p);
        ManipDocument.append(r, 1, "aaa");


        numbering=doc.createNumbering();
        p.setVerticalAlignment(TextAlignment.CENTER);
        p.setNumID(addListStyle(abstractNum, doc, numbering));
        r = ManipDocument.createRun(p);
        ManipDocument.append(r, 1, "bbb");


        numbering=doc.createNumbering();
        p.setVerticalAlignment(TextAlignment.CENTER);
        p.setNumID(addListStyle(abstractNum, doc, numbering));
        r = ManipDocument.createRun(p);
        ManipDocument.append(r, 1, "ccc");

        r.addCarriageReturn();

        CloseDocument.closeSimple(doc, "list_test_doc.docx");


    }
}