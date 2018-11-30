import org.apache.commons.lang3.StringUtils;

import javax.management.RuntimeErrorException;
import java.lang.*;
import java.util.Scanner;

/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private String middleName;
    private int stuNumber;
    private double gpa;
    



    /**
     * Create a new Student
     * @param fn        first name of the student
     * @param ln        last name of the student
     * @param mn        middle name of the student
     * @param stuNum    student number of the student
     * @param pGPA      GPA of the student
     */
    public Student(String fn, String ln, String mn, int stuNum, double pGPA)
    {
       firstName = fn;
       lastName = ln;
       middleName = mn;
       stuNumber = stuNum;
       gpa = pGPA;
    }

    /**
     * Returns the full name of the given student
     */
    public String getFullName(){
        return lastName + ", " + firstName + " " + middleName;
    }
    /**
     * Returns the GPA of the given student
     */
    public double getGPA(){
        return gpa;
    }
    /**
     * Returns the student number of the given student
     */
    public int getStuNumber(){
        return stuNumber;
    }
    /**
     * Sets the first name
     * @param   String    First Name
     */
    public void setFirstName(String s){
        firstName = s;
    }
    /**
     * Sets the middle name
     * @param   String  Middle Name
     */
    public void setMiddleName(String s){
        middleName = s;
    }
    /**
     * Sets the last name
     * @param   String  Last Name
     */
    public void setLastName(String s){
        lastName = s;
    }

    /**
     * Sets the student number
     * @param   int     Student Number
     */
    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    /**
     * Sets the GPA
     * @param   double  GPA
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    /**
     * Allows editing of a given student
     * @return updated student into the array
     */
    public void edit() {
        boolean run = true;
        Scanner s = new Scanner(System.in);
        while(run){
            ConsoleMethods.clearScreen();

            System.out.println("Name: "+ getFullName());
            System.out.println("Student #: "+getStuNumber());
            System.out.println("GPA: "+getGPA());

            System.out.println("What would you like to edit?");
            System.out.println("1 Name | 2 # | 3 GPA | 4 DONE");
            int action = s.nextInt();
            if(action == 1){
                System.out.println(getFullName());
                System.out.println("What should their name be?");
                String clearInputStream = s.nextLine();
                String userRawName = s.nextLine();

                String[] nameArr = parseUserInput(userRawName);
                setFirstName(nameArr[0]);
                setLastName(nameArr[1]);
                setMiddleName(nameArr[2]);
            }
            else if(action == 2){
                System.out.println(getFullName());
                System.out.println("What should their Student ID be?");
                int sid = s.nextInt();
                setStuNumber(sid);
            }
            else if(action == 3){
                System.out.println(getFullName());
                System.out.println("What should their GPA be?");
                double GPA = s.nextDouble();
                setGpa(GPA);
            }
            else{
                run = false;
            }

        }

    }


    /**
     * Generates a full name given based off of the parameters given
     * @param   String  Last Name
     * @param   String  First Name
     * @param   String  Middle name
     * @return  String  last, first m
     */
    public static String generateFullName(String lastName, String firstName, String middleName){
        return lastName + ", " + firstName + " " + middleName;
    }


    public static String parseUserReturnType = "";

    /**
     * Returns the user input for a name in a standardized manner
     * @param rawStudentName
     * @return First Last M of input
     */
    public static String[] parseUserInput(String rawStudentName){  //Returns First Last M
        int numberOfCommas = StringUtils.countMatches(rawStudentName,',');
        int numberOfSpaces = StringUtils.countMatches(rawStudentName,' ');
        String[] studentNameArray = new String[3];
        if(numberOfCommas > 0){ // FORMAT: Last, First M
            rawStudentName = rawStudentName.replaceAll(",","");
            studentNameArray = rawStudentName.split(" ");
            studentNameArray = new String[]{studentNameArray[1], studentNameArray[0], studentNameArray[2]};
            parseUserReturnType = UserInputTypes.LFM.get();



        }
        else if(numberOfSpaces >= 2){ // FORMAT: First M Last

            studentNameArray = rawStudentName.split(" ");
            studentNameArray = new String[]{studentNameArray[0], studentNameArray[2], studentNameArray[1]};
            parseUserReturnType = UserInputTypes.FML.get();

        }
        else if(numberOfSpaces == 1){ // FORMAT: First Last

            studentNameArray = rawStudentName.split(" ");
            studentNameArray = new String[]{studentNameArray[0], studentNameArray[1], ""};
            parseUserReturnType = UserInputTypes.FL.get();

        }
        else{
            throw new RuntimeErrorException(new Error("UNKNOWN FORMAT" + rawStudentName));


        }
        return studentNameArray;
    }




}
