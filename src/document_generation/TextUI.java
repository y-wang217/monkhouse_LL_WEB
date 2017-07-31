package document_generation;

import document_generation.StatementOfClaim.Sections.BackgroundSection;
import document_generation.StatementOfClaim.Sections.StatementOfClaimStartSection;
import document_generation.StatementOfClaim.Sections.ThePartiesSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.LawyersLetter.LLSectionFactory;
import document_generation.LawyersLetter.Sections.AddresseeSection;
import document_generation.LawyersLetter.Sections.HeaderImageSection;
import document_generation.LawyersLetter.Sections.OpeningSection;
import document_generation.LawyersLetter.Sections.ReCaseSection;
import document_generation.StatementOfClaim.SOCDocument;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.SOCSectionFactory;
import document_generation.util.CloseDocument;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Yale Wang
 */
public class TextUI {

    public TextUI(){
        this.setWriting(true);
    }

    public boolean isWriting() {

        return writing;
    }

    public void setWriting(boolean writing) {

        this.writing = writing;
    }

    private boolean writing = false;
    public static void addSectionToDoc(SOCDocument doc, String input){

        System.out.println("###INPUT### "+ input);

        if (input.equalsIgnoreCase("DONE")) {
            return;
        }

        SOCSection section = new SOCSection();
        SOCSectionFactory socsf = doc.getSocsf();

        //default section is custom - an empty section
        section = socsf.getSection(doc, document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode.CUSTOM);
        switch(input.toLowerCase()){
            case "termination":
                section = socsf.getSection(doc, SOCSectionCode.TERMINATION);
                break;
            case "constructive_dismissal":
                section = socsf.getSection(doc, SOCSectionCode.CONSTRUCTIVE);
                break;
            case "fighting_cause":
                section = socsf.getSection(doc, SOCSectionCode.FIGHTING_CAUSE);
                break;
            case "bonus":
                section = socsf.getSection(doc, SOCSectionCode.BONUSES_OTHERS);
                break;
            case "fight_termination_clause":
                section = socsf.getSection(doc, SOCSectionCode.FIGHTING_TERM);
                break;
            case "contractor_vs_emp":
                section = socsf.getSection(doc, SOCSectionCode.INDEPENDENT);
                break;
            case "inducement":
                section = socsf.getSection(doc, SOCSectionCode.INDUCEMENT);
                break;
            case "harassment":
                section = socsf.getSection(doc, SOCSectionCode.HARASSMENT);
                break;
            case "human_rights_dis":
                section = socsf.getSection(doc, SOCSectionCode.HUMAN_RIGHTS);
                break;
            case "punitive_dmgs":
                section = socsf.getSection(doc, SOCSectionCode.PUNITIVE_HARASSMENT);
                break;
            case "overtime":
                section = socsf.getSection(doc, SOCSectionCode.ONT_OVERTIME);
                break;
            default:
                if(section.getSectionCodeSOC() == SOCSectionCode.CUSTOM){
                    //none of the codes given above
                    System.out.println("Not a valid section");
                }
        }
        doc.writeToDoc(section);
    }
    public static void addSectionToDoc(LLDocument doc, String input){

        System.out.println("###INPUT### "+ input);

        if (input.equalsIgnoreCase("DONE")) {
            return;
        }

        LLSection section = new LLSection();
        LLSectionFactory llsf = doc.getLlsf();

        //default section is custom - an empty section
        section = llsf.getSection(doc, LLSectionCode.CUSTOM);
        switch(input.toLowerCase()){
	        case "header_img":
	            section = llsf.getSection(doc, LLSectionCode.IMG);
	            break;
            case "emp_desc":
                section = llsf.getSection(doc, LLSectionCode.EMP_DESC);
                break;
            case "termination":
                section = llsf.getSection(doc, LLSectionCode.TERMINATION);
                break;
            case "constructive_dismissal":
                section = llsf.getSection(doc, LLSectionCode.CONSTRUCTIVE_DISMISSAL);
                break;
            case "fighting_cause":
                section = llsf.getSection(doc, LLSectionCode.FIGHTING_CAUSE);
                break;
            case "bonus":
                section = llsf.getSection(doc, LLSectionCode.BONUS);
                break;
            case "fight_termination_clause":
                section = llsf.getSection(doc, LLSectionCode.FIGHT_TERMINATION_CLAUSE);
                break;
            case "contractor_vs_emp":
                section = llsf.getSection(doc, LLSectionCode.CONTRACTOR_VS_EMP);
                break;
            case "pension":
                section = llsf.getSection(doc, LLSectionCode.PENSION);
                break;
            case "appropriate_notice_period":
                section = llsf.getSection(doc, LLSectionCode.APPROPRIATE_NOTICE_PERIOD);
                break;
            case "inducement":
                section = llsf.getSection(doc, LLSectionCode.INDUCEMENT);
                break;
            case "harassment":
                section = llsf.getSection(doc, LLSectionCode.HARASSMENT);
                break;
            case "human_rights_dis":
                section = llsf.getSection(doc, LLSectionCode.HUMAN_RIGHTS_DIS);
                break;
            case "punitive_dmgs":
                section = llsf.getSection(doc, LLSectionCode.PUNITIVE_DMGS);
                break;
            case "overtime":
                section = llsf.getSection(doc, LLSectionCode.OVERTIME);
                break;
            case "moving_fwd":
                section = llsf.getSection(doc, LLSectionCode.MOVING_FWD);
                break;
            case "ltd_jurisprudence":
                section = llsf.getSection(doc, LLSectionCode.LTD_JURISPRUDENCE);
                break;
            default:
                if(section.getSectionCode() == LLSectionCode.CUSTOM){
                    //none of the codes given above
                    System.out.println("Not a valid section");
                }
        }
        doc.writeToDoc(section);
    }

    public static void main(String[] args){

        TextUI test = new TextUI();

        LLDocument doc = new LLDocument();
        LLSectionFactory llsf = doc.getLlsf();
        //add image header to doc
        llsf.getSection(doc, LLSectionCode.IMG);


        //initialize the opening, addressee, and re-case sections
        test.init(doc);

        final boolean isUsingTestingFileInput = true;
        if(isUsingTestingFileInput) {
            //automated file input - Sandbox
            BufferedReader br = null;
            FileReader fr = null;
            try {
                fr = new FileReader("testLetter.txt");

                String input;

                br = new BufferedReader(new FileReader("testLetter.txt"));

                while ((input = br.readLine()) != null) {
                    //System.out.println(input);
                    addSectionToDoc(doc, input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        final boolean isUsingUserInput = false;
        if(isUsingUserInput) {
            //manual user input - UAT
            Scanner sc = new Scanner(System.in);
            String input;
            System.out.println("Please enter a section code");
            while (test.isWriting()) {
                input = sc.nextLine();
                System.out.println("Your input was: " + input + "\n");
                if (input.equalsIgnoreCase("DONE")) {
                    test.setWriting(false);
                    break;
                }
                addSectionToDoc(doc, input);
            }
        }
        //always include closing section
        doc.writeToDoc(llsf.getSection(doc,LLSectionCode.CLOSE));

        //write the docuent to disk, saving under absolute path
        CloseDocument.closeSimple(doc, "/Users/monkhousemacbook6/Documents/JavaCreatedFiles/UITest.docx");

    }
    public static void init(SOCDocument doc){
    	doc.writeToDoc(new StatementOfClaimStartSection(doc, new LLParagraphFactory()));
    	doc.writeToDoc(new ThePartiesSection(doc, new LLParagraphFactory()));
    	doc.writeToDoc(new BackgroundSection(doc, new LLParagraphFactory()));
    }

    public static void init(LLDocument doc){
    	doc.writeToDoc(new HeaderImageSection(doc, new LLParagraphFactory()));
        doc.writeToDoc(new OpeningSection(doc, new LLParagraphFactory()));
        doc.writeToDoc(new AddresseeSection(doc, new LLParagraphFactory()));
        doc.writeToDoc(new ReCaseSection(doc, new LLParagraphFactory()));
    }

}
