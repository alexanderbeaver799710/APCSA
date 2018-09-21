
/**
 * Write a description of class StudentRunner here.
 *
 * @author (AlexBeaver)
 * @version (813)
 */
public class StudentRunner
{
    public static void main(){
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setStudentID(00001);
        s2.setStudentID(00002);
        s3.setStudentID(00003);
        System.out.println(s1.getStudentID());
        System.out.println(s2.getStudentID());
        System.out.println(s3.getStudentID());
       
    }
}
