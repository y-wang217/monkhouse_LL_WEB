/*
### Created by Yale Wang ###

Writes all runs to disk
Saves any changes made

TODO choose when to close a document, instead of closing once at the end.
 */
package document_generation.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;
public class CloseDocument {

    private static String defaultFileName = "myLetterDocument.docx";

    public static void closeSimple(XWPFDocument doc, String fileName){

        try {

            FileOutputStream out = new FileOutputStream(new File(fileName));
            doc.write(out);
            out.close();
            System.out.println(fileName + " created successully");
        }catch(Exception e){

            System.err.println("Could not create file, " + fileName);
            e.printStackTrace();
        }
    }
    public static void closeSimple(XWPFDocument doc){

            closeSimple(doc, defaultFileName);
    }
}
