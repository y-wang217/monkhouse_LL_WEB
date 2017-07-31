package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Yale Wang
 */
public class HarassmentSection extends LLSection {

    public HarassmentSection(LLDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(LLSectionCode.HARASSMENT);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf, doc, content, ParaCode.HEAD, "Harassment");
        
        insertText(llpf, doc, content, ParaCode.REG, "While employed with <employer_first_name>, <client_first_name> was subjected repeated and ongoing harassment. <employer_first_name> was aware of the harassment, or at the very least ought to have been aware of the harassment but did not take action to prevent it. This behaviour was effectively condoned by <employer_first_name>.%%");

        insertText(llpf, doc, content, ParaCode.REG, "Workplace harassment is contrary to the Occupational Health and Safety Act (OHSA) and “Bill 168”. On or about [time of sample event] <client_first_name> was subjected to [description of harassment]. Similar occurrences often took place, <client_first_name> described this behaviour as indicative of the managerial style of <employer_first_name>. This harassment was present throughout the tenure of <client_first_name>. It is my position that <employer_first_name> had failed to prevent harassment in the workplace, to prepare and maintain a workplace harassment policy and to enforce that policy effectively.%%");


        //TODO keep flag in doc to track which paragraph is needed
        if (Objects.equals(doc.getFieldsMap().get("isUseOhsaBill168"), "on")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Harassment - OHSA / Bill 168");
            //body:
            //TODO: something about this ordering is wrong
            insertText(llpf,doc,content,ParaCode.REG, "The Plaintiff also experienced " +
                    "harassment in the workplace while at <employer_first_name>, contrary to the Occupational Health and Safety " +
                    "Act (OHSA) and “Bill 168”. On or about [time of sample event] <client_first_name> was subjected to " +
                    "[description of harassment]. Similar occurrences often took place, <client_first_name> described this " +
                    "behaviour as indicative of the managerial style of <employer_first_name>. This harassment was present " +
                    "throughout <client_first_name>’s tenure. It is my position that <employer_first_name> had failed to prevent harassment " +
                    "in the workplace, to prepare and maintain a workplace harassment policy and to enforce that " +
                    "policy effectively. \n");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUsePunitiveDamagesHarassmsnt"), "on")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Harassment");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, 
                    "Furthermore, the harassment <client_first_name> endured while at <employer_first_name> is in violation of the " +
                    "Occupational Health and Safety Act, R.S.O. 1990 c.O.1, as well as “Bill 168”, for which " +
                    "punitive, aggravated and/or moral damages are rightfully awarded." +
                    "%%" +
                    "Condoning workplace harassment has been found to attract significant punitive damages. In " +
                    "Boucher v. Wal-Mart Canada Corp. [2014] O.J. No. 2452, the Plaintiff was initially awarded " +
                    "one million dollars in punitive damages for her employer’s actions in condoning the regular " +
                    "harassment she was subjected to by her Store Manager. The award was reduced to $110,000.00 on " +
                    "appeal. Similarly, in Sulz v. Canada (Attorney General) [2006] B.C.J. No. 121, the Plaintiff was " +
                    "awarded $125,000.00 in general damages and aggravated damages, for her employer’s actions in " +
                    "allowing her boss, a Staff Sergeant, to regularly harass her. The fact that her harasser was " +
                    "her superior was found to aggravate the damages award.");
        }

        this.setContents(content);
    }

}
