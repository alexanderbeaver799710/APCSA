
/**
 * Write a description of class StudentRunner here.
 *
 * @author (AlexBeaver)
 * @version (813)
 */
public class StudentRunner
{
    public static void main(){
        String[] names = {"James", "John", "John", "Kim", "K"};
        int[] stuNums = {1,2,3,4,5};
        Student[] students = new Student[5];
        for(int i = 0; i < names.length; i++){
            students[i] = new Student(names[i],stuNums[i]);
        }
        for(int x = 0; x < students.length; x++){
            System.out.println(students[x].getStudentName() + " " + students[x].getStudentID());
        }
       
    }
}
