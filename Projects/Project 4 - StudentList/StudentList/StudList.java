
import java.util.ArrayList;

/**
 * Write a description of class StudList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudList
{
    ArrayList<Student> studentList = new ArrayList<Student>();


    /**
     * Constructor for objects of class StudList
     */
    public StudList()
    {

    }

    /**
     * Create a new student
     * @param firstName
     * @param lastName
     * @param middleName
     * @param studentNumber     Must be solely numeric digits
     * @param gpa   Can contain a decimal
     */
    public void addStudent(String firstName, String lastName, String middleName, int studentNumber, double gpa){
        studentList.add(new Student(firstName, lastName, middleName, studentNumber, gpa));
    }


    /**
     * Clears the entire list
     */
    public void clearList(){
        studentList.clear();
    }

    /**
     * Prints the list to the console in a tabular manner
     */
    public void printList(){
        System.out.println("===================================");
        for(Student student : studentList){

            System.out.println("Name: " + student.getFullName() + " | Student ID: " + student.getStuNumber() + " | GPA: " + student.getGPA());
        }
        System.out.println("===================================");

    }

    /**
     * Prints a student to the console
     * @param id
     */
    public void printStudent(int id){
        for(Student studentObject : studentList){
            if(studentObject.getStuNumber() == id){
                System.out.println("===================================");
                System.out.println("Name: "+ studentObject.getFullName());
                System.out.println("Student #: "+studentObject.getStuNumber());
                System.out.println("GPA: "+studentObject.getGPA());
                System.out.println("===================================");
            }
        }
    }
    public void printStudent(String studentName){

        int indexToPrint = -1;

        for(Student student : studentList){
            System.out.println(student.getFullName() + "|" + studentName);
            if(student.getFullName().equals(studentName)){
                indexToPrint = studentList.indexOf(student);

            }
        }
        if(indexToPrint > -1){
            Student student = studentList.get(indexToPrint);
            System.out.println("===================================");
            System.out.println("Name: "+ student.getFullName());
            System.out.println("Student #: "+student.getStuNumber());
            System.out.println("GPA: "+student.getGPA());
            System.out.println("===================================");

        } else{
            System.out.println("Not Found");
        }
    }



    /**
     * Deletes a student with a given ID
     * @param studentID
     */
    public void deleteStudent(int studentID){
        int indexToRemove = -1;
        for(Student student : studentList){
            if(student.getStuNumber() == studentID){
                indexToRemove = studentList.indexOf(student);
            }
        }
        if(indexToRemove > -1){
            studentList.remove(indexToRemove);

        }
    }




    /**
     * Deletes a student with a given name; middle name format
     * @param studentName
     */
    public void deleteStudent(String studentName){

        int indexToRemove = -1;

        for(Student student : studentList){
            System.out.println(student.getFullName() + "|" + studentName);
            if(student.getFullName().equals(studentName)){
                indexToRemove = studentList.indexOf(student);

            }
        }
        if(indexToRemove > -1){

            studentList.remove(indexToRemove);
        } else{
            System.out.println("Not Found");
        }

    }
    public void editStudent(int studentID){
        int indexToEdit = -1;
        for(Student student : studentList){
            if(student.getStuNumber() == studentID){
                indexToEdit = studentList.indexOf(student);
            }
        }
        if(indexToEdit > -1){
            studentList.get(indexToEdit).edit();

        }
    }
    public void editStudent(String studentName){

        int indexToEdit = -1;

        for(Student student : studentList){
            System.out.println(student.getFullName() + "|" + studentName);
            if(student.getFullName().equals(studentName)){
                indexToEdit = studentList.indexOf(student);

            }
        }
        if(indexToEdit > -1){
            Student student = studentList.get(indexToEdit);
            student.edit();

        } else{
            System.out.println("Not Found");
        }
    }






}
