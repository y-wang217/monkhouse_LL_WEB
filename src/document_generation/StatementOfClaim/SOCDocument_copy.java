package document_generation.StatementOfClaim;

import static document_generation.LawyersLetter.Codes.ParaCode.LIST;
import static document_generation.LawyersLetter.Codes.ParaCode.QUOTE;
import static document_generation.LawyersLetter.Codes.ParaCode.TAB;

import java.util.LinkedHashMap;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import document_generation.TextUI;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.LawyersLetter.LLSectionFactory;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.Sections.BackgroundSection;
import document_generation.StatementOfClaim.Sections.StatementOfClaimStartSection;
import document_generation.StatementOfClaim.Sections.ThePartiesSection;
import document_generation.util.ManipDocument;
import document_generation.util.Numbering;
import document_generation.util.message.ServletMessage;

public class SOCDocument_copy extends SOCDocument {

	public SOCDocument_copy() {
		super();
		initSOC();
	}

	public void initSOC() {
		SOCSectionFactory socsf = new SOCSectionFactory();
		this.setSocsf(socsf);
	}

	private LinkedHashMap<String, String> fieldsMap;
	private SOCSectionFactory socsf;
	private ServletMessage message;

	public void writeToDoc(SOCSection section) {
		for (LLParagraph p : section.getContents()) {
			if (p.getParaType().equals(ParaCode.EMPTY)) {
				break;
			}
			if (p.getParaType().equals(LIST)) {
				Thread listInsertThread = new Thread(() -> {
					Numbering.insertNumberedList(this,
							processFields(p.getText()));
				});
				listInsertThread.start();
				try {
					listInsertThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			for (String s : p.getText().split("%%")) {
				s = processFields(s);
				XWPFParagraph para = p.getXwpfParagraph();
				System.out.println(p.getParaType() + " : " + s);

				// handle paragraph alignment here instead of in section
//				if (p.getParaType().equals(ParaCode.RIGHT)|| p.getParaType().equals(ParaCode.RIGHT_B)) {
//					para.setAlignment(ParagraphAlignment.RIGHT);
//				}
//				if (p.getParaType().equals(ParaCode.CENTER) || p.getParaType().equals(ParaCode.CENTER_B)) {
//					para.setAlignment(ParagraphAlignment.CENTER);
//				}

				XWPFRun r = ManipDocument.createRun(para, "Arial");
				// handle italics
				if (s.indexOf('_') >= 0) {
					handleItalics(para, s, findItalics(s));
					break;
				}
				if (p.getParaType().equals(TAB))
					ManipDocument.tab(r);
				alterRun(r, p);
				if (p.getParaType().equals(QUOTE)) {
					if (!p.getText().substring(0, 2).equals("1."))
						r.setFontSize(10);
				}
				ManipDocument.append(r, 0, s);
			}
		}
	}

	public void writeDocFromFields() {
		TextUI.init(this);
		for (String key : fieldsMap.keySet()) {
			TextUI.addSectionToDoc(this, key);
		}
		// add ending sections:
		TextUI.addSectionToDoc(this, "manual_location_end");
		TextUI.addSectionToDoc(this, "manual_end");
	}

	public SOCSectionFactory getSocsf() {
		return this.socsf;
	}

	public void setSocsf(SOCSectionFactory socsf) {
		this.socsf = socsf;
	}

	public LinkedHashMap<String, String> getFieldsMap() {

		return fieldsMap;
	}

	public void setFieldsMap(LinkedHashMap<String, String> fieldsMap) {

		this.fieldsMap = fieldsMap;
	}
}
