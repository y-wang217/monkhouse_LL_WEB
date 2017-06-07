package document_generation.LawyersLetter;

import static document_generation.LawyersLetter.Codes.ParaCode.LIST;
import static document_generation.LawyersLetter.Codes.ParaCode.QUOTE;
import static document_generation.LawyersLetter.Codes.ParaCode.TAB;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import document_generation.TextUI;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.util.CloseDocument;
import document_generation.util.ManipDocument;
import document_generation.util.Numbering;

/**
 * Created by Yale Wang
 */
public class LLDocument extends XWPFDocument {

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

	// CONSTRUCTOR
	public LLDocument() {

		super();
		init();
	}

	public enum gender {
		m, f
	}

	// PRIVATE INITIALIZER TO SEPARATE TEST EXECUTION
	private void init() {

		LinkedHashMap<String, String> fields = new LinkedHashMap<>();
		this.setFieldsMap(fields);
		LLSectionFactory llsf = new LLSectionFactory();
		this.setLlsf(llsf);

		boolean testForFieldsFromInput = false;
		boolean initDefaultFields = false;
		// prompt for fields from input
		promptForGender(testForFieldsFromInput);
		promptForFields(testForFieldsFromInput);
		// testing init flags for different subsections
		initCheckBoxFields(initDefaultFields);

		// otherwise put in default values
		initFields(initDefaultFields);
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

	// SET UP AND INITLIZE CERTAIN FIELDS
	private void initFields() {

		LinkedHashMap<String, String> defaultFieldsMap = this.getFieldsMap();

		gender g = this.getClientGender();

		defaultFieldsMap.put("client_honorific", (g == gender.m) ? "Mr."
				: "Mrs.");
		defaultFieldsMap.put("employer_honorific_male", "Mr.");
		defaultFieldsMap.put("employer_honorific_female", "Mrs.");

		defaultFieldsMap.put("subjective_pronoun", (g == gender.m) ? "he"
				: "she");
		defaultFieldsMap.put("subjective_pronoun_caps", (g == gender.m) ? "He"
				: "She");

		defaultFieldsMap
				.put("object_pronoun", (g == gender.m) ? "him" : "her.");
		defaultFieldsMap.put("object_pronoun_caps", (g == gender.m) ? "Him"
				: "Her.");

		defaultFieldsMap.put("possessive_pronoun", (g == gender.m) ? "his"
				: "her");
		defaultFieldsMap.put("possessive_pronoun_caps", (g == gender.m) ? "His"
				: "Her");

		if (this.getFieldsMap().containsKey("monkhouse_lawyer")) {
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("ahm")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Andrew Monkhouse");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"andrew@monkhouselaw.com");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("sdl")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Samantha Lucifora");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("baf")) {
				defaultFieldsMap.put("monkhouse_lawyer_name", "Busayo Ayodele");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("sjl")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Stephen LeMesurier");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("mdm")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Miguel Mangalindan");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
			}
		}

		this.setFieldsMap(defaultFieldsMap);
	}

	// gender determines which pronouns are used
	private gender clientGender;

	private void promptForGender(boolean testForFieldsFromInput) {

		if (testForFieldsFromInput) {
			Scanner sc = new Scanner(System.in);
			String input;
			input = sc.nextLine();

			switch (input.toLowerCase()) {
			case "male":
			case "m":
				setClientGender(gender.m);
			case "female":
			case "f":
				setClientGender(gender.f);
			default:
				if (this.getClientGender() != gender.f
						&& this.getClientGender() != gender.m) {
					System.out.println("Please enter a valid gender");
					promptForGender(true);
				}
			}
		}
	}

	// some fields for testing fields list prompt
	private String[] initialFieldsList = { "employer_last_name",
			"employer_first_name", "client_last_name", "client_first_name" };

	private void promptForFields(boolean testFields) {

		if (testFields) {
			Scanner sc = new Scanner(System.in);
			String input;

			System.out.println("Please enter a section code");
			for (String field : initialFieldsList) {
				System.out.println("Please enter the: " + field);
				input = sc.nextLine();
				fieldsMap.put(field, input);
			}
		}
		for (String key : fieldsMap.keySet()) {
			System.out.println(" (" + key + ", " + fieldsMap.get(key) + ") ");
		}
	}

	// PRIVATE FIELDS
	private static LinkedHashMap<String, String> fieldsMap;
	private LLSectionFactory llsf;

	// WRITE SECTIONS TO DOCUMENT
	public void writeToDoc(LLSection section) {

		for (LLParagraph p : section.getContents()) {
			if (p.getParaType().equals(ParaCode.EMPTY)) {
				break;
			}
			if (p.getParaType().equals(LIST)) {
				Thread listInsertThread = new Thread(() -> {
					Numbering.insertNumberedList(this,
							processFields(p.getText()));
				});
				listInsertThread.start();
				try {
					listInsertThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			for (String s : p.getText().split("%%")) {
				s = processFields(s);
				System.out.println(p.getParaType() + " : " + s);
				XWPFRun r = ManipDocument.createRun(p.getXwpfParagraph());
				//handle italics
				if(s.indexOf('_')>=0) {
					XWPFParagraph xwpfParagraph = this.createParagraph();
					handleItalics(xwpfParagraph,s,findItalics(s));
					break;
				}
				if (p.getParaType().equals(TAB))
					ManipDocument.tab(r);
				alterRun(r, p);
				if (p.getParaType().equals(QUOTE)) {
					if (!p.getText().substring(0, 2).equals("1."))
						r.setFontSize(10);
				}
				ManipDocument.append(r, 1, s);
			}
		}
	}

	private ArrayList<Integer> findItalics(String s){
		String italicsSymbol = "_";
		int lastIndex = 0;
		int count = 0;
		ArrayList<Integer> underscoreIndex = new ArrayList<Integer>();

		while(lastIndex != -1){

		    lastIndex = s.indexOf(italicsSymbol,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        underscoreIndex.add(lastIndex);
		        lastIndex += italicsSymbol.length();
		    }
		}
		return underscoreIndex;
	}
	
	private void handleItalics(XWPFParagraph p, String s, ArrayList<Integer> underscoreIndex){
		XWPFRun r;int beginNonItalic = 0;
		boolean beginsWithItalics=false;
		if(underscoreIndex.get(0)==0){
			//handle first line being in italics
			r = ManipDocument.createRun(p);
			r.setItalic(true);
			r.setText(s.substring(1,underscoreIndex.get(1)));
			beginNonItalic = underscoreIndex.get(1)+1;
			beginsWithItalics = true;
		}
		//count is the number of underlines; count/2 is the number of phrases with italics
		for(int i=beginsWithItalics?2:0; i<underscoreIndex.size()/2; i+=2){
			System.out.print(s.substring(underscoreIndex.get(i),underscoreIndex.get(i)+1));
			//add run of normal up to first underscore,
			r = ManipDocument.createRun(p);
			r.setText(s.substring(beginNonItalic,underscoreIndex.get(i)));
			//then add run of italics to second underscore,
			r = ManipDocument.createRun(p);
			r.setItalic(true);
			r.setText(s.substring(underscoreIndex.get(i)+1,underscoreIndex.get(i+1)));
			//repeat
		}
		if(underscoreIndex.get(underscoreIndex.size()-1)!=s.length()-1){
			r = ManipDocument.createRun(p);
			r.setText(s.substring(underscoreIndex.get(underscoreIndex.size()-1)+1));
		}
	}
	
	// METHOD FOR ADDING FORMATTING TO RUNS
	private void alterRun(XWPFRun r, LLParagraph llParagraph) {

		r.setBold(llParagraph.isBold());
		//r.setItalic(llParagraph.hasItalics());
		//handle italics through searching for underscores
		if (llParagraph.isUnderline())
			r.setUnderline(UnderlinePatterns.SINGLE);
	}

	// SEARCH REGEX FOR FIELDS IN "<" AND ">", REPLACE WITH FIELDS FROM MAP
	private static Pattern PATTERN_FOR_FIELDS = Pattern.compile("<(.*?)>");

	public static String processFields(String s) {

		String fieldReplaced = s;
		Matcher m = PATTERN_FOR_FIELDS.matcher(s);
		while (m.find()) {
			String fieldName = m.group(1);
			System.out.println("   " + fieldName);
			fieldReplaced = fieldReplaced.replace("<" + fieldName + ">",
					fieldsMap.getOrDefault(fieldName,
							"###field not found error###"));
		}
		return fieldReplaced;
	}

	public XWPFNumbering resetNumbering() {
		XWPFDocument doc = new XWPFDocument();
		XWPFNumbering numbering = doc.createNumbering();

		return numbering;
	}

	// SETTERS AND GETTERS
	public LLSectionFactory getLlsf() {

		return llsf;
	}

	private void setLlsf(LLSectionFactory llsf) {

		this.llsf = llsf;
	}

	public LinkedHashMap<String, String> getFieldsMap() {

		return fieldsMap;
	}

	public void setFieldsMap(LinkedHashMap<String, String> fieldsMap) {

		this.fieldsMap = fieldsMap;
	}

	private gender getClientGender() {

		return clientGender;
	}

	public void setClientGender(gender clientGender) {

		this.clientGender = clientGender;
		initFields();
		System.out.println("---> SUBJECTIVE PRONOUN: "
				+ this.getFieldsMap().get("subjective_pronoun"));
		System.out.println("---> POSSESSIVE PRONOUN: "
				+ this.getFieldsMap().get("possessive_pronoun"));
	}

	public void writeDocFromFields() {
		TextUI.init(this);
		for (String key : fieldsMap.keySet()) {
			TextUI.addSectionToDoc(this, key);
		}
	}

	public static void main(String[] args) {

		LLDocument test = new LLDocument();

		LLSection s = test.getLlsf().getSection(test, SectionCode.CUSTOM);
		ArrayList<LLParagraph> listOfParas = new ArrayList<>();
		s.insertText(new LLParagraphFactory(), test, listOfParas, ParaCode.REG,
				"<employer_last_name> is the employer's last night "
						+ "<employer_first_name> is the employer's first name "
						+ "<client_last_name> is the client's last name "
						+ "<client_first_name> is the client's first name");
		s.setContents(listOfParas);

		test.writeToDoc(s);
		CloseDocument.closeSimple(test);
	}

}
