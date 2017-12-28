package document_generation.LawyersLetter.Sections;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Yale Wang
 */
public class AppropriateNoticePeriodSectionCopy extends LLSection {

    public AppropriateNoticePeriodSectionCopy(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(LLSectionCode.APPROPRIATE_NOTICE_PERIOD);

        ArrayList<LLParagraph> content = new ArrayList<>();

        //SQL RETRIEVAL
        this.setSql(this.getSectionCode().toString());
        HashMap<String, String>contents = dao.executeSelect(this.getSelectSql());
        
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,contents.get("1"));

        //body:
        insertText(llpf,doc,content,ParaCode.REG, contents.get("2"));
        insertText(llpf,doc,content,ParaCode.QUOTE, contents.get("3"));

        if(!doc.getFieldsMap().containsKey("age")){
        	doc.getFieldsMap().put("age", "40");
        }
        if(Integer.parseInt(doc.getFieldsMap().get("age"))>45 || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Age as Elongating Factor");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "<client_first_name>’s age is an important factor. " +
                    "_In Paquette v. TeraGo Networks Inc._, 2015 ONSC 4189 (varied to provide the employee bonus on appeal but not challenged on this point) justice Perell stated:"
                    + "%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "[31]           Generally speaking, a longer notice period will be justified for older long-term employees, who may be at a competitive disadvantage in securing new employment because of their age. In _McKinney v. University of Guelph_, 1990 CanLII 60 (SCC), [1990] 3 S.C.R. 229 at para. 92, Justice La Forest stated: "
            		+"Barring specific skills, it is generally known that persons over 45 have more difficulty finding work than others. They do not have the flexibility of the young, a disadvantage often accentuated by the fact that the latter are frequently more recently trained in the more modern skills. Their difficulty is also influenced by the fact that many in that age range are paid more and will generally serve a shorter period of employment than the young, a factor that is affected not only by the desire of many older people to retire but by retirement policies both in the private and public sectors."
            		+ "%%");
            insertText(llpf,doc,content,ParaCode.REG, "At the time in <possessive_pronoun> life when most Canadians would be " +
                    "contemplating retirement, <client_first_name> has found <object_pronoun>self dismissed without an adequate " +
                    "severance package after <seniority_in_years> years of productive service with <employer_first_name>, and having to seek " +
                    "alternative employment at an older age.");
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseNonSkilledPositions"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Position of Employee");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The case-law is clear that while employees in higher levels get a ‘bump up’ that those in lower levels are not given a ‘cap’ or a decrease in notice.%%"
					+"For instance in _Di Tomaso " +
                    "v. Crown Metal Packaging Canada LP, 2011_ ONCA 469, the Court of Appeal for Ontario held that " +
                    "employees in non-skilled or clerical positions could be awarded with an elongated notice period " +
                    "despite an employer’s attempt to use character of employment to minimize the reasonable notice " +
                    "period. Justice MacPherson asserted the following:%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "Crown Metal would emphasize the importance of " +
                    "the character of the appellant’s employment to minimize the reasonable notice to which he is " +
                    "entitled. I do not agree with that approach. Indeed, there is recent jurisprudence suggesting " +
                    "that, if anything, it is today a factor of declining relative importance: see Medis Health and " +
                    "Pharmaceutical Services Inc. v. Bramble (1999), 1999 CanLII 13124 (NB CA), 175 D.L.R. (4th) 385 " +
                    "(NBCA) (“Bramble”) and Vibert v. Paulin (2008), 2008 NBCA 23 (CanLII), 291 D.L.R. (4th) 302 (NBCA).%%" +
                    "%%" +
                    "This is particularly so if an employer attempts to use character of employment to say that " +
                    "low level unskilled employees deserve less notice because they have an easier time finding " +
                    "alternative employment. The empirical validity of that proposition cannot simply be taken " +
                    "for granted, particularly in today’s world. In Bramble, Drapeau J.A. put it this way, at para. 64:%%");
            insertText(llpf,doc,content,ParaCode.QUOTE, "The proposition that junior employees have an easier " +
                    "time finding suitable alternate employment is no longer, if it ever was, a matter of common " +
                    "knowledge. Indeed, it is an empirically challenged proposition that cannot be confirmed by " +
                    "resort to sources of indisputable accuracy.");
            
            insertText(llpf,doc,content,ParaCode.REG, "For instance in _Drysdale v. Panasonic Canada Inc._, 2015 ONSC 6878 a 23 year labourer was given 22 months notice by Justice Lederman. ");

        }

        if(Objects.equals(doc.getFieldsMap().get("isUseEconomicDownturn"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Economic Downturn");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "<client_first_name> faces the challenge of searching for new " +
                    "employment in a poor economic climate in Ontario. In _Paquette v. TeraGo Networks Inc._, 2015 " +
                    "ONSC 4189 (CanLII), the Court recognized that a poor economic climate may elongate an employee’s " +
                    "notice period. South-western Ontario and the GTA, in particular, have experienced a regional " +
                    "economic downturn, which was judicially recognized in _Zoldowski v. Strongco Corporation_, 2015 " +
                    "ONSC 5485.");
        }

        if(Objects.equals(doc.getFieldsMap().get("isFighting_cause"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Allegations of Cause");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The allegations of cause have also added an " +
                    "additional challenge for Warren in finding replacement employment, which, per the Court " +
                    "in Johar v. Best Buy Canada, 2016 ONSC 5287, justifies an elongation of the termination notice.\n");
        }

        boolean isExec = false;
        if (Objects.equals(doc.getFieldsMap().get("occupation_classification"), "Upper Management (>150k)")
        		|| Objects.equals(doc.getFieldsMap().get("occupation_classification"), "Middle Management (b/w 75k and 150k)")
				|| Objects.equals(doc.getFieldsMap().get("occupation_classification"), "Lower Management (<75k)")){
        	isExec = true;
        }
        if(!doc.getFieldsMap().containsKey("seniority_in_years")){
        	doc.getFieldsMap().put("seniority_in_years", "1");
        }
        if(Integer.parseInt(doc.getFieldsMap().get("seniority_in_years"))<5 && !isExec || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Short Term Employees");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "Furthermore, Courts have opened the possibility " +
                    "for short-term employees, as in Warren's case, to be provided with a longer reasonable notice " +
                    "period.  In Khan v. Fibre Glass-Evercoat Co. [2000] O.J. No. 1877, the Court , the Plaintiff " +
                    "who, like Warren, was terminated after one year of tenure on alleged performance issues, but " +
                    "was awarded 12 months' notice.\n");
        }
//Use Short term Employees - Executives
        if(Integer.parseInt(doc.getFieldsMap().get("seniority_in_years"))<5 && isExec || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Short Term Employees - Executives");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "The case of Felice v. Cardinal Health Canada Inc., " +
                    "2014 ONSC 1190, demonstrates that shorter tenured employees who hold executive roles, similar " +
                    "to Muhammad, are entitled to significantly elongated notice periods. In Felice, the Plaintiff " +
                    "was employed as a National Director, Supply Chain Management, for a total of 19 months. After " +
                    "taking into consideration the aforementioned Bardal factors, the Court found that the reasonable " +
                    "notice period for Mr. Felice was 12 months. Considering the parallel facts with the case at bar, " +
                    "it is highly likely that a court would award Muhammad a similar notice period to that in Felice. ");
        }

        if(Objects.equals(doc.getFieldsMap().get("isUseAppropriateNoticeConclusion"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Appropriate Notice Conclusion");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "In light of <client_first_name>’s age, position of seniority, " +
                    "length of service, the lack of comparable positions, and the current state of the economy, it " +
                    "is my position that <subjective_pronoun> would be entitled to at least XX months’ notice.");
        }//TODO: change xx to an equation

        if(Objects.equals(doc.getFieldsMap().get("isUseAppropriateNoticeAlternative"), "on") || doc.getFieldsMap().get("setAllParagraphs").equals("true")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Appropriate Notice Alternative - If Just Cause is Alleged" +
                    "and Client Provided No Notice");

            //body:
            insertText(llpf,doc,content,ParaCode.REG, "In the alternative, <client_first_name> is at least entitled " +
                    "to the minimum standards under the ESA, amounting to 8 weeks of pay in lieu of notice of " +
                    "termination, and an additional 15 weeks of severance pay. \n");
        }
        this.setContents(content);
    }

}
