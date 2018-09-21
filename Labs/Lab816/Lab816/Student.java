
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

    /**
     * Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables
        studentID = 0;
    }

    public int getStudentID(){
        return studentID;
    }
    
    public void setStudentID(int paramStudentID){
        studentID = paramStudentID;
    }
}
