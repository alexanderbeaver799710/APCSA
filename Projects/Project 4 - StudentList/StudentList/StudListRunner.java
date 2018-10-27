import java.util.*;
import org.apache.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Write a description of class StudListRunner here.
 *
 * @author (Alex Beaver)
 * @version (25 October 2018)
 */
public class StudListRunner
{
    


    /**
     * Constructor for objects of class StudListRunner
     */
    public static boolean runLoop = true;
    public StudListRunner()
    {
        // initialise instance variables
    }
    public static StudList students;

    public static void main(String args[]){
        students = new StudList();
            while(runLoop){
            int choice = generateMenu();
            if(choice == MenuOptions.NEWSTUDENT.get()){
                addStudentToList();
            }
            else if(choice == MenuOptions.DELETESTUDENT.get()) {

            }
            else if(choice == MenuOptions.STUDENTLIST.get()){
                students.printList();
            }
        }

    }
    public static int generateMenu(){
        System.out.println("===================================");
        System.out.println("Choose an option:");
        System.out.println("1. New Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Print Student List");
        System.out.println("===================================");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;

    }
    public static void addStudentToList(){
        System.out.println("===================================");
        System.out.println("Who would you like to add?");
        Scanner scanner = new Scanner(System.in);
        String rawStudentName = scanner.nextLine();
        int numberOfCommas = StringUtils.countMatches(rawStudentName,',');
        int numberOfSpaces = StringUtils.countMatches(rawStudentName,' ');
        if(numberOfCommas > 0){ // FORMAT: Last, First M
            rawStudentName = rawStudentName.replaceAll(",","");
            String[] studentNameArray = rawStudentName.split(" ");

            System.out.println("And what is their Student ID?");
            int StuID = scanner.nextInt();
            System.out.println("And finally, their GPA");
            double gpa = scanner.nextDouble();
            students.addStudent(studentNameArray[1], studentNameArray[0], studentNameArray[2], StuID, gpa);
            System.out.println("Student added");


        }
        else if(numberOfSpaces >= 2){ // FORMAT: First M Last

            String[] studentNameArray = rawStudentName.split(" ");

            System.out.println("And what is their Student ID?");
            int StuID = scanner.nextInt();
            System.out.println("And finally, their GPA");
            double gpa = scanner.nextDouble();
            students.addStudent(studentNameArray[0], studentNameArray[2], studentNameArray[1], StuID, gpa);
            System.out.println("Student added");


        }
        else if(numberOfSpaces == 1){ // FORMAT: First Last

            String[] studentNameArray = rawStudentName.split(" ");

            System.out.println("And what is their Student ID?");
            int StuID = scanner.nextInt();
            System.out.println("And finally, their GPA");
            double gpa = scanner.nextDouble();
            students.addStudent(studentNameArray[0], studentNameArray[1], "", StuID, gpa);
            System.out.println("Student added");


        }
    }
    public static void deleteStudentFromList(){
    }
    public static void editStudentList(){
    }
    public static void clearList(){
    }
    public static void printAll(){
    }
    public static void printStudent(){
    }
    
}
