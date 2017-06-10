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
public class FightingCauseSection extends LLSection{

    public FightingCauseSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.FIGHTING_CAUSE);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content,ParaCode.HEAD,"Fighting Cause");


        if(Objects.equals(doc.getFieldsMap().get("fighting_cause"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Fighting Cause - High Standard");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "As I am sure you are aware, the standard for just " +
                    "cause is very high. As per Regulation 288/01 section 2(1) (3) of the Employment Standards Act, " +
                    "2000, only a finding of “wilful misconduct” will be sufficient to support a termination with " +
                    "just cause. The punishment must fit the offence and other alternatives, such as progressive " +
                    "discipline, must have been contemplated. For instance in Bravo v. Etobicoke Ironworks Ltd. " +
                    "[2005] O.J. No. 2070, an employee stole company property and was found to have sworn at <possessive_pronoun> " +
                    "boss for no reason. These two incidents combined were not just cause. The termination was not " +
                    "proportionate to the offence and so the argument failed. %%" +
                    "%%" +
                    "Even in the case of Beard v. Suite Collections Canada Inc. [2006] O.J. No.5736, wherein the " +
                    "Plaintiff, a manager who had been absent from work and accused of sexual harassment of a " +
                    "subordinate, just cause was not established. The court, in their decision to award the Plaintiff " +
                    "notice, referenced the case of Kane v. University of British Columbia, [1980] 1 S.C.R. 1105, " +
                    "in which Dickson J. noted that a “high standard of justice is required when the right to continue " +
                    "in one’s profession or employment is at stake.” The court further went on to note that despite " +
                    "the Plaintiff’s inappropriate conduct, even in <possessive_pronoun> position of seniority, that a clear warning " +
                    "that the behavior was unacceptable had not been provided.%%" +
                    "%%" +
                    "As I’m sure you are aware, the standard for just cause is very high. The court in Boulet v. " +
                    "Federated Co-operatives Ltd. [2001] M.J. No.306 outlined the following criteria to be met in " +
                    "order for an employer to rely on performance issues as the reason for termination at paragraph " +
                    "5 of their decision:");
            insertText(llpf,doc,content,ParaCode.QUOTE, "(a) the level of the job performance required, %%" +
                    "(b) that the standard was communicated to the employee, %%" +
                    "(c) that suitable instruction and/or supervision was given to enable the employee to meet the standard, %%" +
                    "(d) the employee was incapable of meeting the standard, and %%" +
                    "(e) the employee was warned that failure to meet the standard would result in dismissal.%%");

            insertText(llpf,doc,content,ParaCode.REG, "In Henson v. Champion Feed Services Ltd., [2005] A.J. " +
                    "No. 323, and reiterated in Gillespie v. 1200333 Alberta Ltd., 2001 ABPC (CanLii), the Courts " +
                    "have discussed the requirement for progressive disciple in cases of cumulative cause for " +
                    "termination. Particularly, at paragraph 21 Gillespie states:%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "[W]here cumulative cause for dismissal for " +
                    "incompetence is alleged, the employer must prove:%%" +
                    "1. The employee was given express and clear warnings about <possessive_pronoun> performance;%%" +
                    "2. The employee was given a reasonable opportunity to improve <possessive_pronoun> performance after the warning was issued;%%" +
                    "3. Notwithstanding the foregoing, the employee failed to improve <possessive_pronoun> performance;%%" +
                    "4. The cumulative failings “would prejudice the proper conduct of the employer’s business.");

            insertText(llpf,doc,content,ParaCode.REG, "As held in the case of Plester v. Polyone Canada " +
                    "Inc., 2011 ONSC 6068 (CanLII), in order to establish just cause on the basis of misconduct:%%" +
                    "%%" +
                    "[I]n addition to providing that the misconduct is serious, the employer must demonstrate, and " +
                    "this is the aspect of the standard which distinguishes it from ‘just cause’, that the conduct " +
                    "complained of is ‘wilful’.  Careless, thoughtless, heedless, or inadvertent conduct, no matter " +
                    "how serious, does not meet the standard.  Rather, the employer must show that the misconduct was " +
                    "intentional or deliberate.  The employer must show that the employee purposefully engaged in " +
                    "conduct that he or she knew to be serious misconduct.  It is, to put it, colloquially, being " +
                    "bad on purpose.%%" +
                    "%%" +
                    "At common law, proportionality must be applied to terminations. In other words, the punishment " +
                    "must fit the offence and other alternatives, such as progressive discipline, must have been " +
                    "contemplated. As Justice Iacobucci held in McKinley v. BC Tel, [2001] 2 SCR 161, the proper " +
                    "approach in making this determination is a contextual one, regarding how the dishonesty or " +
                    "misconduct impacts the employment relationship. He described the proper framework as: ");
            insertText(llpf,doc,content,ParaCode.QUOTE, "An analytical framework that examines each case " +
                    "on its own particular facts and circumstances, and considers the nature and seriousness of the " +
                    "dishonesty in order to assess whether it is reconcilable with sustaining the employment relationship.");

            insertText(llpf,doc,content,ParaCode.REG, "For instance, in Bravo v. Etobicoke Ironworks Ltd. " +
                    "[2005] O.J. No. 2070, an employee stole company property and was found to have sworn at his boss " +
                    "for no reason. These two incidents combined were not just cause. The termination was not " +
                    "proportionate to the offence and so the argument failed. \n");
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseGrossIncompetence"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Performance Issues - Gross Incompetence");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The standard for cause terminations based on performance is "
            		+ "higher still, the standard is gross incompetence. For example, as cited in Brien v. Niagara "
            		+ "Motors Ltd. [2008] O.J. No. 3246 at para. 226:");
            insertText(llpf,doc,content,ParaCode.QUOTE, "…The level of incompetence to justify summary " +
                    "dismissal is that of “gross incompetence”. If incompetence is not gross, then notice must be " +
                    "given. The employee should be given a fair opportunity to remedy the alleged incompetence and " +
                    "prove that he or she can perform in the position. It is the employer’s burden to prove:");
            insertText(llpf,doc,content,ParaCode.QUOTE, "(1) It has established reasonable objective standards of performance; %%" +
                    "(2) The employee has failed to meet those standards; %%" +
                    "(3) The employee has had warning that he has failed to meet those standards and that the " +
                    "employee’s position with the employer will be in jeopardy if he continues to fail to meet the standards; and %%" +
                    "(4) That reasonable time was afforded to correct the situation.");
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseJobAbandonmentDamageAwarded"), "on")){
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Fighting Cause - Standard for Job Abandonment Not Met");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "<employer_first_name> alleges that <client_first_name> abandoned or quit " +
                    "<possessive_pronoun> position, which is untrue. <client_first_name> was on leave when <subjective_pronoun> was alerted to " +
                    "<possessive_pronoun> termination, and on multiple occasions <subjective_pronoun> attempted to contact <employer_first_name> " +
                    "regarding the status of <possessive_pronoun> employment. During this time, <client_first_name> tried to return to " +
                    "work to discuss the matter but was denied from doing so." +
                    "%%" +
                    "The case of Koos v. A&A Contract Customs Brokers Ltd. 2009 BCSC 563 supports the position " +
                    "that an employer has a duty to look into the absence of an employee, and not to immediately " +
                    "conclude that such actions are job abandonment. The test for determining whether or not an " +
                    "employee has resigned or abandoned their position is objective. The examiner must determine " +
                    "from the facts at hand whether a reasonable person would find the actions of the employee to " +
                    "be indicative of resignation. Considering <client_first_name>’s persistent efforts to enquire about the " +
                    "status of <possessive_pronoun> job, and even attempt to return to work, it is clear that any argument of " +
                    "job abandonment holds no merit. As such, it is my position that <client_first_name> has been wrongfully " +
                    "terminated, and is owed significant notice. ");
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseJobAbandonmentDamageAwarded"), "on")){
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "<employer_first_name> alleges that <client_first_name> abandoned or quit " +
                    "<possessive_pronoun> position, which is untrue. <client_first_name> was on leave when <subjective_pronoun> was alerted to " +
                    "<possessive_pronoun> termination, and on multiple occasions <subjective_pronoun> attempted to contact [EMPLOYER] " +
                    "regarding the status of <possessive_pronoun> employment. During this time, <client_first_name> tried to return to " +
                    "work to discuss the matter but was denied from doing so." +
                    "%%" +
                    "The case of Koos v. A&A Contract Customs Brokers Ltd. 2009 BCSC 563 supports the position " +
                    "that an employer has a duty to look into the absence of an employee, and not to immediately " +
                    "conclude that such actions are job abandonment. The test for determining whether or not an " +
                    "employee has resigned or abandoned their position is objective. The examiner must determine " +
                    "from the facts at hand whether a reasonable person would find the actions of the employee to " +
                    "be indicative of resignation. Considering <client_first_name>’s persistent efforts to enquire about the " +
                    "status of <possessive_pronoun> job, and even attempt to return to work, it is clear that any argument of " +
                    "job abandonment holds no merit. As such, it is my position that <client_first_name> has been wrongfully " +
                    "terminated, and is owed significant notice. ");
        }
        this.setContents(content);
    }

}
