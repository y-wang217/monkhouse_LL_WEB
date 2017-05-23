package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Yale Wang
 */
public class LTDJurisprudenceSection extends LLSection{

    public LTDJurisprudenceSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.LTD_JURISPRUDENCE);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Long Term Disability");


        //TODO keep flag in doc to track which paragraph is needed
        if (Objects.equals(doc.getFieldsMap().get("isUseBreachOfContract"), "on")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Breach Of Contract");
            //body: TODO change "Chris" to "<client_first_name>"
            insertText(llpf, doc, content, ParaCode.REG, "Chris’s claim for LTD benefits was denied by " +
                    "Fenchurch with inadequate reasons for the denial. Due to the improper denial of Chris’s claim, " +
                    "Fenchurch has failed to secure the peace of mind it offered in its contract with Chris’s " +
                    "employer.  The resulting significant mental distress on Chris has caused him continued " +
                    "dependency on LTD benefits that he does not have.%%" +
                    "%%" +
                    "Pursuant to the plan and policy, which Chris’s employer held with Fenchurch, Chris was to be " +
                    "paid disability benefits following the substantiation of a claim for same. Despite the fact that " +
                    "Chris substantiated his claim, Fenchurch refused the claim with an insufficient explanation. " +
                    "This constitutes a breach of the contract between Chris and Fenchurch, for which damages are owed.");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseLtdJurisprudence"), "on")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"LTD Jurisprudence");
            //body:
            insertText(llpf, doc, content, ParaCode.REG, "Jurisprudence has indicated that mental distress damages " +
                    "arise wherein a breach of contract creates the expectation of a “psychological benefit” (Fidler v. " +
                    "Fenchurch Assurance Co. of Canada, [2006] 2 S.C.R. 3, 2006 SCC 30). %%" +
                    "%%" +
                    "In <client_first_name>'s case, the psychological benefit was, of course, the guarantee of disability benefits " +
                    "where required - a benefit which was unavailable when <client_first_name> needed it most. This has caused him " +
                    "undue amounts of mental suffering as exhibited by the depression and anxiety he experiences, for " +
                    "which compensation is rightfully owed.%%" +
                    "%%" +
                    "In Fernandes v. Penncorp Life Insurance Company, 2014 ONCA 615, a claimant was also unjustly denied " +
                    "disability benefits. When the matter proceeded to trial, the court awarded Fernandes mental distress " +
                    "damages in the sum of $100,000.00 for Penncorp’s actions in denying his claim, which caused Fernandes " +
                    "significant trauma, even though Penncorp’s actions were not the only factors contributing to his " +
                    "stress. The court also awarded $200,000.00 in punitive damages, below, for Penncorp’s actions in " +
                    "denying the claim wherein there was no cause to do so, categorizing its actions as “highhanded, " +
                    "malicious, arbitrary or highly reprehensible misconduct.” %%" +
                    "%%" +
                    "It is my position that <client_first_name> would be entitled to a similar quantum of damages should this matter proceed to trial.\n");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseMovingForwardLtd"), "on")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Moving Forward in the Context of LTD");
            //body: TODO actually put in valid values/make equations for valid values
            insertText(llpf, doc, content, ParaCode.REG, "It is our position that <client_first_name> would be " +
                    "entitled to significant damages should this matter proceed to trial. However, as a show of " +
                    "good faith, <client_first_name> would be willing to settle this matter for the following:%%");
            insertText(llpf, doc, content, ParaCode.QUOTE, "1. Fenchurch accepts <client_first_name>'s Long Term Benefits " +
                    "2. claim as soon as possible, or in the alternative, continues <client_first_name>'s Long Term Disability " +
                    "Benefits until he reaches the age of 65- an approximate monetary equivalent of $293,186.88;%%" +

                    "3. Fenchurch makes a lump sum payment of all disability benefits <client_first_name> would have received from " +
                    "July 18, 2016 until the date of acceptance;%%" +

                    "4. Fenchurch makes a lump sum payment of $20,000.00, representing damages for <client_first_name>'s " +
                    "mental distress; and%%" +

                    "5. Partial indemnity fees as agreed or assessed to the date of acceptance of offer " +
                    "(estimate currently $3,000.00) towards <client_first_name>'s legal fees.");

            insertText(llpf, doc, content, ParaCode.REG, "This offer will remain open until trial. Should " +
                    "this matter proceed to trial we will rely upon this offer as an official Rule 49 offer and " +
                    "seek substantial indemnity costs.\n");
        }

        this.setContents(content);
    }
}
