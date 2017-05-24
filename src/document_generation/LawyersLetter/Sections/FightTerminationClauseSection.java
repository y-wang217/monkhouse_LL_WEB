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
public class FightTerminationClauseSection extends LLSection {

    public FightTerminationClauseSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.FIGHT_TERMINATION_CLAUSE);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal");

        //TODO keep flag in doc to track which paragraph is needed
        if(Objects.equals(doc.getFieldsMap().get("isUseBasicStart"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Basic Start");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The termination clause in Alex’s employment contract " +
                    "is invalid, as it fails to provide for all entitlements required by the Employment Standards Act, " +
                    "2000, SO 1990 c 41 (“ESA”) and is therefore, unenforceable.");

        }
        if(Objects.equals(doc.getFieldsMap().get("isUseNoContractingOutOfESA"), "on")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"No Contracting Out of ESA");
            //body
            insertText(llpf,doc,content,ParaCode.REG, "In the recent decision of Roy Singh v. Qualified " +
                    "Metal Fabricators Ltd., a two-part test was set out to determine the enforceability of a " +
                    "termination clause:%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "1. Whether the termination clause rebuts the " +
                    "presumption that the common law notice period continues to apply (i.e., does it replace the ESA), and" +
                    "%%" +
                    "2. Whether the clause, as drafted, deprives the plaintiff of any ESA Rights (i.e., is it worse than the ESA).");
            insertText(llpf,doc,content,ParaCode.REG, "In applying the test, the clause attempts to contract " +
                    "out of the ESA entitlements by stipulating that no \"further amounts shall be due and payable\" " +
                    "other than notice and severance pay, if any. With this language, the contract fails to specify " +
                    "other statutory entitlements such as continuation of benefits at the time of termination. " +
                    "Pursuant to section 61(b) of the ESA, an employer must continue to contribute to any and " +
                    "all benefits the terminated employee would have been entitled to as if they have not been " +
                    "terminated.  Failing to include the continuation of benefits within the termination clause is " +
                    "an attempt to contract out of the ESA’s requirements of employers and would likely render the " +
                    "clause invalid at law.");
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseNonInclusionOfBenefits"), "on")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Non-inclusion of Benefits (or contracting out of ESA)");
            //body
            insertText(llpf,doc,content,ParaCode.REG, "The foregoing is in accordance with the Court’s " +
                    "ruling in Stevens v. Sifton Properties Ltd. 2012 ONSC 5508 (CanLII), wherein the clause in " +
                    "the Plaintiff’s employment contract was found invalid on the basis of an employer’s failure " +
                    "to continue benefits throughout the notice period. In its reasons for decision at paragraph 64, " +
                    "the court stated that:");
            insertText(llpf,doc,content,ParaCode.QUOTE, "The failing of the particular termination " +
                    "provisions in the case before me is that they attempt to \"draw the circle\" of employee " +
                    "rights and entitlements on termination with an all-encompassing specificity that results in " +
                    "the effective and impermissible exclusion and denial of the benefit continuation rights " +
                    "mandated by the legislation. That is what puts paragraph 13 offside, and requires the " +
                    "\"termination provision package\" of paragraph 13 to be regarded as null and void, in " +
                    "accordance with the policy considerations and directive outlined by the Supreme Court of " +
                    "Canada in Machtinger.");
            insertText(llpf,doc,content,ParaCode.REG, "Similarly, in the case of Miller v. A.B.M. " +
                    "Canada Inc., 2014 ONSC 4062, a termination clause within an employee’s employment agreement " +
                    "failed to provide for the continuation or provision of benefits at the time of termination, " +
                    "and as such the court held that the termination clause contravened the provisions of the ESA and " +
                    "found to be invalid.%%" +
                    "%%" +
                    "This position is further affirmed by the Court of Appeal decision in Wood v. Fred Deeley " +
                    "Imports Ltd. 2017 ONCA 158 (CanLII) wherein an attempt to contract out of an ESA minimum " +
                    "standard rendered the termination clause unenforceable. At para. 21, the Court stated: ");
            insertText(llpf,doc,content,ParaCode.QUOTE, "Deeley was precluded from contracting out of any " +
                    "of these employment standards, unless it substituted a greater benefit for Wood. Contracting out " +
                    "of even one of the employment standards and not substituting a greater benefit would render the " +
                    "termination clause void and thus unenforceable, in which case Wood would be entitled to " +
                    "reasonable notice of termination of her employment at common law.");

        }
        if(Objects.equals(doc.getFieldsMap().get("isUsePotentialViolations"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Potential Violations");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "A termination clause that has the potential to " +
                    "run afoul of the statutory minimums will held to be invalid. In Wright v. The Young Rubicam " +
                    "dsGroup of Companies, 2011 ONSC 4720 (CanLII) the court reasoned: ");
            insertText(llpf,doc,content,ParaCode.QUOTE, "There is, in my view, no particular difficulty in " +
                    "fashioning a termination clause that does not violate either the minimum standards imposed by " +
                    "the Employment Standards Act or the prohibition against waiving statutory minimum requirements " +
                    "and there is no compelling reason to uphold a termination clause which the draftsman may " +
                    "reasonably be understood to have known was not enforceable either at all or under certain " +
                    "circumstances.%%" +
                    "%%" +
                    "In my view, the termination provision in the employment agreement is void and the presumption " +
                    "that termination will only be upon reasonable notice is not, in this case, rebutted.");
            insertText(llpf,doc,content,ParaCode.REG, "This principle has been affirmed by the Ontario Court " +
                    "of Appeal in Wood v. Fred Deeley Imports Ltd. 2017 ONCA 158 and Covenoho v Pendylum Ltd, 2017 ONCA 284. \n");
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseEmployerCannotRelyOnBreachedTerminationClause"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Employer Cannot Rely on Breached Termination Clause");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "Furthermore, CDW has breached its contract by failing " +
                    "to include <client_first_name>’s commissions during <possessive_pronoun> reasonable notice period, which he is entitled to.  " +
                    "Therefore, CDW cannot now rely on the terms of the contract to limit Alex's notice entitlements. " +
                    "This position is supported in the recent decision of Holmes v. Hatch Ltd., 2017 ONSC 379 (CanLII) " +
                    "(at para. 24):");
            insertText(llpf,doc,content,ParaCode.QUOTE, "Mr. Holmes relies on Ebert to support his " +
                    "argument that Hatch cannot breach the contract “and then rely on the termination clause which " +
                    "it breached, to limit its liability”. I agree with these submissions. Mr. Holmes is therefore " +
                    "entitled to damages for failure to provide reasonable notice in accordance with the common law. " +
                    "[Emphasis added.]");

        }
        this.setContents(content);
    }
}
