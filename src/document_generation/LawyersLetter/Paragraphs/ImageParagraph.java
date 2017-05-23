package document_generation.LawyersLetter.Paragraphs;

import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.util.ManipDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * Created by Yale Wang
 */
public class ImageParagraph extends LLParagraph{

    public ImageParagraph(XWPFDocument doc){
        super(doc);
        this.setParaType(ParaCode.IMAGE);
        if(this.getImageFile()=="") this.setImageFile("/Users/monkhousemacbook6/Pictures/monkhouse_header.png");
        ManipDocument.addImage(doc, this.getImageFile());
    }
    public ImageParagraph(XWPFDocument doc, String imgFilePath){
        super(doc);
        this.setParaType(ParaCode.IMAGE);
        this.setImageFile(imgFilePath);
        ManipDocument.addImage(doc, this.getImageFile());
    }

    private String imageFile;

    public void setImageFile(String imageFile) {

        this.imageFile = imageFile;
    }

    public String getImageFile() {

        return imageFile;
    }
}
