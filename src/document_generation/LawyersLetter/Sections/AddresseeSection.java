package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;

/**
 * Created by Yale Wang
 */
public class AddresseeSection extends LLSection {
    public AddresseeSection(LLDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(LLSectionCode.ADDRESSEE);

        ArrayList<LLParagraph> content = new ArrayList<>();

        LLParagraph addressee = llpf.getParagraph(doc, ParaCode.REG);
        //the first line  is supposed to be bold, but the rest should be not-bold
        addressee.setText("<OC_HR_first_name> <OC_HR_last_name>%%" +
                "<OC_HR_job_title>%%" +
                "<OC_HR_company_name>%%" +
                "<OC_HR_company_address>%%" +
                "<OC_HR_company_postcode>");
        content.add(addressee);

        this.setContents(content);

    }

}
