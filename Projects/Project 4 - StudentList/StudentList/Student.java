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

    public String getFullName(){

    }
    public double getGPA(){
        return gpa;
    }
    public int getStuNumber(){
        return stuNumber;
    }
    public void setFirstName(String s){
        firstName = s;
    }
    public void setMiddleName(String s){
        middleName = s;
    }
    public void setLastName(String s){
        lastName = s;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void edit() {
        boolean run = true;
        Scanner s = new Scanner(System.in);
        while(run){
            System.out.println("===================================");
            System.out.println("Name: "+ getFullName());
            System.out.println("Student #: "+getStuNumber());
            System.out.println("GPA: "+getGPA());
            System.out.println("===================================");
            System.out.println("What would you like to edit?");
            System.out.println("1 Name | 2 # | 3 GPA | 4 DONE");
            int action = s.nextInt();
            if(action == 1){
                System.out.println("What should their name be?");
                String userRawName = s.nextLine();
                String username = userRawName;
                String[] nameArr = parseUserInput(username);
                setFirstName(nameArr[0]);
                setLastName(nameArr[1]);
                setMiddleName(nameArr[2]);
            }
            else if(action == 2){
                System.out.println("What should their Student ID be?");
                int sid = s.nextInt();
                setStuNumber(sid);
            }
            else if(action == 3){
                System.out.println("What should their GPA be?");
                double GPA = s.nextDouble();
                setGpa(GPA);
            }
            else{
                run = false;
            }

        }

    }


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
