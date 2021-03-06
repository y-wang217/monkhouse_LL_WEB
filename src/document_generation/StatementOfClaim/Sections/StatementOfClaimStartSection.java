package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.LawyersLetter.LLSectionFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCDocument;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.SOCSectionFactory;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;
import document_generation.util.CloseDocument;

public class StatementOfClaimStartSection extends SOCSection{

	public StatementOfClaimStartSection(){
		this.setSectionCode(SOCSectionCode.CUSTOM);
        this.setContents(new ArrayList<LLParagraph>());
		
	}
    public StatementOfClaimStartSection(SOCDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(SOCSectionCode.START);

        ArrayList<LLParagraph> content = new ArrayList<>();

//        LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//        header.setText("Statement of Claim Header");
//        content.add(header);
        
        LLParagraph courtFileNum = llpf.getParagraph(doc, ParaCode.RIGHT);
        courtFileNum.getXwpfParagraph().setAlignment(ParagraphAlignment.RIGHT);
        courtFileNum.setText("Court File No.:	");
        content.add(courtFileNum);
        
        LLParagraph courtTo = llpf.getParagraph(doc, ParaCode.HEAD);
        courtTo.getXwpfParagraph().setAlignment(ParagraphAlignment.CENTER);
        courtTo.setText("Ontario"
        		+ "%%Superior Court of Justice");
        content.add(courtTo);
        
        LLParagraph between = llpf.getParagraph(doc, ParaCode.REG);
        between.setText("BETWEEN");
        content.add(between);
        
        LLParagraph plaintiffName = llpf.getParagraph(doc, ParaCode.HEAD);
        plaintiffName.getXwpfParagraph().setAlignment(ParagraphAlignment.CENTER);
        plaintiffName.setText("<plaintiff_legal_name>");
        content.add(plaintiffName);

        LLParagraph plaintiffLabel = llpf.getParagraph(doc, ParaCode.REG);
        plaintiffLabel.getXwpfParagraph().setAlignment(ParagraphAlignment.RIGHT);
        plaintiffLabel.setText("PLAINTIFF");
        content.add(plaintiffLabel);
        
        LLParagraph andLiteral = llpf.getParagraph(doc, ParaCode.REG);
        andLiteral.getXwpfParagraph().setAlignment(ParagraphAlignment.CENTER);
        andLiteral.setText("and");
        content.add(andLiteral);
        
        LLParagraph defendantName = llpf.getParagraph(doc, ParaCode.HEAD);
        defendantName.getXwpfParagraph().setAlignment(ParagraphAlignment.CENTER);
        defendantName.setText("<defendant_legal_name>");
        content.add(defendantName);
        
        LLParagraph socTitle = llpf.getParagraph(doc, ParaCode.HEAD);
        socTitle.getXwpfParagraph().setAlignment(ParagraphAlignment.CENTER);
        socTitle.setText("%%"
        		+ "%%STATEMENT OF CLAIM");
        content.add(socTitle);
        
        LLParagraph toTheDef = llpf.getParagraph(doc, ParaCode.REG);
        toTheDef.setText("TO THE DEFENDANT");
        content.add(toTheDef);
        
        LLParagraph opening1 = llpf.getParagraph(doc, ParaCode.TAB);
        opening1.setText("A LEGAL PROCEEDING HAS BEEN COMMENCED AGAINST YOU by the plaintiff. The claim made against you is set out in the following pages.");
		content.add(opening1);
		
		LLParagraph opening2 = llpf.getParagraph(doc, ParaCode.TAB);
		opening2.setText("IF YOU WISH TO DEFEND THIS PROCEEDING, you or an Ontario lawyer acting for you must prepare a statement of defence in Form 18A prescribed by the Rules of Civil Procedure, serve it on the plaintiff’s lawyer or, where the plaintiff does not have a lawyer, serve it on the plaintiff, and file it, with proof of service, in this court office, WITHIN TWENTY DAYS after this statement of claim is served on you, if you are served in Ontario.");
		content.add(opening2);
		
		LLParagraph opening3 = llpf.getParagraph(doc, ParaCode.TAB);
		opening3.setText("If you are served in another province or territory of Canada or in the United States of America, the period for serving and filing your statement of defence is forty days. If you are served outside Canada and the United States of America, the period is sixty days.");
		content.add(opening3);
		
		LLParagraph opening4 = llpf.getParagraph(doc, ParaCode.TAB);
		opening4.setText("Instead of serving and filing a statement of defence, you may serve and file a notice of intent to defend in Form 18B prescribed by the Rules of Civil Procedure. This will entitle you to ten more days within which to serve and file your statement of defence.");
		content.add(opening4);
		
		LLParagraph opening5 = llpf.getParagraph(doc, ParaCode.TAB);
		opening5.setText("IF YOU FAIL TO DEFEND THIS PROCEEDING, JUDGMENT MAY BE GIVEN AGAINST YOU IN YOUR ABSENCE AND WITHOUT FURTHER NOTICE TO YOU.  IF YOU WISH TO DEFEND THIS PROCEEDING BUT ARE UNABLE TO PAY LEGAL FEES, LEGAL AID MAY BE AVAILABLE TO YOU BY CONTACTING A LOCAL LEGAL AID OFFICE.");
		content.add(opening5);
		
		LLParagraph opening6 = llpf.getParagraph(doc, ParaCode.TAB);
		opening6.setText("IF YOU PAY THE PLAINTIFF’S CLAIM, and $3000 for costs, within the time for serving and filing your statement of defence you may move to have this proceeding dismissed by the court. If you believe the amount claimed for costs is excessive, you may pay the plaintiff’s claim and $400 for the costs and have the costs assessed by the court. ");
		content.add(opening6);
		
		LLParagraph opening7 = llpf.getParagraph(doc, ParaCode.TAB);
		opening7.setText("TAKE NOTICE: THIS ACTION WILL AUTOMATICALLY BE DISMISSED if it has not been set down for trial or terminated by any means within five years after the action was commenced unless otherwise ordered by the court.");
		content.add(opening7);
        
        LLParagraph openingDate = llpf.getParagraph(doc, ParaCode.REG);
        openingDate.setText("Date:                                                                                    Issued by ‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗‗"
        					+"%%                                                                                                            Local Registrar");
        content.add(openingDate);
        
        LLParagraph addressOfTheCourt = llpf.getParagraph(doc, ParaCode.REG);
        addressOfTheCourt.getXwpfParagraph().setAlignment(ParagraphAlignment.RIGHT);
        addressOfTheCourt.setText("Address of court office:"
        			+"%%393 University Ave, 10th Floor"
        			+"%%Toronto, Ontario M5G 1E6");
        content.add(addressOfTheCourt);
        
        LLParagraph defendantMail = llpf.getParagraph(doc, ParaCode.REG);
        defendantMail.setText("TO: <defendant_legal_name>"
        		+ "%%<OC_HR_company_address>"
        		+ "%%<OC_HR_company_city> <OC_HR_company_province>"
        		+ "%%<OC_HR_company_postcode>");
        content.add(defendantMail);
        
//        LLParagraph simpleProcedureHeader = llpf.getParagraph(doc, ParaCode.HEAD);
//        simpleProcedureHeader.setText("Simplified Procedure Header");
//        content.add(simpleProcedureHeader);
        
        
        this.setContents(content);

    }
    
    public static void main(String[] args){
    	SOCSectionFactory socsf = new SOCSectionFactory();
        SOCDocument doc = new SOCDocument();
        LinkedHashMap<String, String> testMap = doc.getFieldsMap();
        testMap.put("bonus", "on");
        doc.setFieldsMap(testMap);
        
        for(SOCSectionCode code : SOCSectionCode.values()){
            SOCSection s = socsf.getSection(doc, code);
            doc.writeToDoc(s);
        }
        
        CloseDocument.closeSimple(doc, "SOCTest.docx");
    }
}
