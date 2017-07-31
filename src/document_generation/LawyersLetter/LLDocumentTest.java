package document_generation.LawyersLetter;

import java.util.LinkedHashMap;

import document_generation.LawyersLetter.LLDocument.gender;

public class LLDocumentTest extends LLDocument{

	// fields import from check boxes - from a map containing each flag and
	// "true" or "false" (or nothing)
	// private HashMap<String, String> checkboxFields = new HashMap<>();

	
	public void initCheckBoxFields(boolean initDefaultFields) {
		if (initDefaultFields) {
			LinkedHashMap<String, String> m = this.getFieldsMap();
			m.put("isUseAge", "true");
			m.put("isUseNonSkilledPositions", "true");
			m.put("isUseEconomicDownturn", "true");
			m.put("isUseAllegationsOfCause", "true");
			m.put("isUseShortTermEmployees", "true");
			m.put("isUseShortTermExecutives", "true");
			m.put("isUseAppropriateNoticeConclusion", "true");
			m.put("isUseAppropriateNoticeAlternative", "true");
			m.put("isUseWageDeduction", "true");
			m.put("isUseLocation", "true");
			m.put("isUseBreachOfFundamentalImpliedTerm", "true");
			m.put("isUseIntolerable", "true");
			m.put("isUseWorkplaceHarassment", "true");
			m.put("isUsePoisonedWorkEnvironment", "true");
			m.put("isUseRemovalFromManagementPosition", "true");

			m.put("isUseIndependentContractorVsEmployee", "true");
			m.put("isUseDependentContractor", "true");

			m.put("isUseHighStandard", "true");
			m.put("isUseGrossIncompetence", "true");
			m.put("isUseJobAbandonment", "true");
			m.put("isUseDamageAward", "true");

			m.put("isUseBasicStart", "true");
			m.put("isUseNoContractingOutOfESA", "true");
			m.put("isUseNonInclusionOfBenefits", "true");
			m.put("isUsePotentialViolations", "true");
			m.put("isUseEmployerCannotRelyOnBreachedTerminationClause", "true");

			m.put("isUseOhsaBill168", "true");
			m.put("isUsePunitiveDamages", "true");

			m.put("isUseTerminationOnProtectedGRound", "true");
			m.put("isUseAgeDamages", "true");
			m.put("isUseHumanRightsDamagesChart", "true");

			m.put("isUseBreachOfContract", "true");
			m.put("isUseLtdJurisprudence", "true");
			m.put("isUseMovingForwardLtd", "true");

			m.put("isUseClc", "true");
			m.put("isUsePerformanceOntari", "true");

			m.put("isUseBadFaith", "true");
			m.put("isUseOpenAndHonestManner", "true");
			m.put("isUseUnfavourableReference", "true");
			m.put("isUseReprisalHarassmentReport", "true");
			m.put("isUseFailureToProvideStatutoryRequirement", "true");
			m.put("isUseFailureToProvide", "true");
			m.put("isUseReprisalOhsa", "true");
			m.put("isUsisUseAllecationsOfCauseeAge", "true");
			this.setFieldsMap(m);
		}
	}


	// initialize fields from default/testing fieldsMap here:
	private void initFields(boolean initDefaultFields) {

		if (initDefaultFields) {
			LinkedHashMap<String, String> defaultFieldsMap = this
					.getFieldsMap();
			defaultFieldsMap.put("monkhouse_lawyer_name",
					"Andrew Monkhouse, J.D.");
			defaultFieldsMap.put("monkhouse_lawyer_email",
					"andrew@monkhouselaw.com");
			defaultFieldsMap.put("OC_HR_first_name", "Opposing");
			defaultFieldsMap.put("OC_HR_last_name", "Lawyer");
			defaultFieldsMap.put("OC_HR_job_title", "Lawyer or Manager or HR");
			defaultFieldsMap.put("OC_HR_company_name", "Some Law Office LLP");
			defaultFieldsMap.put("OC_HR_company_address", "123 Bay Street");
			defaultFieldsMap.put("OC_HR_company_postcode", "M5J 1A1");

			defaultFieldsMap.put("employer_last_name", "Smith");
			defaultFieldsMap.put("employer_first_name", "The-Employer");
			defaultFieldsMap.put("client_last_name", "Doe");
			defaultFieldsMap.put("client_first_name", "John");

			defaultFieldsMap.put("seniority_in_years", "10");
			defaultFieldsMap.put("wage_in_dollars",
					"75,000.00 per year, plus etc.");
			defaultFieldsMap.put("age", "45");
			defaultFieldsMap.put("client_position", "Manager/Specialist");

			defaultFieldsMap.put("termination_date", "May 1, 2017");
			defaultFieldsMap.put("monkhouse_lawyer_title",
					"Senior Lawyer & Founder");
			this.setFieldsMap(defaultFieldsMap);

			this.setClientGender(gender.m);
		}
		initFields();
	}
}
