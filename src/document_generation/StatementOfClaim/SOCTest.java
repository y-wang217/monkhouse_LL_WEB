package document_generation.StatementOfClaim;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;

public class SOCTest {
	SOCSectionFactory llsf = new SOCSectionFactory();
	SOCDocument_copy doc = new SOCDocument_copy();

	String fileName = "";
	InputStream in = null;
	CTAbstractNum abstractNum = null;

	public String createDocument(String fileName, String content) {
		this.fileName = fileName;
		XWPFDocument doc = new XWPFDocument();

		doc.createNumbering();
		XWPFNumbering numbering = null;
		numbering = doc.createNumbering();
		for (String value : content.split("@")) {
			XWPFParagraph para = doc.createParagraph();
			para.setVerticalAlignment(TextAlignment.CENTER);
			para.setNumID(addListStyle(abstractNum, doc, numbering));
			XWPFRun run = para.createRun();
			run.setText(value);
		}
		try {
			FileOutputStream out = new FileOutputStream(fileName);
			doc.write(out);
			out.close();
			in.close();
		} catch (Exception e) {
		}
		return null;
	}

	private BigInteger addListStyle(CTAbstractNum abstractNum,
			XWPFDocument doc, XWPFNumbering numbering) {
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

	public static void main(String[] args) throws Exception {
		String fileName = "Test.docx";
		new SOCTest().createDocument(fileName,
				"First Level@@Second Level@@Second Level@@First Level");
	}
}
