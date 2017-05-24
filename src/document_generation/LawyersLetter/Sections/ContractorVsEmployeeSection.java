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
public class ContractorVsEmployeeSection extends LLSection{

    public ContractorVsEmployeeSection(LLDocument doc, LLParagraphFactory llpf){

        this.setSectionCode(SectionCode.CONTRACTOR_VS_EMP);

        ArrayList<LLParagraph> content = new ArrayList<>();
        //heading:
        insertText(llpf,doc,content, ParaCode.HEAD,"Contractor vs Employee");

        //TODO keep flag in doc to track which paragraph is needed
        if(Objects.equals(doc.getFieldsMap().get("isUseIndependentContractorVsEmployee"), "on")){
//heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Independent Contractor vs Employee");
            //body:
            insertText(llpf,doc,content,ParaCode.REG, "Despite the fact that <employer_first_name> labelled <client_first_name> an " +
                    "independent contractor, based upon the relationship carried on between the parties, <client_first_name> was " +
                    "actually an employee.%%" +
                    "Jurisprudence is clear that it is the substance of the relationship that determines the employment " +
                    "status of the worker. In Mckee v. Reid’s Heritage Homes Ltd., 2009 ONCA 916, the court outlined the " +
                    "following five principles for determining whether a worker is an employee or a contractor:");

            insertText(llpf,doc,content,ParaCode.QUOTE, "1. Whether or not the agent was limited exclusively " +
                    "to the service of the principal;%%" +

                    "2. Whether or not the agent is subject to the control of the principal, not only as to the product " +
                    "sold, but also as to when, where and how it is sold;%%" +

                    "3. Whether or not the agent has an investment or interest in what are characterized as the “tools” " +
                    "relating to <possessive_pronoun> service;%%" +

                    "4. Whether or not the agent has undertaken any risk in the business sense or, alternatively, has " +
                    "any expectation of profit associated with the delivery of <possessive_pronoun> service as distinct from a fixed commission;%%" +

                    "5. Whether or not the activity of the agent is part of the business organization of the principal " +
                    "for which he works. In other words, whose business is it?");

        }
        if(Objects.equals(doc.getFieldsMap().get("isUseDependentContractor"), "on")){

            //heading:
            insertText(llpf,doc,content, ParaCode.HEAD,"Dependent Contractor");
            //body
            insertText(llpf,doc,content,ParaCode.REG, "Even if <client_first_name> is found to be a contractor, this " +
                    "does not necessarily disentitle them to notice for the termination of their employment. In 671122 " +
                    "Ontario Ltd. v. Sagaz Industries Canada Inc., 2001 SCC 59, with respect to the independent versus " +
                    "dependent contractor determination the Supreme Court stated, at para. 11:");
            insertText(llpf,doc,content,ParaCode.QUOTE, "The next step, required only if the first step results " +
                    "in a contractor conclusion, determines \twhether the contractor is independent or dependent, for " +
                    "which a worker’s exclusivity is \tdeterminative, as it demonstrates economic dependence.");
            insertText(llpf,doc,content,ParaCode.REG, "Based on these facts and the above jurisprudence, " +
                    "a court may deem <client_first_name> to be an employee or a the very least a dependent contractor, which " +
                    "would still entitle her to payment up to the end of her term. Furthermore, should the court find " +
                    "that she is not entitled to the remainder of her salary till the end of the term of the contract, " +
                    "she will be entitled to reasonable common law notice.");

        }


        this.setContents(content);
    }

}
