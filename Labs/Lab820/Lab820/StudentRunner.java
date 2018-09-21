
/**
 * Write a description of class StudentRunner here.
 *
 * @author (AlexBeaver)
 * @version (813)
 */
public class StudentRunner extends Student
{
    public static void main(){
        
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student(00004, true, 5.0, "Veronica"); //See JavaDOC comment about the alternate constructor
        s1.setStudentID(00001);
        s2.setStudentID(00002);
        s3.setStudentID(00003);
        s1.setStudentActive(false);
        s2.setStudentActive(true);
        s3.setStudentActive(false);
        s1.setStudentGPA(4.0);
        s2.setStudentGPA(3.9);
        s3.setStudentGPA(2.1);
        s1.setStudentName("Anna");
        s2.setStudentName("Dylan");
        s3.setStudentName("Alex");
        System.out.println(s1.getStudentID());
        System.out.println(s1.getStudentActive());
        System.out.println(s1.getStudentGPA());
        System.out.println(s1.getStudentName());
        
        System.out.println("====================");
        System.out.println(s4.getStudentName());
        
        
        /**
         * Doing an array of students
         */
        
        
    }
}
