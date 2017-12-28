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
public class PunitiveDamagesSection extends LLSection {

    public PunitiveDamagesSection(LLDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(LLSectionCode.PUNITIVE_DMGS);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf, doc, content, ParaCode.HEAD, "Punitive Damages");
        
        insertText(llpf, doc, content, ParaCode.REG, "For its actions, it is my position that <employer_first_name> would be liable for punitive, aggravated, Bhasin, and/or moral damages. In this case, <employer_first_name> has committed independent actionable wrongs for which the award of additional damages would be warranted.%%");


        //TODO keep flag in doc to track which paragraph is needed
        if (Objects.equals(doc.getFieldsMap().get("isUseBadFaith"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Bad Faith");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "<employer_first_name>'s actions in this case would also result " +
                    "in the award of “bad faith” damages as categorized in the case of _Bhasin v Hrynew_, 2014 SCC 7. " +
                    "As per Bhasin, parties to a contract are under a duty to act honestly in the performance of " +
                    "their contractual obligations. <employer_first_name>'s conduct in this case for " +
                    "[factual recollection of reasons] does not fulfill their duty of honesty. ");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseOpenAndHonestManner"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Open and Honest Manner");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The case of _Ashton v. Perle Systems Ltd_., 1994 " +
                    "CanLII 7407 (ON SC) supports the position that an employer has an obligation to carry out " +
                    "an employee’s dismissal in an open and honest manner, and to avoid unwarranted harm to the " +
                    "employee. Terminating Rachelle after five (5) years of dedicated service and providing her " +
                    "with an inadequate severance package is indicative of dishonest behaviour and a blatant disregard " +
                    "for her financial and emotional well-being.");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseUnfavourableReference"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Unfavourable Reference");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "In the case of _Gillman v. Saan Stores Ltd_. [1992] A.J. " +
                    "No. 1028, the Plaintiff, a retail Sales Manager, was terminated after 32 years with the " +
                    "Defendant’s company. The Plaintiff had breached company policy in signing off on an absence " +
                    "report so that a subordinate could babysit for him, which upper management caught wind of as " +
                    "a result of an employee notification. After he was terminated, the Plaintiff diligently mitigated " +
                    "his damages, applying to numerous positions which were comparable. This task, given his " +
                    "termination and time at the company, was difficult enough, but the difficulty increased " +
                    "when his former employer provided an unfavourable reference without his knowledge. At trial, " +
                    "the Plaintiff was awarded six months’ pay in lieu of notice- an additional 2 months from the " +
                    "usual notice period for an individual in similar circumstances, reimbursement for his career " +
                    "counselling services, and $5,000.00 in punitive damages for his employer’s conduct in alleging " +
                    "just cause against him and refusing to provide a favourable reference to assist the Plaintiff " +
                    "in obtaining re-employment.");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseReprisalHarassmentReport"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Reprisal Harassment Report");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The courts have found that significant damages " +
                    "are warranted wherein an act of reprisal has occurred. In _Morgan v. Herman Miller Canada Inc_. " +
                    "[2013] O.H.R.T.D. No 650, an employee who had brought the issue of racial discrimination " +
                    "against him to his employer’s attention and was subsequently terminated, was awarded " +
                    "$70,799.70. Based on <client_first_name> situation, it is clear that after reporting the harassment, " +
                    "<employer_first_name> made no attempts to protect <client_first_name> from the continued harassment, in an effort " +
                    "to facilitate her departure from the company. Such actions warrant the award of punitive, " +
                    "aggravated and/or moral damages in order to deter this sort of conduct from <employer_first_name> in the future.");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseFailureToProvideStatutoryRequirement"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Failure to Provide Statutory Requirement");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "In the case of _Nelson v. 977372 Ontario Inc. " +
                    "(c.o.b. Insta Insulation)_ [2013] O.J. No. 3182, the Defendant failed to provide the Plaintiff " +
                    "with a Record of Employment, which, like overtime pay is a statutory requirement. At trial, " +
                    "an award of punitive damages was awarded against the Defendant for its failure to issue the " +
                    "Record of Employment and to provide the Plaintiff with other statutory requirements. \n");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseReprisalOhsa"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Reprisal OHSA");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "Following her resignation from the health and " +
                    "safety commission, <client_first_name> was threatened with termination if she were to speak up regarding " +
                    "her safety concerns. In addition, four days following her resignation from the committee <client_first_name> " +
                    "was written up. Due to the temporal connection of these events, it is my position that " +
                    "<client_first_name> is being reprised for bringing to light issues regarding safety. This action is in " +
                    "contravention to the _Occupational Health and Safety Act_, RSO 1990, c O.1 (“OHSA”). %%" +
                    "Reprisal of employees is strictly prohibited by section 50(1) of the OHSA: %%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "No discipline, dismissal, etc., by employer%%" +
                    "50.  (1)  No employer or person acting on behalf of an employer shall,%%" +
                    "(a) dismiss or threaten to dismiss a worker;%%" +
                    "(b) discipline or suspend or threaten to discipline or suspend a worker;%%" +
                    "(c) impose any penalty upon a worker; or%%" +
                    "(d) intimidate or coerce a worker, " +
                    "because the worker has acted in compliance with this Act or the regulations or an order made " +
                    "thereunder, has sought the enforcement of this Act or the regulations or has given evidence " +
                    "in a proceeding in respect of the enforcement of this Act or the regulations or in an inquest " +
                    "under the Coroners Act. R.S.O. 1990, c. O.1, s. 50 (1).");
            insertText(llpf,doc,content,ParaCode.REG, "<employer_first_name>'s actions in addressing <client_first_name>'s " +
                    "legitimate concerns in an act of reprisal constitutes as an independent actionable wrong " +
                    "for which punitive, aggravated, and/or moral damages are justified. ");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUseAllegationsOfCause"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Punitive Damages - Allegations of Cause");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "\n" +
                    "In light of the above circumstances, it is my position that the allegations of cause were made " +
                    "with no reasonable basis and were made for tactical and financial gain considerations. In the " +
                    "recent decision in _Morison v, Ergo-Industrial Seating Systems Inc_., 2016 ONSC 6725, Justice " +
                    "Roger classified such conduct as “malicious, oppressive and high handed, and a marked departure " +
                    "from ordinary standards of decent behaviour.” For these reasons, Justice Roger awarded the " +
                    "Plaintiff $50,000.00 in punitive damages.   %%" +
                    "The serious allegations will certainly impede <client_first_name> efforts in finding new, comparable " +
                    "employment, and thus have had, and will continue to have, an adverse effect on him both " +
                    "mentally and financially. Compensation has been awarded at significantly higher rates, " +
                    "particularly in instances similar to this matter, wherein cause allegations have been brought " +
                    "forth absent proper substantiation. In _Tipple v. Canada (Attorney General)_, 2012 FCA 158, " +
                    "wherein an employee who had been terminated on assertions of misconduct was awarded $250,000.00 " +
                    "for loss of reputation arising from the allegations. \n");
        }

        this.setContents(content);
    }

}
