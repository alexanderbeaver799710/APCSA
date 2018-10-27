import java.lang.*;
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
        return lastName + ", " + firstName + " " + middleName;
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
}
