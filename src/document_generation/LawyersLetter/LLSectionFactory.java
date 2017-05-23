package document_generation.LawyersLetter;

import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.LawyersLetter.Sections.*;

/**
 * Created by Yale Wang
 *
 * TODO: currently, text is hard-coded into setters. Eventually move to extracting from DB
 */
public class LLSectionFactory {

    private static final LLParagraphFactory llpf = new LLParagraphFactory();

    public LLSection getSection(LLDocument doc, SectionCode type){

        switch(type){
            case IMG: return new HeaderImageSection(doc, llpf);
            case OPENING: return new OpeningSection(doc, llpf);
            case ADDRESSEE: return new AddresseeSection(doc, llpf);
            case RE:return new ReCaseSection(doc, llpf);
            case EMP_DESC: return new EmploymentDescriptionSection(doc, llpf);
            case TERMINATION: return new TerminationSection(doc, llpf);
            case CUSTOM: return new CustomSection(doc, llpf);
            case CONSTRUCTIVE_DISMISSAL: return new ConstructiveDismissalSection(doc, llpf);
            case BONUS: return new BonusesSection(doc, llpf);
            case FIGHT_TERMINATION_CLAUSE: return new FightTerminationClauseSection(doc, llpf);
            case FIGHTING_CAUSE: return new FightingCauseSection(doc, llpf);
            case CONTRACTOR_VS_EMP: return new ContractorVsEmployeeSection(doc, llpf);
            case PENSION: return new PensionsSection(doc, llpf);
            case APPROPRIATE_NOTICE_PERIOD: return new AppropriateNoticePeriodSection(doc, llpf);
            case INDUCEMENT: return new InducementSection(doc, llpf);
            case HARASSMENT: return new HarassmentSection(doc, llpf);
            case HUMAN_RIGHTS_DIS: return new HumanRightsDiscriminationSection(doc, llpf);
            case PUNITIVE_DMGS: return new PunitiveDamagesSection(doc, llpf);
            case OVERTIME: return new OvertimeSection(doc, llpf);
            case MOVING_FWD: return new MovingForwardSection(doc, llpf);
            case LTD_JURISPRUDENCE: return new LTDJurisprudenceSection(doc, llpf);
            case CLOSE: return new ClosingSection(doc, llpf);
            default: return new LLSection();
        }
    }

}
