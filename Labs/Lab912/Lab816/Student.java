
/**
 * Write a description of class Student here.
 *
 * @author (Alex)
 * @version (816)
 */
public class Student extends StudentRunner
{
    // instance variables - replace the example below with your own
    private int studentID;
    private String name;

    /**
     * Constructor for objects of class Student
     */
    public Student(String paramName,int paramStudentID)
    {
        // initialise instance variables
        studentID = paramStudentID;
        name = paramName;
    }

    public int getStudentID(){
        return studentID;
    }
    
    public void setStudentID(int paramStudentID){
        studentID = paramStudentID;
    }
    public String getStudentName(){
        return name;
    }
    public void setStudentName(String paramName){
        name = paramName;
    }
}
