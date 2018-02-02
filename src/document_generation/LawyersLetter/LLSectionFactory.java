package document_generation.LawyersLetter;

import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.Sections.*;

/**
 * Created by Yale Wang
 *
 * TODO: currently, text is hard-coded into setters. Eventually move to extracting from DB
 */
public class LLSectionFactory {

    private static final LLParagraphFactory llpf = new LLParagraphFactory();

    public LLSection getSection(LLDocument doc, LLSectionCode type){

        switch(type){
            case IMG: return new HeaderImageSection(doc, llpf);
            case OPENING: return new OpeningSectionCopy(doc, llpf);
            case ADDRESSEE: return new AddresseeSectionCopy(doc, llpf);
            case RE:return new ReCaseSectionCopy(doc, llpf);
            case EMP_DESC: return new EmploymentDescriptionSectionCopy(doc, llpf);
            case TERMINATION: return new TerminationSectionCopy(doc, llpf);
            case CUSTOM: return new CustomSection(doc, llpf);
            case CONSTRUCTIVE_DISMISSAL: return new ConstructiveDismissalSectionCopy(doc, llpf);
            case BONUS: return new BonusesSectionCopy(doc, llpf);
            case FIGHT_TERMINATION_CLAUSE: return new FightTerminationClauseSectionCopy(doc, llpf);
            case FIGHTING_CAUSE: return new FightingCauseSectionCopy(doc, llpf);
            case CONTRACTOR_VS_EMP: return new ContractorVsEmployeeSectionCopy(doc, llpf);
            case PENSION: return new PensionsSectionCopy(doc, llpf);
            case APPROPRIATE_NOTICE_PERIOD: return new AppropriateNoticePeriodSectionCopy(doc, llpf);
            case INDUCEMENT: return new InducementSectionCopy(doc, llpf);
            case HARASSMENT: return new HarassmentSectionCopy(doc, llpf);
            case HUMAN_RIGHTS_DIS: return new HumanRightsDiscriminationSectionCopy(doc, llpf);
            case PUNITIVE_DMGS: return new PunitiveDamagesSectionCopy(doc, llpf);
            case OVERTIME: return new OvertimeSectionCopy(doc, llpf);
            case MOVING_FWD: return new MovingForwardSectionCopy(doc, llpf);
            case LTD_JURISPRUDENCE: return new LTDJurisprudenceSectionCopy(doc, llpf);
            case CLOSE: return new ClosingSectionCopy(doc, llpf);
            
            //testing
            case NUM_TEST: return new NumberingTestSection(doc, llpf);
            
            default: return new LLSection();
        }
    }

}
