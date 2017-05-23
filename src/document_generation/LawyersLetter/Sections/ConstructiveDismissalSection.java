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
public class ConstructiveDismissalSection extends LLSection{

    public ConstructiveDismissalSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.CONSTRUCTIVE_DISMISSAL);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal");

        //TODO keep flag in doc to track which paragraph is needed
        if(Objects.equals(doc.getFieldsMap().get("isUseWageDeduction"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal - Wage Deduction");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "As found in cases such as Farquhar v. Butler " +
                    "Brothers Supplies Ltd, 1988 CanLII 185 (BCCA), a constructive dismissal occurs when the " +
                    "employer commits either a present breach or an anticipatory breach of a fundamental term " +
                    "of a contract of employment. In Farquhar, Justice Carrothers found that a 30% deduction " +
                    "of the employees pay constitutes as constructive dismissal.");

        }
        if(Objects.equals(doc.getFieldsMap().get("isUseLocation"), "on")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal - Location");
            //body
            insertText(llpf,doc,content,ParaCode.REG, "The majority held in Reynolds v. Innopac Inc., 1998 CanLII 3558 (ON CA) that a change in location of work that required a substantially greater travel time would have substantially changed the way in which the employee carried out [HIS/HER] job and duties. In Weselan v. Totten Sims Hubicki Associates Ltd. (1997) Ltd. (2001), 16 CCEL (3d) 184 (Ont CA) it was found that a required travel time of an hour and a half and the annual cost associated with such travel would constitute a significant change in the travel time and therefore constituted constructive dismissal. \n");

        }
        if(Objects.equals(doc.getFieldsMap().get("isUseBreachOfFundamentalImpliedTerm"), "on")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal - Breach of Fundamental Implied Term");
            //body
            insertText(llpf,doc,content,ParaCode.REG, "A breach of a fundamental term of the employment contract constitutes constructive dismissal. The courts have found that constructive dismissal can exist where the employer breaches an implied term of the employment contract. In Lloyd v. Imperial Parking Ltd., 1996 CanLII 10543 (AB QB), the court stated, at p. 41, that “a fundamental implied term of any employment relationship is that the employer will treat the employee with civility, decency, respect, and dignity.” In Lloyd the employer was found to have breached this implied term of the employment contract for having repeatedly yelled and screamed at the employee. \n");

        }
        if(Objects.equals(doc.getFieldsMap().get("isUseIntolerable"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal - Intolerable");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The courts may find that an employee has been " +
                    "constructively dismissed where the employer has made continued employment intolerable. In " +
                    "Shah v. Xerox Canada Ltd, 2000 CanLII 2317 (ON CA) the courts found that it was not necessary " +
                    "for the employer to change the contract for there to be constructive dismissal. There the court " +
                    "decided at p. 6");
            insertText(llpf,doc,content,ParaCode.QUOTE, "The court may find an employee has been " +
                    "constructively dismissed, without identifying a specific fundamental term that has been " +
                    "breached, where the employer’s treatment of the employee makes continued employment intolerable.\n");
            insertText(llpf,doc,content,ParaCode.REG, "Further, in Morland v. Kenmara Inc., 2006 CanLII 4902 " +
                    "(ON SC) the court, echoing Shah, found that the conduct of the employer, continually using foul " +
                    "language and abusive conduct toward the employee was found to have constituted constructive " +
                    "dismissal. There the court stated, at p. 30, that “If an employer wishes to have a successful " +
                    "business, it is incumbent upon the employer to foster congeniality amongst the employees by " +
                    "providing a good working environment which will result in good employee productivity.”");
        }
        if(Objects.equals(doc.getFieldsMap().get("isUseWorkplaceHarassment"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal - Workplace Harassment");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "<client_first_name> was subject to verbal and physical harassment " +
                    "while working at <employer_first_name>. This harassment runs entirely contrary to the Occupational Health and " +
                    "Safety Act and those as amended in “Bill 168”.%%" +
                    "%%" +
                    "The law is clear that if someone is harassed in their workplace they are in fact constructively " +
                    "dismissed. In Stamos v. Annuity Research & Marketing Service Ltd [2002] O.J. No. 1865, para 60-62 states:");
            insertText(llpf,doc,content,ParaCode.QUOTE, "“An employer owes a duty to its employees to treat " +
                    "them fairly, with civility, decency, respect and dignity.  An employer who subjects employees to " +
                    "treatment that renders competent performance of their work impossible or continued employment " +
                    "intolerable exposes itself to an action for constructive dismissal.  Where the employers’ " +
                    "treatment of the employee is of sufficient severity and effect, it will be characterized as an " +
                    "unjustified repudiation of the employment contract… The employee is entitled to treat the " +
                    "employment contract as at an end, and to recover at least damages in lieu of reasonable notice.”");
            insertText(llpf,doc,content,ParaCode.REG, "Since [CLIENT] was constructively dismissed by " +
                    "way of harassment resulting in an unsafe work environment, [HE/SHE] is owed reasonable common " +
                    "law notice of the termination of [HIS/HER] employment. In addition, [CLIENT] is entitled to " +
                    "damages for the mental anguish suffered as a result of the assault that [HE/SHE] experienced " +
                    "at work.");
        }
        if(Objects.equals(doc.getFieldsMap().get("isUsePoisonedWorkEnvironment"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal - Poisoned Work Environment");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "In the case of Stamos v Annuity Research & Marketing " +
                    "Service Ltd., 2002 49618 (ONSC), the trial judge upheld a claim for constructive dismissal after " +
                    "finding the Plaintiff’s work environment had been poisoned by an employee who subjected the " +
                    "Plaintiff to verbal harassment, threatening and intimidating tactics, and more.%%" +
                    "%%" +
                    "In paragraph 60 of the decision, the judge set out the following: ");
            insertText(llpf,doc,content,ParaCode.QUOTE, "An employer owes a duty to its employees to treat " +
                    "them fairly, with civility, decency, respect and dignity. An employer who subjects employees to " +
                    "treatment that renders competent performance of their work impossible or continued employment " +
                    "intolerable exposes itself to an action for constructive dismissal. Where the employers’ treatment " +
                    "of the employee is of sufficient severity and effect, it will be characterized as an unjustified " +
                    "repudiation of the employment contract. Whether such treatment is viewed as a breach of a " +
                    "specified fundamental implied term of the employment relationship (see, for example, Lloyd v. " +
                    "Imperial Parking Ltd., [1996] A.J. No. 1087 (Q.B.), and Sheppard v. Sobeys Inc., [1997] N.J. " +
                    "No. 78 (C.A.)), or as a repudiation of the entire employment relationship (see Shah v. Xerox " +
                    "Canada Ltd., [2000] O.J. No. 849 (C.A.)), the result is the same. The employee is entitled to " +
                    "treat the employment contract as at an end, and to recover at least damages in lieu of reasonable " +
                    "notice.\n");
            insertText(llpf,doc,content,ParaCode.REG, "As such, it is my position that given a holistic " +
                    "view of the circumstances at hand, Crystal has been constructively dismissed and is entitled to " +
                    "a reasonable notice period of her termination of employment.");
        }
        if(Objects.equals(doc.getFieldsMap().get("isUseRemovalFromManagementPosition"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Constructive Dismissal - Removal from Management Position");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "In the case of Murdock v 497123 Ontario Ltd., 2005 " +
                    "CanLII 8693 (ONSC), an employee was found to be constructively dismissed when she was removed " +
                    "from a management position into a position without authority. It is my position that this case " +
                    "is similar; by unilaterally changing [CLIENT’s position from _____ to _______, <employer_first_name> has " +
                    "effectively constructively dismissed her. \n");

        }

        this.setContents(content);
    }

}
