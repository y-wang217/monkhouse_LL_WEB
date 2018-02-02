package document_generation.LawyersLetter.Sections;

import java.util.ArrayList;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.Codes.ParaCode;

public class NumberingTestSection extends LLSection {

	public NumberingTestSection(LLDocument doc, LLParagraphFactory llpf) {

		this.setSectionCode(LLSectionCode.NUM_TEST);

		ArrayList<LLParagraph> content = new ArrayList<>();
		// heading:
		insertText(llpf, doc, content, ParaCode.HEAD, "Moving Forward");

		// body:
		insertText(
				llpf,
				doc,
				content,
				ParaCode.REG,
				"Based on the above, I have advised <client_first_name> that "
						+ "<subjective_pronoun> has a significant claim for wrongful dismissal damages."
						+ "%%"
						+ "Notwithstanding the attached _Statement of Claim_, and in an effort to resolve the matter in good "
						+ "faith, <client_first_name> has advised me that <subjective_pronoun> would be willing to settle this matter on the following "
						+ "conditions:");

		String overtimeString = "";
		// String overtimeString =
		// doc.getFieldsMap().get("overtime").equals("on")?"The sum of <dollarsOvertimeOwed> representing compensation for 50% of overtime owed;%%":"";
		insertText(
				llpf,
				doc,
				content,
				ParaCode.LIST,
				"A lump sum payment of $<dollarsNoticeOwed>.00, representing <settlement> months’ pay in lieu of notice;%%"
						+ "$<dollarsBenefitsOwed>.00 representing 20% in lieu of her benefits over the <settlement>-month notice period;%%"
						+ overtimeString
						+ "The sum of $<dollarsDamagesOwed>.00 in general damages in lieu of Human Rights, Punitive, Aggravated, and/or Moral Damages;%%"
						+ "A contribution of $500.00 towards career counselling; %%"
						+ "A positive letter of recommendation in order to assist <client_first_name> in finding comparable employment; and,%%"
						+ "Partial indemnity fees as agreed or assessed to the date of acceptance of offer (estimate currently $3,000.00) towards legal fees.\n");

		insertText(
				llpf,
				doc,
				content,
				ParaCode.REG,
				"For a total monetary offer of $<dollarsTotalOwed>.00 at this point in time.%%"
						+ "%%"
						+ "This offer will remain open until trial. We intend to rely upon this letter as an official Rule "
						+ "49 offer should the matter go to trial in order to seek substantial indemnity costs.\n");

		// insertText(llpf,doc,content,ParaCode.REG," For a total monetary offer of <total_offer>  at this time. ");

		insertText(
				llpf,
				doc,
				content,
				ParaCode.REG,
				"This offer will remain open until 5 minutes after the start of trial. We intend to rely upon this letter as an official Rule 49 offer should the matter go to trial to seek substantial indemnity costs should we beat it at trial.");
		insertText(
				llpf,
				doc,
				content,
				ParaCode.LIST,
				"2A lump sum payment of $<dollarsNoticeOwed>.00, representing <settlement> months’ pay in lieu of notice;%%"
						+ "2$<dollarsBenefitsOwed>.00 representing 20% in lieu of her benefits over the <settlement>-month notice period;%%"
						+ overtimeString
						+ "2The sum of $<dollarsDamagesOwed>.00 in general damages in lieu of Human Rights, Punitive, Aggravated, and/or Moral Damages;%%"
						+ "2A contribution of $500.00 towards career counselling; %%"
						+ "2A positive letter of recommendation in order to assist <client_first_name> in finding comparable employment; and,%%"
						+ "2Partial indemnity fees as agreed or assessed to the date of acceptance of offer (estimate currently $3,000.00) towards legal fees.\n");
		this.setContents(content);
	}
}
