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
public class HumanRightsDiscriminationSection extends LLSection{

    public HumanRightsDiscriminationSection(LLDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(LLSectionCode.HUMAN_RIGHTS_DIS);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf, doc, content, ParaCode.HEAD, "Human Rights Violations");
        
        insertText(llpf, doc, content, ParaCode.REG, "Employers in Ontario have an obligation to provide accommodation to the point of undue hardship for employees with disabilities. ");

        insertText(llpf, doc, content, ParaCode.REG, "In the absence of an adequate reason for <client_first_name>'s termination, <client_first_name> is concerned that discrimination was a factor in the decision by <employer_first_name> to terminate <objective_pronoun>.%%");

		insertText(llpf, doc, content, ParaCode.REG, "Terminating an employee for a reason contrary to the Human Rights Code constitutes discrimination and is a violation of the Ontario Human Rights Code, R.S.O. 1990 c.H. 19 for which general damages would be appropriate should this matter proceed to trial. Per section 5(1) of the Code, (emphasis added):");

		insertText(llpf, doc, content, ParaCode.QUOTE, "“every person has a right to equal treatment with respect to employment without discrimination because of race, ancestry, place of origin, colour, ethnic origin, citizenship, creed, sex, sexual orientation, gender identity, gender expression, age, record of offences, marital status, family status or disability.”");

		//TODO:chart functionality
		//chart
		/*
		The courts in the recent past have awarded significant damages for violations of the Code, especially in instances where an employer has failed to accommodate:


			Case
			Discrimination
			Damages Awarded
			Strudwick v. Applied Consumer & Clinical Evaluations Inc.
			Failure to accommodate
			$40,000
			Wilson v. Solis Mexican Foods Inc.
			Prohibited ground was a factor in termination
			$20,000
			Silvera v. Olympia Jewellery Corporation
			Harassment, Prohibited ground was a factor in termination
			$30,000
			Partridge v. Botony Dental Corporation

			Failure to accommodate, Prohibited ground was a factor in termination
			$20,000

			In consideration of the jurisprudence and the facts of the case, Patsy would be entitled to a similar quantum of damages for Jobs discriminatory conduct. 
		 */
		
		insertText(llpf, doc, content, ParaCode.REG, "In addition, as per Wilson v. Solis Mexican Foods Inc., 2013 ONSC 5799 (“Wilson”) at paragraph 57 substantial compensation is owed when a prohibited ground is a “significant factor in the decision to terminate.” In Wilson, $20,000.00 was awarded because of the role, which the prohibited ground, disability, played in the termination.%%");

		insertText(llpf, doc, content, ParaCode.REG, "Furthermore, jurisprudence is clear that the protected ground be only one factor in the decision to terminate an employee and does not have to be the sole or primary reason for the termination. As stated in Douglas v. SLH Transport Inc. [2010] C.H.R.D. No 1:%%");

		insertText(llpf, doc, content, ParaCode.QUOTE, "It is not necessary that discriminatory considerations be the sole reason for the actions in issue for a complaint to succeed. It is sufficient that the discrimination be but one basis for the employer’s actions or decisions.%%");

        //TODO keep flag in doc to track which paragraph is needed
        if (Objects.equals(doc.getFieldsMap().get("isUseTerminationOnProtectedGround"), "on")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Human Rights Discrimination - Termination on Protected Ground");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "Terminating an employee based on their " +
                    "[ENUMERATED GROUND] constitutes discrimination and is a violation of the Ontario Human " +
                    "Rights Code, R.S.O. 1990 c.H. 19 for which general damages would be appropriate should " +
                    "this matter proceed to trial. Per section 5(1) of the Code, (emphasis added): %%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "“every person has a right to equal treatment " +
                    "with respect to employment without discrimination because of race, ancestry, place of origin, " +
                    "colour, ethnic origin, citizenship, creed, sex, sexual orientation, gender identity, gender " +
                    "expression, age, record of offences, marital status, family status or disability.” %%");
            insertText(llpf,doc,content,ParaCode.REG, "In addition, as per Wilson v. Solis Mexican Foods " +
                    "Inc., 2013 ONSC 5799 (“Wilson”) at paragraph 57 substantial compensation is owed when a " +
                    "prohibited ground is a “significant factor in the decision to terminate.” In Wilson, $20,000.00 " +
                    "was awarded because of the role, which the prohibited ground, disability, played in the termination.%%" +
                    "%%" +
                    "Furthermore, jurisprudence is clear that the protected ground be only one factor in the decision " +
                    "to terminate an employee and does not have to be the sole or primary reason for the termination. " +
                    "As stated in Douglas v. SLH Transport Inc. [2010] C.H.R.D. No 1:%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "It is not necessary that discriminatory " +
                    "considerations be the sole reason for the actions in issue for a complaint to succeed. It is " +
                    "sufficient that the discrimination be but one basis for the employer’s actions or decisions.");
        }

        if (Integer.parseInt(doc.getFieldsMap().get("age"))>45) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Human Rights Discrimination - Age Damages");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "Discrimination on the basis of age has been found to " +
                    "attract significant damages. In Cowling v. Her Majesty the Queen in Right of Alberta as " +
                    "represented by Alberta Employment and Immigration 2012 AHRC 12, the Applicant, who was 59 " +
                    "years of age, was employed under a series of contracts as a Labour Relations Officer. Before " +
                    "her fourth contract was to end, she was told that her position was being eliminated due to " +
                    "restructuring, and would be transformed into a lower level position. The Respondent then held " +
                    "a competition for a lower level position. The Applicant applied but did not obtain the job. " +
                    "She subsequently filed a complaint with the Human Rights Tribunal of Alberta. When the matter " +
                    "proceeded before the Tribunal, it was held that the lower level position was effectively the " +
                    "same, and that it was created with the goal of having a younger candidate replace the Applicant. " +
                    "The Tribunal thus determined that the Respondent had discriminated against the Applicant on the " +
                    "basis of age and awarded her $15,000.00 for injury to dignity, feelings and self-respect.");
        }

        //TODO Charts functionality, new type of paragraph
        if (Objects.equals(doc.getFieldsMap().get("isUseHumanRightsDamagesChart"), "on")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Human Rights Damages Chart");
            //body:
        }

        this.setContents(content);
    }

}
