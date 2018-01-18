package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class OHSA168Section extends SOCSection{
	public OHSA168Section(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.OHSA);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelectParagraphText(this.getSelectSql());
		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText(resultSet.get("1"));
//		content.add(header);
//
//		LLParagraph header2 = llpf.getParagraph(doc, ParaCode.HEAD);
//		header2.setText(resultSet.get("2"));
//		content.add(header2);
//		
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText(resultSet.get("3"));
//		content.add(text);
//		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText("Harassment");
		content.add(header);
		
		LLParagraph header2 = llpf.getParagraph(doc, ParaCode.HEAD);
		header2.setText("OHSA/Bill 168");
		content.add(header2);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText("<employer_first_name> pleads that she was subjected to harassment in the workplace, contrary to the Occupational Health and Safety Act and “Bill 168”.  "
				+ "%%"
				+ "%%<harassment_info> "
				+ "%%"
				+ "%%<employer_first_name> pleads that <employer_first_name> failed to ensure a safe and harassment-free workplace environment and condoned the harassment through their failure. ");
		content.add(text);

        this.setContents(content);
	}
}
