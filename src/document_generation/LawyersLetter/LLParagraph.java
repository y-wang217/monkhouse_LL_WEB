package document_generation.LawyersLetter;

import document_generation.LawyersLetter.Codes.ParaCode;

import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;

import java.util.LinkedHashMap;


/**
 * Created by Yale Wang
 *
 * note text is separated into new lines via regex "%%"
 */
public class LLParagraph {

    public LLParagraph(XWPFDocument doc) {

        this();
        XWPFParagraph p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.BOTH);
        this.setXwpfParagraph(p);
    }

    public LLParagraph() {
        this.setText("");
        this.setParaType(ParaCode.REG);
        this.setBold(false);
    }
    
    public LLParagraph(ParaCode type) {

        this.setText("");
        this.setParaType(type);
        this.setBold(false);
    }

    private String text;
    private ParaCode paraType;
    private XWPFParagraph xwpfParagraph;
    private boolean blank;
    private boolean bold;
    private boolean underline;

    public boolean isUnderline() {

        return underline;
    }

    public void setUnderline(boolean underline) {

        this.underline = underline;
    }

    public boolean isBlank() {

        return blank;
    }

    public boolean isBold() {

        return bold;
    }

    public void setBlank(boolean italics) {

        this.blank = italics;
    }

    public void setBold(boolean bold) {

        this.bold = bold;
    }

    public String getText() {

        return text;
    }

    public void setText(String content) {

        this.text = content;

    }

    public ParaCode getParaType() {

        return paraType;
    }

    public void setParaType(ParaCode paraType) {

        this.paraType = paraType;
    }

    public XWPFParagraph getXwpfParagraph() {

        return xwpfParagraph;
    }

    public void setXwpfParagraph(XWPFParagraph p) {

        this.xwpfParagraph = p;
    }
}
