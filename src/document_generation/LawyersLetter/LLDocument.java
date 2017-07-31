package document_generation.LawyersLetter;

import static document_generation.LawyersLetter.Codes.ParaCode.LIST;
import static document_generation.LawyersLetter.Codes.ParaCode.QUOTE;
import static document_generation.LawyersLetter.Codes.ParaCode.TAB;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import document_generation.TextUI;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.util.CloseDocument;
import document_generation.util.ManipDocument;
import document_generation.util.Numbering;
import document_generation.util.message.ServletMessage;
import document_generation.util.message.MessageType;

/**
 * Created by Yale Wang
 */
public class LLDocument extends XWPFDocument {

	// CONSTRUCTOR
	public LLDocument() {
		super();
		// TODO: trying out the margins
		CTSectPr sectPr = this.getDocument().getBody().addNewSectPr();
		CTPageMar pageMar = sectPr.addNewPgMar();
		pageMar.setLeft(BigInteger.valueOf(1022L));
		pageMar.setTop(BigInteger.valueOf(994));
		pageMar.setRight(BigInteger.valueOf(1022L));
		pageMar.setBottom(BigInteger.valueOf(1022L));
		init();
	}

	public enum gender {
		m, f
	}

	// PRIVATE INITIALIZER TO SEPARATE TEST EXECUTION
	public void init() {

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
		// initCheckBoxFields(initDefaultFields);

		// otherwise put in default values
		// initFields(initDefaultFields);
		initFields();
	}

	// SET UP AND INITLIZE CERTAIN FIELDS
	protected void initFields() {

		initSettlementCalculations();

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
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("AHM")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Andrew Monkhouse");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"andrew@monkhouselaw.com");
				defaultFieldsMap.put("monkhouse_lawyer_position",
						"Senior Lawyer & Founder");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("SDL")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Samantha Lucifora");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
				defaultFieldsMap.put("monkhouse_lawyer_position",
						"Associate Lawyer");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("BAF")) {
				defaultFieldsMap.put("monkhouse_lawyer_name", "Busayo Ayodele");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
				defaultFieldsMap.put("monkhouse_lawyer_position",
						"Associate Lawyer");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("SJL")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Stephen LeMesurier");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
				defaultFieldsMap.put("monkhouse_lawyer_position",
						"Associate Lawyer");
			}
			if (this.getFieldsMap().get("monkhouse_lawyer").equals("MDM")) {
				defaultFieldsMap.put("monkhouse_lawyer_name",
						"Miguel Mangalindan");
				defaultFieldsMap.put("monkhouse_lawyer_email",
						"email@monkhouselaw.com");
				defaultFieldsMap.put("monkhouse_lawyer_position",
						"Associate Lawyer");
			}
		}

		this.setFieldsMap(defaultFieldsMap);
	}

	// settlement calculations
	private void initSettlementCalculations() {

		LinkedHashMap<String, String> defaultFieldsMap = this.getFieldsMap();
		int wage, monthsNoticeOwed, dollarsNotceOwed;

		if (defaultFieldsMap.containsKey("wage_in_dollars")
				&& defaultFieldsMap.containsKey("settlement")) {
			if(defaultFieldsMap.get("wage_in_dollars").equals("")){
				defaultFieldsMap.put("wage_in_dollars", "0");
			}
			if(defaultFieldsMap.get("settlement").equals("  ")){
				defaultFieldsMap.put("settlement", "0");
			}
			if(defaultFieldsMap.get("age").equals("")){
				defaultFieldsMap.put("age", "0");
			}
			if(defaultFieldsMap.get("seniority_in_years").equals("")){
				defaultFieldsMap.put("seniority_in_years", "0");
			}
			if(defaultFieldsMap.get("seniority_in_years").equals("")){
				defaultFieldsMap.put("seniority_in_years", "0");
			}
			if(defaultFieldsMap.get("seniority_in_years").equals("")){
				defaultFieldsMap.put("seniority_in_years", "0");
			}
			
			String yearlyWage = defaultFieldsMap.get("wage_in_dollars");
			yearlyWage = yearlyWage.replaceAll(",", "");
			wage = Integer.parseInt(yearlyWage);
			monthsNoticeOwed = Integer.parseInt(defaultFieldsMap
					.get("settlement"));
			dollarsNotceOwed = wage / 12 * monthsNoticeOwed;

			defaultFieldsMap.put("dollarsNoticeOwed",
					Integer.toString(dollarsNotceOwed));
			defaultFieldsMap.put("dollarsBenefitsOwed",
					Integer.toString((int) (dollarsNotceOwed * 0.2)));
			defaultFieldsMap.put("dollarsDamagesOwed",
					Integer.toString((int) (dollarsNotceOwed * 0.25)));
			
			//overtime:
			
			//calculate overtime
			if(defaultFieldsMap.get("hoursWorkedPerWeek").equals("")){
				defaultFieldsMap.put("hoursWorkedPerWeek", "0");
			}
			
			int yearsWorked=Integer.parseInt(defaultFieldsMap.get("seniority_in_years"));
			int hoursWorkedPerWeek=Integer.parseInt(defaultFieldsMap.get("hoursWorkedPerWeek"));
			double hourlyWage= Math.round((wage/52)/44*100.0)/100.0;
			int hoursOvertimeOwed=(hoursWorkedPerWeek-40)*52*yearsWorked;
			double overtimeHourlyWage=Math.round(hourlyWage*1.5*100.0)/100.0;
			double overtimeOwed = (overtimeHourlyWage) * (hoursOvertimeOwed);
			double alternativeOvertimeOwed = overtimeOwed*2/3;
			overtimeOwed = Math.round(overtimeOwed*100.0)/100.0;;
			alternativeOvertimeOwed= Math.round(alternativeOvertimeOwed*100.0)/100.0;;
			defaultFieldsMap.put("overtimeOwed",
					String.format("%,.2f", overtimeOwed));
			defaultFieldsMap.put("hoursOvertimeOwed",
					Integer.toString(hoursOvertimeOwed));
			defaultFieldsMap.put("overtimeHourlyWage",
					String.format("%,.2f", overtimeHourlyWage));
			defaultFieldsMap.put("alternativeOvertimeOwed",
					String.format("%,.2f", alternativeOvertimeOwed));
		}
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
		//for (String key : fieldsMap.keySet()) {
			//System.out.println(" (" + key + ", " + fieldsMap.get(key) + ") ");
		//}
	}

	// PRIVATE FIELDS
	private LinkedHashMap<String, String> fieldsMap;
	private LLSectionFactory llsf;
	private ServletMessage message;

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
				// handle italics
				if (s.indexOf('_') >= 0) {
					XWPFParagraph xwpfParagraph = this.createParagraph();
					//handleItalics(xwpfParagraph, s, findItalics(s));
					//break;
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

	private ArrayList<Integer> findItalics(String s) {
		String italicsSymbol = "_";
		int lastIndex = 0;
		int count = 0;
		ArrayList<Integer> underscoreIndex = new ArrayList<Integer>();

		while (lastIndex != -1) {

			lastIndex = s.indexOf(italicsSymbol, lastIndex);

			if (lastIndex != -1) {
				count++;
				underscoreIndex.add(lastIndex);
				lastIndex += italicsSymbol.length();
			}
		}
		return underscoreIndex;
	}

	private void handleItalics(XWPFParagraph p, String s,
			ArrayList<Integer> underscoreIndex) {
		XWPFRun r;
		int beginNonItalic = 0;
		boolean beginsWithItalics = false;
		if (underscoreIndex.get(0) == 0) {
			// handle first line being in italics
			r = ManipDocument.createRun(p);
			r.setItalic(true);
			r.setText(s.substring(1, underscoreIndex.get(1)));
			beginNonItalic = underscoreIndex.get(1) + 1;
			beginsWithItalics = true;
		}
		// count is the number of underlines; count/2 is the number of phrases
		// with italics
		for (int i = beginsWithItalics ? 2 : 0; i < underscoreIndex.size() / 2; i += 2) {
			System.out.print(s.substring(underscoreIndex.get(i),
					underscoreIndex.get(i) + 1));
			// add run of normal up to first underscore,
			r = ManipDocument.createRun(p);
			r.setText(s.substring(beginNonItalic, underscoreIndex.get(i)));
			// then add run of italics to second underscore,
			r = ManipDocument.createRun(p);
			r.setItalic(true);
			r.setText(s.substring(underscoreIndex.get(i) + 1,
					underscoreIndex.get(i + 1)));
			// repeat
		}
		if (underscoreIndex.get(underscoreIndex.size() - 1) != s.length() - 1) {
			r = ManipDocument.createRun(p);
			r.setText(s.substring(underscoreIndex.get(underscoreIndex.size() - 1) + 1));
		}
	}

	// METHOD FOR ADDING FORMATTING TO RUNS
	protected void alterRun(XWPFRun r, LLParagraph llParagraph) {

		r.setBold(llParagraph.isBold());
		// r.setItalic(llParagraph.hasItalics());
		// handle italics through searching for underscores
		if (llParagraph.isUnderline())
			r.setUnderline(UnderlinePatterns.SINGLE);
	}

	// SEARCH REGEX FOR FIELDS IN "<" AND ">", REPLACE WITH FIELDS FROM MAP
	private static Pattern PATTERN_FOR_FIELDS = Pattern.compile("<(.*?)>");

	public String processFields(String s) {

		boolean isDollar = false;;
		String fieldReplaced = s;
		Matcher m = PATTERN_FOR_FIELDS.matcher(s);
		while (m.find()) {
			String fieldName = m.group(1);
			isDollar = fieldName.contains("dollars");
			System.out.println("   " + fieldName);
			String fieldValue = this.getFieldsMap().getOrDefault(fieldName,
					"###field not found error###");
			fieldReplaced = fieldReplaced.replace("<" + fieldName + ">",isDollar?addThousandCommas(isDollar, fieldValue):fieldValue);
			
		}
		
		return fieldReplaced;
	}
	
	static String addThousandCommas(boolean isDollar, String s){

		if(isDollar){
			int dollars = Integer.parseInt(s);
			NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	        s = numberFormat.format(dollars);
		}
		System.out.println(s);
		return s;
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

//		LLDocument test = new LLDocument();
//
//		LLSection s = test.getLlsf().getSection(test, SectionCode.CUSTOM);
//		ArrayList<LLParagraph> listOfParas = new ArrayList<>();
//		s.insertText(new LLParagraphFactory(), test, listOfParas, ParaCode.REG,
//				"<employer_last_name> is the employer's last night "
//						+ "<employer_first_name> is the employer's first name "
//						+ "<client_last_name> is the client's last name "
//						+ "<client_first_name> is the client's first name");
//		s.setContents(listOfParas);
//
//		test.writeToDoc(s);
//		CloseDocument.closeSimple(test);
		addThousandCommas(true,"1234567");
	}

	public ServletMessage getMessage() {
		return message;
	}

	public void setMessage(ServletMessage message) {
		this.message = message;
	}

}
