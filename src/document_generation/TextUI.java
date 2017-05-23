package document_generation;

import document_generation.LawyersLetter.Codes.SectionCode;
import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraphFactory;
import document_generation.LawyersLetter.LLSection;
import document_generation.LawyersLetter.LLSectionFactory;
import document_generation.LawyersLetter.Sections.AddresseeSection;
import document_generation.LawyersLetter.Sections.OpeningSection;
import document_generation.LawyersLetter.Sections.ReCaseSection;
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

    public static void addSectionToDoc(LLDocument doc, String input){

        System.out.println("###INPUT### "+ input);

        if (input.equalsIgnoreCase("DONE")) {
            return;
        }

        LLSection section = new LLSection();
        LLSectionFactory llsf = doc.getLlsf();

        //default section is custom - an empty section
        section = llsf.getSection(doc, SectionCode.CUSTOM);
        switch(input.toLowerCase()){
            case "emp_desc":
                section = llsf.getSection(doc, SectionCode.EMP_DESC);
                break;
            case "termination":
                section = llsf.getSection(doc, SectionCode.TERMINATION);
                break;
            case "constructive_dismissal":
                section = llsf.getSection(doc, SectionCode.CONSTRUCTIVE_DISMISSAL);
                break;
            case "bonus":
                section = llsf.getSection(doc, SectionCode.BONUS);
                break;
            case "fight_termination_clause":
                section = llsf.getSection(doc, SectionCode.FIGHT_TERMINATION_CLAUSE);
                break;
            case "contractor_vs_emp":
                section = llsf.getSection(doc, SectionCode.CONTRACTOR_VS_EMP);
                break;
            case "pension":
                section = llsf.getSection(doc, SectionCode.PENSION);
                break;
            case "appropriate_notice_period":
                section = llsf.getSection(doc, SectionCode.APPROPRIATE_NOTICE_PERIOD);
                break;
            case "inducement":
                section = llsf.getSection(doc, SectionCode.INDUCEMENT);
                break;
            case "harassment":
                section = llsf.getSection(doc, SectionCode.HARASSMENT);
                break;
            case "human_rights_dis":
                section = llsf.getSection(doc, SectionCode.HUMAN_RIGHTS_DIS);
                break;
            case "punitive_dmgs":
                section = llsf.getSection(doc, SectionCode.PUNITIVE_DMGS);
                break;
            case "overtime":
                section = llsf.getSection(doc, SectionCode.OVERTIME);
                break;
            case "moving_fwd":
                section = llsf.getSection(doc, SectionCode.MOVING_FWD);
                break;
            case "ltd_jurisprudence":
                section = llsf.getSection(doc, SectionCode.LTD_JURISPRUDENCE);
                break;
            default:
                if(section.getSectionCode() == SectionCode.CUSTOM){
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
        llsf.getSection(doc, SectionCode.IMG);


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
        doc.writeToDoc(llsf.getSection(doc,SectionCode.CLOSE));

        //write the docuent to disk, saving under absolute path
        CloseDocument.closeSimple(doc, "/Users/monkhousemacbook6/Documents/JavaCreatedFiles/UITest.docx");

    }

    public static void init(LLDocument doc){
        doc.writeToDoc(new OpeningSection(doc, new LLParagraphFactory()));
        doc.writeToDoc(new AddresseeSection(doc, new LLParagraphFactory()));
        doc.writeToDoc(new ReCaseSection(doc, new LLParagraphFactory()));
    }

}
