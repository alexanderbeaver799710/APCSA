
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

    public void addStudent(String firstName, String lastName, String middleName, int studentNumber, double gpa){
        studentList.add(new Student(firstName, lastName, middleName, studentNumber, gpa));
    }
    public void deleteStudent(){
    }
    public void editStudentList(){
    }
    public void clearList(){
    }
    public void printList(){
        System.out.println("===================================");
        for(Student student : studentList){

            System.out.println("Name: " + student.getFullName() + " | Student ID: " + student.getStuNumber() + " | GPA: " + student.getGPA());
        }
        System.out.println("===================================");

    }
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
}
