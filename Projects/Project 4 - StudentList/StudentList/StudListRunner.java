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
        students = new StudList();
            while(runLoop){
            int choice = generateMenu();
            if(choice == MenuOptions.NEWSTUDENT.get()){
                addStudentToList();
            }
            else if(choice == MenuOptions.DELETESTUDENT.get()) {
                deleteStudentFromList();
            }
            else if(choice == MenuOptions.STUDENTLIST.get()){
                printAll();
            }
            else if(choice == MenuOptions.EDITSTUDENT.get()){
                editStudentList();

            }
            else if(choice == MenuOptions.CLEARLIST.get()){
                clearList();

            }
            else if(choice == MenuOptions.PRINTSTUDENT.get()){
                printStudent();

            }
            else{ // Bypass
                runLoop = false;
            }
        }

    }

    /**
     * Generates the main menu for the program
     * @return  the choice corresponding to the MenuOption Enum
     */
    public static int generateMenu(){
        System.out.println("===================================");
        System.out.println("Choose an option:");
        System.out.println("1. New Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Print Student List");
        System.out.println("4. Edit Student");
        System.out.println("5. Clear List");
        System.out.println("6. Print Student");
        System.out.println("===================================");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;

    }

    /**
     * Loads the interface to add a student to the list
     */
    public static void addStudentToList(){
        System.out.println("===================================");
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
    }

    /**
     * Loads the interface to delete a student from the list
     */
    public static void deleteStudentFromList(){
        Scanner s = new Scanner(System.in);
        System.out.println("1. Delete by Student ID | 2. Delete by Student Name");
        int method = s.nextInt();
        if(method == 1){
            System.out.println("What is their Student ID?");
            int stuID = s.nextInt();
            students.deleteStudent(stuID);
        }
        else if(method == 2){
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
    public static void editStudentList(){
        Scanner s = new Scanner(System.in);
        System.out.println("1. Edit by Student ID | 2. Edit by Student Name");
        int method = s.nextInt();
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


    public static void clearList(){
        students.clearList();
    }
    public static void printAll(){
        students.printList();
    }
    public static void printStudent(){
        Scanner s = new Scanner(System.in);
        System.out.println("1. Print by Student ID | 2. Print by Student Name");
        int method = s.nextInt();
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
    }
    
}
