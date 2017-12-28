package document_generation.StatementOfClaim;

import static document_generation.LawyersLetter.Codes.ParaCode.LIST;
import static document_generation.LawyersLetter.Codes.ParaCode.QUOTE;
import static document_generation.LawyersLetter.Codes.ParaCode.TAB;

import java.util.LinkedHashMap;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute.Space;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

import document_generation.TextUI;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;
import document_generation.util.ManipDocument;
import document_generation.util.Numbering;
import document_generation.util.message.ServletMessage;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class SOCDocument extends LLDocument {

	public SOCDocument() {
		super();
	}

	public void initSOCFields() {
		SOCSectionFactory socsf = new SOCSectionFactory();
		this.setSocsf(socsf);
		String plaintiffFirstName = this.getFieldsMap().get("client_first_name");
		String plaintiffLegalName = plaintiffFirstName+" "+this.getFieldsMap().get("client_last_name");
		this.getFieldsMap().put("plaintiff_legal_name", plaintiffLegalName.toUpperCase());

		String defendantFirstName = this.getFieldsMap().get("OC_HR_company_name");
		String defendantLegalName = defendantFirstName;
		this.getFieldsMap().put("defendant_legal_name", defendantLegalName.toUpperCase());
		
		String jurisdiction = this.getFieldsMap().get("jurisdiction");
		if(jurisdiction.equals("prov")){
			//set all the provincial legislation
			this.getFieldsMap().put("human_rights_legislation", "Human Rights Code, RSO 1990, c. H.19");
		}
		else{
			this.getFieldsMap().put("human_rights_legislation", "Canadian Human Rights Act (R.S.C., 1985, c. H-6)");
		}
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
				System.out.println(p.getParaType() + " : " + s);
				XWPFRun r = ManipDocument.createRun(p.getXwpfParagraph());

				if (p.getParaType().equals(ParaCode.SOC)) {
					XWPFParagraph para = this.createParagraph();
					// handle paragraph alignment here instead of in section
					if (p.getParaType().equals(ParaCode.RIGHT)) {
						para.setAlignment(ParagraphAlignment.RIGHT);
					}
					if (p.getParaType().equals(ParaCode.CENTER)) {
						para.setAlignment(ParagraphAlignment.CENTER);
					}
				}

				// handle italics
				if (s.indexOf('_') >= 0) {
					handleItalics(this.createParagraph(), s, findItalics(s));
					break;
				}
				if (p.getParaType().equals(TAB))
					ManipDocument.tab(r);
				alterRun(r, p);
				if (p.getParaType().equals(QUOTE)) {
					if (!p.getText().substring(0, 2).equals("1."))
						r.setFontSize(10);
				}
				ManipDocument.append(r, 1, s);
			}
		}
		if(section.getSectionCodeSOC().equals(SOCSectionCode.START)){
			XWPFRun r = this.createParagraph().createRun();
			r.addBreak(BreakType.PAGE);
			r.addBreak(BreakType.TEXT_WRAPPING);
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
		addPageFooters(this);
	}
	public void addPageFooters(XWPFDocument doc){
		// create footer
		XWPFHeaderFooterPolicy policy = doc.getHeaderFooterPolicy();
		if(policy == null){
			policy = new XWPFHeaderFooterPolicy(doc);
		}
		CTP ctpFooter = CTP.Factory.newInstance();

		XWPFParagraph[] parsFooter;

		// add style (s.th.)
		CTPPr ctppr = ctpFooter.addNewPPr();
		CTString pst = ctppr.addNewPStyle();
		pst.setVal("style21");
		CTJc ctjc = ctppr.addNewJc();
		ctjc.setVal(STJc.RIGHT);
		ctppr.addNewRPr();

		// Add in word "Page "   
		CTR ctr = ctpFooter.addNewR();
		CTText t = ctr.addNewT();
		t.setStringValue("Page ");
		t.setSpace(Space.PRESERVE);

		// add everything from the footerXXX.xml you need
		ctr = ctpFooter.addNewR();
		ctr.addNewRPr();
		CTFldChar fch = ctr.addNewFldChar();
		fch.setFldCharType(STFldCharType.BEGIN);

		ctr = ctpFooter.addNewR();
		ctr.addNewInstrText().setStringValue(" PAGE ");

		ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);

		ctpFooter.addNewR().addNewT().setStringValue("1");

		ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.END);

		XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, doc);

		parsFooter = new XWPFParagraph[1];

		parsFooter[0] = footerParagraph;

		policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
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
