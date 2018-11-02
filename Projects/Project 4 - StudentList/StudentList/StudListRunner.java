import java.util.*;

import org.apache.commons.lang3.StringUtils;

/**
 * Write a description of class StudListRunner here.
 *
 * @author (Alex Beaver)
 * @version (25 October 2018)
 */
public class StudListRunner
{


    public static boolean runLoop = true;

    /**
     * Constructor for objects of class StudListRunner
     */

    public StudListRunner()
    {
        // initialise instance variables
    }
    public static StudList students;

    /**
     * Runner function for the program
     * @param args
     */
    public static void main(String args[]){
        ConsoleMethods.clearScreen();
        students = new StudList();
            while(runLoop){
            String choice = generateMenu();
            if(choice.equals( MenuOptions.NEWSTUDENT.get())){
                addStudentToList();
            }
            else if(choice.equals( MenuOptions.DELETESTUDENT.get())) {
                deleteStudentFromList();
            }
            else if(choice.equals( MenuOptions.STUDENTLIST.get())){
                printAll();
            }
            else if(choice.equals(MenuOptions.EDITSTUDENT.get())){
                editStudentList();

            }
            else if(choice.equals(MenuOptions.CLEARLIST.get())){
                clearList();

            }
            else if(choice.equals( MenuOptions.PRINTSTUDENT.get())){
                printStudent();

            }
            else if(choice.equals(MenuOptions.BYPASS.get())){
                runLoop = false;
                ConsoleMethods.clearScreen();
                System.exit(0);
            }   
            else{
                ConsoleMethods.clearScreen();
                System.out.println("Invalid Input " +choice);
                ConsoleMethods.waitForInput();
            }
        }

    }

    /**
     * Generates the main menu for the program
     * @return  the choice corresponding to the MenuOption Enum
     */
    public static String generateMenu(){
        ConsoleMethods.clearScreen();

        System.out.println("Choose an option:");
        System.out.println("0. Quit");
        System.out.println("1. New Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Print Student List");
        System.out.println("4. Edit Student");
        System.out.println("5. Clear List");
        System.out.println("6. Print Student");


        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;

    }

    /**
     * Loads the interface to add a student to the list
     */
    public static void addStudentToList(){
        ConsoleMethods.clearScreen();

        System.out.println("Who would you like to add?");
        Scanner scanner = new Scanner(System.in);
        String rawStudentName = scanner.nextLine();
        String[] studentNameArray = Student.parseUserInput(rawStudentName);
        System.out.println("And what is their Student ID?");
        int StuID = scanner.nextInt();
        System.out.println("And finally, their GPA");
        double gpa = scanner.nextDouble();
        if(Student.parseUserReturnType.equals(UserInputTypes.FL.get())){
            students.addStudent(studentNameArray[0], studentNameArray[1], "", StuID, gpa);
        }
        else{
            students.addStudent(studentNameArray[0], studentNameArray[1], studentNameArray[2], StuID, gpa);
        }

        System.out.println("Student added");
        ConsoleMethods.waitForInput();
    }

    /**
     * Loads the interface to delete a student from the list
     */
    public static void deleteStudentFromList(){
        ConsoleMethods.clearScreen();
        Scanner s = new Scanner(System.in);
        System.out.println("1. Delete by Student ID | 2. Delete by Student Name");
        int method = s.nextInt();
       
        if(method == 1){
            ConsoleMethods.clearScreen();
            System.out.println("What is their Student ID?");
            int stuID = s.nextInt();
            students.deleteStudent(stuID);
        }
        else if(method == 2){
            ConsoleMethods.clearScreen();
            System.out.println("Who would you like to delete?");
            Scanner scanner = new Scanner(System.in);
            String rawStudentName = scanner.nextLine();
            String[] studNameList = Student.parseUserInput(rawStudentName);
            if(Student.parseUserReturnType.equals(UserInputTypes.FL.get())){
                students.deleteStudent(Student.generateFullName(studNameList[0], studNameList[1], ""));
            }
            else{
                students.deleteStudent(Student.generateFullName(studNameList[0], studNameList[1], studNameList[2]));
            }

        }
    }
    /**
     * The UI for editing a student
     */
    public static void editStudentList(){
        ConsoleMethods.clearScreen();
        Scanner s = new Scanner(System.in);
        System.out.println("1. Edit by Student ID | 2. Edit by Student Name");
        int method = s.nextInt();
        ConsoleMethods.clearScreen();
        if(method == 1){
            System.out.println("What is their Student ID?");
            int stuID = s.nextInt();
            students.editStudent(stuID);
        }
        else if(method == 2){
            System.out.println("Who would you like to Edit?");
            Scanner scanner = new Scanner(System.in);
            String rawStudentName = scanner.nextLine();
            String[] studNameList = Student.parseUserInput(rawStudentName);
            if(Student.parseUserReturnType.equals(UserInputTypes.FL.get())){
                students.editStudent(Student.generateFullName(studNameList[1], studNameList[0], ""));
            }
            else{

                students.editStudent(Student.generateFullName(studNameList[1], studNameList[0], studNameList[2]));
            }

        }
        
    }

    /**
     * Clears the list
     */
    public static void clearList(){
        students.clearList();
    }
    /**
     * UI To print all of the students
     */
    public static void printAll(){
        students.printList();
    
    }
    /**
     * UI TO print a given student
     */
    public static void printStudent(){
        ConsoleMethods.clearScreen();
        Scanner s = new Scanner(System.in);
        System.out.println("1. Print by Student ID | 2. Print by Student Name");
        int method = s.nextInt();
        ConsoleMethods.clearScreen();
        if(method == 1){
            System.out.println("What is their Student ID?");
            int stuID = s.nextInt();
            students.printStudent(stuID);
        }
        else if(method == 2){
            System.out.println("Who would you like to print?");
            Scanner scanner = new Scanner(System.in);
            String rawStudentName = scanner.nextLine();
            String[] studNameList = Student.parseUserInput(rawStudentName);
            if(Student.parseUserReturnType.equals(UserInputTypes.FL.get())){
                students.printStudent(Student.generateFullName(studNameList[1], studNameList[0], ""));
            }
            else{

                students.printStudent(Student.generateFullName(studNameList[1], studNameList[0], studNameList[2]));
            }

        }
        ConsoleMethods.waitForInput();
    }
    
}
