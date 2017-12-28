package document_generation.StatementOfClaim.Sections;

import java.util.ArrayList;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class WrongfulDismissalSection extends SOCSection{
	public WrongfulDismissalSection(LLDocument doc, LLParagraphFactory llpf) {
		this.setSectionCode(SOCSectionCode.WRONGFUL);

		ArrayList<LLParagraph> content = new ArrayList<>();

		setSqlSOC(this.getSectionCodeSOC().toString());
		HashMap<String, String> resultSet= dao.executeSelect(this.getSelectSql());
		
		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
		header.setText(resultSet.get("1"));
		content.add(header);

		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
		text.setText(resultSet.get("2"));
		content.add(text);
//		
//		LLParagraph header = llpf.getParagraph(doc, ParaCode.HEAD);
//		header.setText("Wrongful Dismissal Damages	");
//		content.add(header);
//
//		LLParagraph text = llpf.getParagraph(doc, ParaCode.REG);
//		text.setText("In light of <client_first_name>'s position, the specialized nature of <subjective_pronoun> position, length of service, age, the current state of the economy, and the consequential scarcity of comparable employment in the marketplace, <client_first_name> is entitled to a period of reasonable notice of the termination of <subjective_pronoun> employment of not less than <settlement> months’ pay in lieu of notice, or the sum of approximately [MONETARY AMOUNT OF NOTICE]. "
//				+ "%%"
//				+ "%%Since <subjective_pronoun> termination from <employer_first_name>, <client_first_name> has attempted to mitigate <subjective_pronoun> damages by seeking other reasonably comparable positions but has not had any success. Therefore, <client_first_name> pleads that no amounts claimed should be reduced on account of any alleged failure to reasonably mitigate <subjective_pronoun> damages"
//				+ "%%"
//				+ "%%<client_first_name> claims <subjective_pronoun> job search expenses and any relocation expenses that were incurred as special damages, the full particulars of which will be provided before trial. ");
//		content.add(text);

        this.setContents(content);
	}
}

