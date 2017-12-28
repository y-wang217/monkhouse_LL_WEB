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
public class OvertimeSection extends LLSection {

    public OvertimeSection(LLDocument doc, LLParagraphFactory llpf) {

        this.setSectionCode(LLSectionCode.OVERTIME);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf, doc, content, ParaCode.HEAD, "Overtime");

        //TODO keep flag in doc to track which paragraph is needed
        if (Objects.equals(doc.getFieldsMap().get("isUseClc"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Overtime - CLC");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "<client_first_name>’s position <position> was managerial in " +
                    "title only. <client_first_name> informs me that <possessive_pronoun> position frequently involved sales oriented tasks. " +
                    "Such sales oriented tasks were of a non-managerial and non-supervisory nature and had been " +
                    "performed on a non-irregular and non-exceptional basis. <client_first_name> held a position that demanded " +
                    "consistent performance and long hours. <client_first_name> worked approximately (<hoursWorkedPerWeek>) hours per " +
                    "week. <client_first_name> was not provided additional compensation for the time that he had worked in " +
                    "excess of forty (40) hours. As per section 169 (1) of the CLC (emphasis added):");
            insertText(llpf,doc,content,ParaCode.QUOTE, "Except as otherwise provided by or under this Division%%" +
                    "(a)\tthe standard hours of work of an employee shall not exceed eight hours in a day and forty hours in a week; and%%" +
                    "(b)\tno employer shall cause or permit an employee to work longer hours than eight hours in any day or forty hours in any week.%%");
            insertText(llpf,doc,content,ParaCode.REG, "Regardless of any argument disentitling <client_first_name> to " +
                    "overtime, the mere fact that the overtime was performed is considered authorization from <employer_first_name>.%%" +
                    "%%" +
                    "<client_first_name> is owed overtime pay at a rate of not less than one and one-half time <possessive_pronoun> regular rate " +
                    "of wages. As per section 174 of the CLC:\n");

            insertText(llpf,doc,content,ParaCode.QUOTE, "When an employee is required or permitted to " +
                    "work in excess of the standard hours of work, the employee shall, subject to any regulations " +
                    "made pursuant to section 175, be paid for the overtime at a rate of wages not less than one " +
                    "and one-half times his regular rate of wages.");
            insertText(llpf,doc,content,ParaCode.REG, "<client_first_name> informs me that he worked approximately " +
                    "(<hoursWorkedPerWeek>) hours per week on average while employed by <employer_first_name>. This equates to approximately " +
                    "<hoursOvertimeOwed> overtime hours since <client_first_name> had been promoted to Technical Sales engineering Manager. " +
                    "Accounting for <client_first_name>’s rate of overtime pay ($<hourlyWage> x 1.5 or $<overtimeHourlyWage>/hour), this would equate " +
                    "to a total amount owing of $<overtimeOwed>.00. %%" +
                    "In the alternative, <client_first_name> would, at the very least, be entitled to ‘straight time’ for " +
                    "these hours worked, in accordance with the principle of Quantum Meruit, which would equate " +
                    "to $<alternativeOvertimeOwed> owing to <client_first_name>.");
        }

        if (Objects.equals(doc.getFieldsMap().get("isUsePerformanceOntario"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")) {
            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Overtime - Performance Ontario");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "Throughout <possessive_pronoun> employment at <employer_first_name>, " +
                    "<client_first_name> was routinely required to work between 55 and 60 hours per week without receiving " +
                    "overtime compensation. <client_first_name>’s regular work hours were from 8:00 am to 5:00 pm on weekdays; " +
                    "however, <subjective_pronoun> would often continue working well past this time. <client_first_name> would also work " +
                    "on weekends when it was necessary. Regardless of this, <client_first_name> was not paid for any work " +
                    "completed in excess of 44 hours per week. <client_first_name> lack of compensation for this work contravenes " +
                    "section 22 (1) of The _Employment Standards Act_, 2000, (“ESA”) which states:%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "“An employer shall pay an employee overtime pay of " +
                    "at least one and one-half times his or her regular rate for each hour of work in excess of " +
                    "44 hours in each work week”%%");

            insertText(llpf,doc,content,ParaCode.REG, "Furthermore, pursuant to Ontario Regulation 285/01, " +
                    "<client_first_name> would, in accordance with section 6(1), still be entitled to overtime pay as the " +
                    "overtime was nonetheless performed:%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "Subject to subsection (2), work shall be deemed " +
                    "to be performed by an employee for the employer,%%" +
                    "(a) where work is,%%" +
                    "%%" +
                    "(i) permitted or suffered to be done by the employer, or%%" +
                    "%%" +
                    "(ii) in fact performed by an employee although a term of the contract of employment expressly " +
                    "forbids or limits hours of work or requires the employer to authorize hours of work in advance;");

            insertText(llpf,doc,content,ParaCode.REG, "Regardless of any argument disentitling <client_first_name> " +
                    "to overtime, the mere fact that the overtime was performed is considered authorization from <employer_first_name>.");
        }

        this.setContents(content);
    }

}
