package document_generation.StatementOfClaim;

import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.StatementOfClaim.Sections.AllegationsOfCauseSection;
import document_generation.StatementOfClaim.Sections.BackgroundSection;
import document_generation.StatementOfClaim.Sections.BadFaithDutyOfHonestySection;
import document_generation.StatementOfClaim.Sections.BonusesAndOtherBenefitsSection;
import document_generation.StatementOfClaim.Sections.BreachOfClauseSection;
import document_generation.StatementOfClaim.Sections.CLCOvertimeSection;
import document_generation.StatementOfClaim.Sections.ChangeLocationSection;
import document_generation.StatementOfClaim.Sections.ConstructiveDismissalSection;
import document_generation.StatementOfClaim.Sections.DamageAwardSection;
import document_generation.StatementOfClaim.Sections.DoesNotExcludeCommonLawSection;
import document_generation.StatementOfClaim.Sections.EndSection;
import document_generation.StatementOfClaim.Sections.FailureToProvideMinimumsSection;
import document_generation.StatementOfClaim.Sections.FightingCauseSection;
import document_generation.StatementOfClaim.Sections.FightingTerminationSection;
import document_generation.StatementOfClaim.Sections.GrossIncompetenceSection;
import document_generation.StatementOfClaim.Sections.HarassmentSection;
import document_generation.StatementOfClaim.Sections.HumanRightsSection;
import document_generation.StatementOfClaim.Sections.IndependentContractorVsEmployeeSection;
import document_generation.StatementOfClaim.Sections.InducementSection;
import document_generation.StatementOfClaim.Sections.IntolerableWorkEnvironmentSection;
import document_generation.StatementOfClaim.Sections.JobAbandonmentSection;
import document_generation.StatementOfClaim.Sections.LocationEndSection;
import document_generation.StatementOfClaim.Sections.NoContractESASection;
import document_generation.StatementOfClaim.Sections.NonContinuationOfBenefitsSection;
import document_generation.StatementOfClaim.Sections.OHSA168Section;
import document_generation.StatementOfClaim.Sections.OntarioOvertime;
import document_generation.StatementOfClaim.Sections.OpenAndHonestMannerSection;
import document_generation.StatementOfClaim.Sections.PoisonedWorkEnvSection;
import document_generation.StatementOfClaim.Sections.PotentialFutureViolationsSection;
import document_generation.StatementOfClaim.Sections.PunitiveAggravateMoralDamagesSection;
import document_generation.StatementOfClaim.Sections.PunitiveDamagesHarassmentSection;
import document_generation.StatementOfClaim.Sections.RemovalFromManagementSection;
import document_generation.StatementOfClaim.Sections.StatementOfClaimStartSection;
import document_generation.StatementOfClaim.Sections.StatementOfClaimStartSection_copy;
import document_generation.StatementOfClaim.Sections.TerminationSection;
import document_generation.StatementOfClaim.Sections.ThePartiesSection;
import document_generation.StatementOfClaim.Sections.WageDeductionSection;
import document_generation.StatementOfClaim.Sections.WorkplaceHarassmentSection;
import document_generation.StatementOfClaim.Sections.WrongfulDismissalSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class SOCSectionFactory {
	private static final LLParagraphFactory llpf = new LLParagraphFactory();

    public SOCSection getSection(SOCDocument doc, SOCSectionCode type){

        switch(type){
        	case CUSTOM: return new StatementOfClaimStartSection();
            case START: return new StatementOfClaimStartSection(doc, llpf);
            case START2: return new StatementOfClaimStartSection(doc, llpf);
            case PARTIES: return new ThePartiesSection(doc, llpf);
            case BACKGROUND: return new BackgroundSection(doc, llpf);
            case INDEPENDENT: return new IndependentContractorVsEmployeeSection(doc, llpf);
            case TERMINATION: return new TerminationSection(doc, llpf);
            case CONSTRUCTIVE: return new ConstructiveDismissalSection(doc, llpf);
            case WAGE: return new WageDeductionSection(doc, llpf);
            case LOCATION: return new ChangeLocationSection(doc, llpf);
            case INTOLERABLE: return new IntolerableWorkEnvironmentSection(doc, llpf);
            case WORKPLACE_HARASSMENT: return new WorkplaceHarassmentSection(doc, llpf);
            case DAMAGE_AWARD: return new DamageAwardSection(doc, llpf);
            case FIGHTING_TERM: return new FightingTerminationSection(doc, llpf);
            case NO_CONTRACTING: return new NoContractESASection(doc, llpf);
            case NOT_EXCLUDE: return new DoesNotExcludeCommonLawSection(doc, llpf);
            case NON_BENEFITS: return new NonContinuationOfBenefitsSection(doc, llpf);
            case POT_VIOLATIONS: return new PotentialFutureViolationsSection(doc, llpf);
            case ABoCDSR: return new BreachOfClauseSection(doc, llpf);
            case INDUCEMENT: return new InducementSection(doc, llpf);
            case WRONGFUL: return new WrongfulDismissalSection(doc, llpf);
            case CLC: return new CLCOvertimeSection(doc, llpf);
            case ONT_OVERTIME: return new OntarioOvertime(doc, llpf);
            case BONUSES_OTHERS: return new BonusesAndOtherBenefitsSection(doc, llpf);
            case OHSA: return new OHSA168Section(doc, llpf);
            case PUNITIVE_HARASSMENT: return new PunitiveDamagesHarassmentSection(doc, llpf);
            case HUMAN_RIGHTS: return new HumanRightsSection(doc, llpf);
            case PUN_AGG_MOR_DMGS: return new PunitiveAggravateMoralDamagesSection(doc, llpf);
            case BAD_FAITH: return new BadFaithDutyOfHonestySection(doc, llpf);
            case OPEN_HONEST: return new OpenAndHonestMannerSection(doc, llpf);
            case ALLEGATIONS: return new AllegationsOfCauseSection(doc, llpf);
            case HARASSMENT: return new HarassmentSection(doc, llpf);
            case FAIL_MINIMUMS: return new FailureToProvideMinimumsSection(doc, llpf);
            case POISONED: return new PoisonedWorkEnvSection(doc, llpf);
            case REMOVAL_MANAGEMENT: return new RemovalFromManagementSection(doc, llpf);
            case FIGHTING_CAUSE: return new FightingCauseSection(doc, llpf);
            case HIGH_STANDARD: return new RemovalFromManagementSection(doc, llpf);
            case GROSS: return new GrossIncompetenceSection(doc, llpf);
            case ABANDONMENT: return new JobAbandonmentSection(doc, llpf);
            case END_LOCATION: return new LocationEndSection(doc, llpf);
            case END: return new EndSection(doc, llpf);
            
            
            case START_TEST:return new StatementOfClaimStartSection_copy(doc,llpf);
            default: return new SOCSection();
        }
    }
}
