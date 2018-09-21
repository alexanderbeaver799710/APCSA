
/**
 * Write a description of class CalcRunner here.
 *
 * @author (Alex Beaver)
 * @version (822)
 */
public class CalcRunner extends SimpleCalc
{
    public static void main(){
        SimpleCalc sc = new SimpleCalc();
        System.out.println(sc.add(3,2));
        System.out.println(sc.subtract(3,2));
        System.out.println(sc.multiply(3,2));
        System.out.println(sc.divide(3,2));
        System.out.println(sc.modulo(3,2));
        System.out.println(sc.sqrt(36));
        System.out.println(sc.exponent(3,2));
        
        System.out.println(sc.sin(55));
        System.out.println(sc.tan(55));
        System.out.println(sc.cos(55));
        System.out.println(sc.log(55));
        System.out.println(sc.hypot(3,4));
    }
}
