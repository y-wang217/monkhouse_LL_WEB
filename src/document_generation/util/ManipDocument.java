/*
### created by Yale Wang ###


TODO refactor the doc carried through a method as static, to create once and passed.
 */
package document_generation.util;

import document_generation.LawyersLetter.LLDocument;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.ArrayList;

public class ManipDocument {

    public static void paragraphBreak(XWPFRun r) {

        r.addBreak();
        r.addBreak();
    }

    public static XWPFRun createRun(XWPFParagraph paragraph) {

        XWPFRun run = paragraph.createRun();
        run.setFontSize(12);
        run.setFontFamily("Times New Roman");
        return run;
    }
    
    public static XWPFRun createRun(XWPFParagraph paragraph, String font) {

        XWPFRun run = paragraph.createRun();
        run.setFontSize(12);
        run.setFontFamily(font);
        return run;
    }

    public static void tab(XWPFRun r) {

        tab(r, 1);
    }

    public static void tab(XWPFRun r, int tabs) {

        while (tabs != 0) {
            r.addTab();
            tabs--;
        }
    }

    public static void append(XWPFRun r, int lineBreaks, String text) {

        r.setText(text);
        while (lineBreaks != 0) {
            r.addCarriageReturn();
            lineBreaks--;
        }
    }

    public static void appendQuote(XWPFDocument doc, String text) {

        XWPFParagraph p = doc.createParagraph();
        p.setIndentFromLeft(650);
        p.setIndentFromRight(550);
        p.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun r = createRun(p);
        r.setFontSize(12);
        append(r, 0, text);
        r.addCarriageReturn();
    }

    public static void insertHeading(XWPFDocument doc, String text, boolean italics) {

        XWPFParagraph p = doc.createParagraph();
        XWPFRun r = createRun(p);
        append(r, 1, text);
        r.setBold(true);
        r.setItalic(italics);
    }

    public static void insertHeading(XWPFDocument doc, String text) {

        insertHeading(doc, text, false);
    }

    public XWPFDocument addHeader(XWPFDocument doc, String header) {

        XWPFHeader head = doc.createHeader(HeaderFooterType.DEFAULT);
        head.createParagraph().createRun().setText(header);
        return doc;
    }

    public XWPFDocument addFooter(XWPFDocument doc, String header) {

        XWPFFooter foot = doc.createFooter(HeaderFooterType.DEFAULT);
        foot.createParagraph().createRun().setText("footer");
        return doc;
    }
    public static void addImage(XWPFDocument doc, String imageFile) {

        XWPFParagraph p = doc.createParagraph();
    
        addImage(p, imageFile);
    }

    public static void addImage(XWPFParagraph p, String imageFile) {

        XWPFRun r = createRun(p);

        String[] images = new String[1];
        images[0] = imageFile;

        for (String imgFile : images) {
            int format;

            if (imgFile.endsWith(".emf")) format = XWPFDocument.PICTURE_TYPE_EMF;
            else if (imgFile.endsWith(".wmf")) format = XWPFDocument.PICTURE_TYPE_WMF;
            else if (imgFile.endsWith(".pict")) format = XWPFDocument.PICTURE_TYPE_PICT;
            else if (imgFile.endsWith(".jpeg") || imgFile.endsWith(".jpg")) format = XWPFDocument.PICTURE_TYPE_JPEG;
            else if (imgFile.endsWith(".png")) format = XWPFDocument.PICTURE_TYPE_PNG;
            else if (imgFile.endsWith(".dib")) format = XWPFDocument.PICTURE_TYPE_DIB;
            else if (imgFile.endsWith(".gif")) format = XWPFDocument.PICTURE_TYPE_GIF;
            else if (imgFile.endsWith(".tiff")) format = XWPFDocument.PICTURE_TYPE_TIFF;
            else if (imgFile.endsWith(".eps")) format = XWPFDocument.PICTURE_TYPE_EPS;
            else if (imgFile.endsWith(".bmp")) format = XWPFDocument.PICTURE_TYPE_BMP;
            else if (imgFile.endsWith(".wpg")) format = XWPFDocument.PICTURE_TYPE_WPG;
            else {
                System.err.println("Unsupported picture: " + imgFile +
                        ". Expected emf|wmf|pict|jpeg|png|dib|gif|tiff|eps|bmp|wpg");
                continue;
            }

            r.addBreak();
            try {
                //change the dimensions of a picture being added
                r.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(497), Units.toEMU(92));
                r.addBreak();
            } catch (InvalidFormatException e) {
                System.err.println("invalid format Exception");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("io exception");
                e.printStackTrace();
            }

        }

    }

    public XWPFDocument addSalutation(XWPFDocument doc) {

        return doc;
    }

    public static void main(String[] args) throws IOException {

        XWPFDocument doc = new XWPFDocument();

        ManipDocument.addImage(doc, "/Users/monkhousemacbook6/Pictures/monkhouse_header.png");

        XWPFParagraph p = doc.createParagraph();

        XWPFRun r = createRun(p);
        append(r, 0, "Date: ");
        //r.addBreak(BreakType.TEXT_WRAPPING);

        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.RIGHT);
        r = createRun(p);
        append(r, 1, "<name of monkhouse lawyer>");
        r.setBold(true);
        r = createRun(p);
        append(r, 0, "<lawyer's email>@monkhouselaw.com");
        r.setBold(true);

        p = doc.createParagraph();
        //p.setAlignment(ParagraphAlignment.LEFT);
        r = createRun(p);
        append(r, 2, "Personal, Confidential & Without Prejudice");
        r.setBold(true);
        r.setUnderline(UnderlinePatterns.SINGLE);
        r = createRun(p);
        append(r, 1, "Via Personal Service");
        r.setBold(true);

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 1, "<recipient first name last name>");
        r.setBold(true);
        r = createRun(p);
        append(r, 1, "<recipient job title>");
        append(r, 1, "<company name>");
        append(r, 1, "<company address>");
        append(r, 3, "<company postal code>");

        r = createRun(p);
        append(r, 2, "To <Honorific> <recipient's last name>");

        r = createRun(p);
        append(r, 1, "Re:    <title of case>");
        r.setBold(true);

/*
Description of Case, I wish to confirm that ...
*/
        p = doc.createParagraph();
        r = createRun(p);
        append(r, 3, "I wish to confirm that I have been retained as legal counsel on behalf of <Client first name last name> (“<Client First Name>”)." +
                "I have reviewed the circumstances surrounding <Client first name>’s termination, and it is my position that he has been wrongfully " +
                "dismissed in that he was terminated without sufficient cause, and as such is entitled to reasonable pay in lieu of notice " +
                "of the termination of his employment. ");
/*
The salient facts of this are:
*/

        r = createRun(p);
        append(r, 2, "The salient factors of this case are:");
        tab(r);
        append(r, 1, "Seniority: <#> years");
        tab(r);
        append(r, 1, "Wage: $<###,###.##>");
        tab(r);
        append(r, 1, "Age: <##>");
        tab(r);
        append(r, 1, "Position: <client's position>");

        insertHeading(doc, "<Client's first name>'s Employment");

        insertHeading(doc, "Insufficient Cause for Termination");

        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.BOTH);
        r = createRun(p);
        append(r, 0, "Although ERS is attempting to rely on allegations of just cause to substantiate " +
                "Luke’s termination, it is my position that this argument is meritless due to the lack of support for " +
                "same, and the corresponding failure to meet the high threshold required. When determining if there " +
                "is sufficient cause for termination, the courts have routinely held that it is important to distinguish " +
                "between actions demonstrating poor judgment, warranting discipline, and actions that are incompatible " +
                "with the employment relationship continuing, warranting termination. As Iacobucci, J. held in " +
                "McKinley v. BC Tel, [2001] 2 SCR 161, the proper approach in making this determination is a contextual " +
                "one, regarding how the dishonesty or misconduct impacts the employment relationship. He described " +
                "the proper framework as: ");
        r.addCarriageReturn();

        appendQuote(doc, "An analytical framework that examines each case on its own particular facts and " +
                "circumstances, and considers the nature and seriousness of the dishonesty in order to assess " +
                "whether it is reconcilable with sustaining the employment relationship.");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "The context of Luke’s employment must be taken into consideration; he worked " +
                "diligently for ERS for approximately ten years. While there were occasional times when Luke was " +
                "slightly late to work, he informs me that this was quite common with all employees, and in the " +
                "context, would therefore not irreparably damage a working relationship.");
        append(r, 1, "It is also my position that this is a scenario where the implementation of " +
                "progressive discipline would be required. As noted, Luke received a written warning regarding " +
                "tardiness at the same time he received his notice of termination. Providing an employee with a " +
                "warning for their behaviour and simultaneously terminating them renders the warning redundant, " +
                "and does not equate to progressive discipline. Luke was never given the opportunity to correct " +
                "any behaviour that could have been cause for concern, because he was terminated at the same " +
                "time he was notified of those concerns. As held in the case of Plester v. Polyone Canada Inc., 2011 " +
                "ONSC 6068 (CanLII), in order to establish just cause on the basis of misconduct, ");

        appendQuote(doc, "[I]n addition to providing that the misconduct is serious, the employer must " +
                "demonstrate, and this is the aspect of the standard which distinguishes it from ‘just cause’, " +
                "that the conduct complained of is ‘wilful.’  Careless, thoughtless, heedless, or inadvertent conduct, " +
                "no matter how serious, does not meet the standard.  Rather, the employer must show that the " +
                "misconduct was intentional or deliberate. The employer must show that the employee purposefully " +
                "engaged in conduct that he or she knew to be serious misconduct.  It is, to put it, colloquially, " +
                "being bad on purpose.");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "Luke cannot be said to have engaged in wilful misconduct as he was completely unaware " +
                "that his actions would result in his termination. Luke genuinely enjoyed his job, and had invested ten years with " +
                "the company. Luke would never deliberately engage in conduct that would jeopardize his employment, and " +
                "had he received the courtesy of a warning or a discussion with Ali, he would have immediately corrected his behaviour. ");

        append(r, 1, "Considering the lack of progressive discipline involved, and the high threshold required, it is clear that ERS has " +
                "failed to meet the strict legal tests in place that an employer must satisfy in order to terminate an employee for just cause. " +
                "In the absence of same, Luke would be entitled to reasonable common law notice of the termination of his employment.");
//Invalid Contract
        insertHeading(doc, "Invalid Contract");

        insertHeading(doc, "Appropriate Notice Period");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "The appropriate notice period is based on a holistic examination of how long it would reasonably " +
                "take for an employee to get a new job. The most reliable method of knowing how long someone would get for their notice " +
                "period is based on how long similarly situated persons have taken based on seniority and other factors.");
        append(r, 1, "In assessing the reasonable notice period for breach of an employment contract, " +
                "courts in Ontario and elsewhere have followed the leading case of Bardal v. Globe & Mail Ltd. " +
                "[1960], O.J. No. 149 (Ont. H.C.J.) and the often-cited dictum of Chief Justice McRuer at p. 145:");
        appendQuote(doc, "There can be no catalogue laid down as to what is reasonable notice in particular classes of cases. " +
                "The reasonableness of the notice must be decided with Constants to each particular case, having regard to the " +
                "character of the employment, the length of service of the servant, the age of the servant and the availability " +
                "of similar employment, having regard to the experience, training and qualifications of the servant.");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 1, "In light of Luke’s age, length of service, level of education, the allegations of cause against " +
                "him, the lack of comparable positions, and the current state of the economy, he would be entitled to an elongated notice period.");

        insertHeading(doc, "Human Rights Violations");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "Considering the lack of legitimate reasoning behind his termination, Luke is concerned that his " +
                "termination was due, at least in part, to discrimination under a protected ground of the Ontario Human Rights Code, " +
                "R.S.O. 1990, c H.19 (the “Code”).  As noted, Luke’s grandmother passed away on Thursday February 23, 2017. Luke took " +
                "the following morning off work, and became ill over the weekend which required him to take a sick day on Monday February 27, " +
                "2017. Within an hour of reporting his illness to ERS, Luke was informed of his suspension without pay for the remainder of the " +
                "week. Suspending an employee because they are ill and unable to work is a clear act of discrimination under the protected " +
                "ground of disability.");
        append(r, 2, "Furthermore, Luke informs me that over the past few months, his boss, Ali, has been terminating the " +
                "Black employees at ERS, and only hiring Filipino people in their stead. This is discriminatory conduct under the " +
                "protected ground of race, and also supports the position that Luke’s termination for just cause was a cover to " +
                "facilitate his departure from the company. ");
        append(r, 1, "Pursuant to section 5(1) of the Code:");
        appendQuote(doc, "Every person has a right to equal treatment with respect to employment without discrimination " +
                "because of race, ancestry, place of origin, colour, ethnic origin, citizenship, creed, sex, sexual orientation, " +
                "gender identity, gender expression, age, record offences, marital status, family status or disability.");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 1, "Despite any arguments to the contrary, jurisprudence is clear that the protected ground " +
                "need not be the only factor in the decision to terminate an employee. As stated in Douglas v. SLH Transport " +
                "Inc. [2010] C.H.R.D. No 1:");
        appendQuote(doc, "It is not necessary that discriminatory considerations be the sole reason for the actions " +
                "in issue for a complaint to succeed. It is sufficient that the discrimination be but one basis for the " +
                "employer’s actions or decisions.");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 1, "In other words, despite any assertions that ERS did not discriminate against Luke, " +
                "the discriminatory action only needs to be a contributing factor in the decision to terminate in order " +
                "to be a violation of the Code.");

        insertHeading(doc, "Punitive, Aggravated, Bhasin, and/or Moral Damages");

        insertHeading(doc, "Failure to Investigate");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "Luke was suspended immediately after calling in sick to work on February 27, 2017. " +
                "After Ali rebuffed Luke’s attempts to discuss this decision on February 28, 2017, he went home and received " +
                "his notice of termination and a written warning that were dated February 27 and 28, respectively. ");
        append(r, 2, "The immediate decision to terminate Luke without having so much as a discussion or " +
                "interview regarding the allegations against him confirms that ERS did not conduct an adequate or fair " +
                "investigation into the matter. Luke was flat out refused an opportunity to defend himself, or detail his " +
                "side of the story. Had there been a thorough investigation, it would have been apparent that Luke’s actions " +
                "did not amount to wilful misconduct, and he would still be employed by ERS today.");
        append(r, 1, "The requirement of an investigation being conducted by an employer wherein allegations " +
                "of just cause exist is illustrated in the case of van WoerCamilles v. Marriot Hotels of Canada Ltd., " +
                "2009 BCSC 73 (CanLII):");

        appendQuote(doc, "An employer that fails to conduct an adequate and fair investigation into an allegation " +
                "of sexual harassment or other misconduct and does not afford the employee a reasonable opportunity to " +
                "respond to the allegations of misconduct, runs the risk that it may not be able to discharge the " +
                "burden of establishing cause for dismissal. [Emphasis added]");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 1, "A failure to complete its due diligence with respect to the allegations against " +
                "Luke is conduct worthy of punitive damages. ERS’s disregard for this obligation has had a severe and " +
                "negative impact on Luke and his professional reputation, and therefore can only be considered an " +
                "independent, actionable wrong.");

        insertHeading(doc, "Unsubstantiated Allegations of Cause");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "Alleging cause for termination, when clearly no such cause existed is not only an " +
                "aggravating factor in terms of elongating Luke’s reasonable notice period, it is also high-handed and " +
                "malicious conduct. Allegations of insubordination and violations of company policies will also impede " +
                "Luke’s efforts at finding new, comparable employment, and thus will have an adverse effect on him both " +
                "mentally and financially.");
        append(r, 1, "Compensation has been awarded at significantly high rates, particularly in " +
                "instances similar to this matter, wherein cause allegations have been brought forth absent proper " +
                "substantiation. For example, I would point you to the decision in Tipple v. Canada (Attorney General), " +
                "2012 FCA 158, wherein an employee who had been terminated on assertions of misconduct was awarded " +
                "$250,000.00 for loss of reputation arising from the allegations.");

        insertHeading(doc, "Bad Faith Damages");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "The case of Ashton v. Perle Systems Ltd., 1994 CanLII 7404 (ON SC) supports " +
                "the position that an employer has an obligation to carry out an employee’s dismissal in an open " +
                "and honest manner, and to avoid unwarranted harm to the employee. Terminating Luke on " +
                "unsubstantiated allegations of cause without providing any sort of progressive discipline, and leaving " +
                "him without any income is indicative of dishonest, malicious behaviour and displays ERS’s blatant " +
                "disregard for Luke’s well-being.");
        append(r, 1, "ERS’s aforementioned actions would also result in the award of “bad faith” " +
                "damages as categorized in the case of Bhasin v. Hrynew 2014 SCC 7. As per Bhasin, parties to a " +
                "contract are under a duty to act honestly in the performance of their contractual obligations. " +
                "ERS’s conduct in terminating Luke due to discriminatory reasons, and relying on frivolous allegations " +
                "of cause to support his termination, depicts an utmost degree of bad faith conduct which would warrant " +
                "a high quantum of damages should this matter proceed to trial.");

        insertHeading(doc, "Moving Forward");

        p = doc.createParagraph();
        r = createRun(p);
        append(r, 2, "I have advised Luke that given the circumstances, he has a significant claim " +
                "for wrongful dismissal, human rights violations, and punitive, aggravated, Bhasin, and/or moral " +
                "damages in consideration of the factors discussed above.");
        append(r, 2, "Notwithstanding the attached Statement of Claim, and in an effort to resolve " +
                "the matter in good faith, Luke has informed me that he would be willing to settle this matter on " +
                "the following conditions:");

//list of settlement conditions
        Numbering.insertNumberedList((LLDocument)doc, "The sum of $32,900.00 representing 12 months’ pay in lieu of notice;@" +
                "Compensation accounting for 20% of benefits over the 12-month notice period in the amount of $6,580.00;@" +
                "The sum of $20,000.00 in general damages in lieu of human rights violations;@" +
                "The sum of $20,000.00 in general damages in lieu of punitive, aggravated, Bhasin, and/or moral damages;@" +
                "A favourable reference letter and glowing letter of recommendation;@" +
                "A contribution of $500.00 towards career counselling;@" +
                "Partial indemnity fees as agreed or assessed to the date of acceptance of offer " +
                "(estimate currently $3,000.00) towards Luke’s legal fees.");
        r.addCarriageReturn();

        append(r, 2, "For a total monetary offer of $82,980 at this point in time.");
        append(r, 2, "This offer will remain open until trial. We intend to rely on this letter as " +
                "an official Rule 49 offer should this matter go to trial in order to seek substantial indemnity costs.");
        append(r, 2, "Sincerely,");
        append(r, 4, "Monkhouse Law,");

        paragraphBreak(r);

        FileOutputStream out = new FileOutputStream("letter.docx");
        doc.write(out);
        out.close();
        doc.close();

    }
}
