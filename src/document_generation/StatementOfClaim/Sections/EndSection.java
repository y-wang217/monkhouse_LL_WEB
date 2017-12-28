package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class EndSection extends SOCSection {
	public EndSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.END);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelect(this.getSelectSql());
		
		LLParagraph text = llpf.getParagraph(doc, ParaCode.HEAD);
		text.setText(resultSet.get("1"));
		content.add(text);

		LLParagraph ending = llpf.getParagraph(doc, ParaCode.REG);
		ending.setText(resultSet.get("2"));
		content.add(ending);
//		
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("Date:");
//		content.add(text);
//
//		LLParagraph ending = llpf.getParagraph(doc, ParaCode.REG);
//		ending.getXwpfParagraph().setIndentationLeft(30);
//		ending.setText("Monkhouse Law" + "%%Barristers & Solicitors"
//				+ "%%357 Bay Street, Suite 804" + "%%Toronto, Ontario, M5H 2T7"
//				+ "%%" + "%%Andrew H. Monkhouse (64529L)"
//				+ "%%andrew@monkhouselaw.com" + "%%" 
//				+ "%%<monkhouse_lawyer_name> (<monkhouse_lawyer_code>)"
//				+ "%%<monkhouse_lawyer_email>"
//				+ "%%" + "%%Tel.:  416-907-9249" + "%%Fax:  888-501-7235"
//				+ "%%" + "%%Lawyers for the Plaintiff <client_first_name> <client_last_name>");
//		content.add(ending);

		this.setContents(content);
	}
}
