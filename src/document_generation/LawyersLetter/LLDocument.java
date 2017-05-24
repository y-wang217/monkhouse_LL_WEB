package document_generation.LawyersLetter;

import document_generation.TextUI;
import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.util.CloseDocument;
import document_generation.util.ManipDocument;
import document_generation.util.Numbering;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static document_generation.LawyersLetter.Codes.ParaCode.LIST;
import static document_generation.LawyersLetter.Codes.ParaCode.QUOTE;
import static document_generation.LawyersLetter.Codes.ParaCode.TAB;

/**
 * Created by Yale Wang
 */
public class LLDocument extends XWPFDocument {

    //fields import from check boxes - from a map containing each flag and "true" or "false" (or nothing)
    //private HashMap<String, String> checkboxFields = new HashMap<>();

    public void initCheckBoxFields(){
        LinkedHashMap<String, String> m = this.getFieldsMap();
        m.put("isUseAge","true");
        m.put("isUseNonSkilledPositions","true");
        m.put("isUseEconomicDownturn","true");
        m.put("isUseAllegationsOfCause","true");
        m.put("isUseShortTermEmployees","true");
        m.put("isUseShortTermExecutives","true");
        m.put("isUseAppropriateNoticeConclusion","true");
        m.put("isUseAppropriateNoticeAlternative","true");
        m.put("isUseWageDeduction","true");
        m.put("isUseLocation","true");
        m.put("isUseBreachOfFundamentalImpliedTerm","true");
        m.put("isUseIntolerable","true");
        m.put("isUseWorkplaceHarassment","true");
        m.put("isUsePoisonedWorkEnvironment","true");
        m.put("isUseRemovalFromManagementPosition","true");

        m.put("isUseIndependentContractorVsEmployee","true");
        m.put("isUseDependentContractor","true");

        m.put("isUseHighStandard","true");
        m.put("isUseGrossIncompetence","true");
        m.put("isUseJobAbandonment","true");
        m.put("isUseDamageAward","true");

        m.put("isUseBasicStart","true");
        m.put("isUseNoContractingOutOfESA","true");
        m.put("isUseNonInclusionOfBenefits","true");
        m.put("isUsePotentialViolations","true");
        m.put("isUseEmployerCannotRelyOnBreachedTerminationClause","true");

        m.put("isUseOhsaBill168","true");
        m.put("isUsePunitiveDamages","true");

        m.put("isUseTerminationOnProtectedGRound","true");
        m.put("isUseAgeDamages","true");
        m.put("isUseHumanRightsDamagesChart","true");

        m.put("isUseBreachOfContract","true");
        m.put("isUseLtdJurisprudence","true");
        m.put("isUseMovingForwardLtd","true");

        m.put("isUseClc","true");
        m.put("isUsePerformanceOntari","true");

        m.put("isUseBadFaith","true");
        m.put("isUseOpenAndHonestManner","true");
        m.put("isUseUnfavourableReference","true");
        m.put("isUseReprisalHarassmentReport","true");
        m.put("isUseFailureToProvideStatutoryRequirement","true");
        m.put("isUseFailureToProvide","true");
        m.put("isUseReprisalOhsa","true");
        m.put("isUsisUseAllecationsOfCauseeAge","true");
        this.setFieldsMap(m);
    }

    //CONSTRUCTOR
    public LLDocument() {

        super();
        init();
    }

    public enum gender {m, f}

    //PRIVATE INITIALIZER TO SEPARATE TEST EXECUTION
    private void init() {

        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        this.setFieldsMap(fields);
        LLSectionFactory llsf = new LLSectionFactory();
        this.setLlsf(llsf);

        //testing init flags for different subsections
        initCheckBoxFields();

        boolean testForFieldsFromInput = false;
        boolean initDefaultFields = false;
        //prompt for fields from input
        promptForGender(testForFieldsFromInput);
        promptForFields(testForFieldsFromInput);
        //otherwise put in default values
        initFields(initDefaultFields);
    }

    //initialize fields from default/testing fieldsMap here:
    private void initFields(boolean initDefaultFields) {

        if (initDefaultFields) {
            LinkedHashMap<String, String> defaultFieldsMap = this.getFieldsMap();
            defaultFieldsMap.put("monkhouse_lawyer_name", "Andrew Monkhouse, J.D.");
            defaultFieldsMap.put("monkhouse_lawyer_email", "andrew@monkhouselaw.com");
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
            defaultFieldsMap.put("wage_in_dollars", "75,000.00 per year, plus etc.");
            defaultFieldsMap.put("age", "45");
            defaultFieldsMap.put("client_position", "Manager/Specialist");

            defaultFieldsMap.put("termination_date", "May 1, 2017");
            defaultFieldsMap.put("monkhouse_lawyer_title", "Senior Lawyer & Founder");
            this.setFieldsMap(defaultFieldsMap);

            this.setClientGender(gender.m);
        }
        initFields();
    }

    //SET UP AND INITLIZE CERTAIN FIELDS
    private void initFields() {

        LinkedHashMap<String, String> defaultFieldsMap = this.getFieldsMap();

        gender g = this.getClientGender();

        defaultFieldsMap.put("client_honorific", (g==gender.m)?"Mr.":"Mrs.");
        defaultFieldsMap.put("employer_honorific_male", "Mr.");
        defaultFieldsMap.put("employer_honorific_female", "Mrs.");

        defaultFieldsMap.put("subjective_pronoun", (g==gender.m)?"he":"she");
        defaultFieldsMap.put("subjective_pronoun_caps", (g==gender.m)?"He":"She");

        defaultFieldsMap.put("object_pronoun", (g==gender.m)?"him":"her.");
        defaultFieldsMap.put("object_pronoun_caps", (g==gender.m)?"Him":"Her.");

        defaultFieldsMap.put("possessive_pronoun", (g==gender.m)?"his":"her");
        defaultFieldsMap.put("possessive_pronoun_caps", (g==gender.m)?"His":"Her");


        this.setFieldsMap(defaultFieldsMap);
    }

    //gender determines which pronouns are used
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
                    if (this.getClientGender() != gender.f && this.getClientGender() != gender.m) {
                        System.out.println("Please enter a valid gender");
                        promptForGender(true);
                    }
            }
        }
    }

    //some fields for testing fields list prompt
    private String[] initialFieldsList = {"employer_last_name", "employer_first_name", "client_last_name", "client_first_name"};
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

    //PRIVATE FIELDS
    private LinkedHashMap<String, String> fieldsMap;
    private LLSectionFactory llsf;

    //WRITE SECTIONS TO DOCUMENT
    public void writeToDoc(LLSection section) {

        for (LLParagraph p : section.getContents()) {
            if (p.getParaType().equals(ParaCode.EMPTY)) {
            	return;
            }
            if (p.getParaType().equals(LIST)) {
                Thread listInsertThread = new Thread(() -> {
                    Numbering.insertNumberedList(this, p.getText());
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
                if (p.getParaType().equals(TAB)) ManipDocument.tab(r);
                alterRun(r, p);
                if (p.getParaType().equals(QUOTE)) {
                    if(!p.getText().substring(0,2).equals("1.")) r.setFontSize(10);
                }
                ManipDocument.append(r, 1, s);
            }
        }
    }

    //METHOD FOR ADDING FORMATTING TO RUNS
    private void alterRun(XWPFRun r, LLParagraph llParagraph) {

        r.setBold(llParagraph.isBold());
        r.setItalic(llParagraph.isItalics());
        if (llParagraph.isUnderline()) r.setUnderline(UnderlinePatterns.SINGLE);
    }

    //SEARCH REGEX FOR FIELDS IN "<" AND ">", REPLACE WITH FIELDS FROM MAP
    private Pattern PATTERN_FOR_FIELDS = Pattern.compile("<(.*?)>");

    private String processFields(String s) {

        String fieldReplaced = s;
        Matcher m = PATTERN_FOR_FIELDS.matcher(s);
        while (m.find()) {
            String fieldName = m.group(1);
            System.out.println("   " + fieldName);
            fieldReplaced = fieldReplaced.replace("<" + fieldName + ">", fieldsMap.getOrDefault(fieldName, "###field not found error###"));
        }
        return fieldReplaced;
    }

    public XWPFNumbering resetNumbering() {
        XWPFDocument doc = new XWPFDocument();
        XWPFNumbering numbering = doc.createNumbering();

        return numbering;
    }

    //SETTERS AND GETTERS
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
    }
    
    public void writeDocFromFields(){
    	TextUI.init(this);
    	for(String key: fieldsMap.keySet()){
    		TextUI.addSectionToDoc(this, key);
    	}
    }

    public static void main(String[] args) {

        LLDocument test = new LLDocument();

        LLSection s = test.getLlsf().getSection(test, SectionCode.CUSTOM);
        ArrayList<LLParagraph> listOfParas = new ArrayList<>();
        s.insertText(new LLParagraphFactory(), test, listOfParas, ParaCode.REG, "<employer_last_name> is the employer's last night " +
                "<employer_first_name> is the employer's first name " +
                "<client_last_name> is the client's last name " +
                "<client_first_name> is the client's first name");
        s.setContents(listOfParas);

        test.writeToDoc(s);
        CloseDocument.closeSimple(test);
    }

}
