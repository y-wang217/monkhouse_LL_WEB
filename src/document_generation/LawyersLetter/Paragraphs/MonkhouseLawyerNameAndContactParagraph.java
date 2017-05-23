package document_generation.LawyersLetter.Paragraphs;

import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.Codes.ParaCode;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Created by Yale Wang
 */
public class MonkhouseLawyerNameAndContactParagraph extends LLParagraph{
    private String name;
    private String email;

    public MonkhouseLawyerNameAndContactParagraph(XWPFDocument doc){
        super(doc);
        this.setParaType(ParaCode.MHLNC);
        this.setBold(true);
        XWPFParagraph p = this.getXwpfParagraph();
        p.setAlignment(ParagraphAlignment.RIGHT);
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getName() {


        return name;
    }

    public String getEmail() {

        return email;
    }
}
