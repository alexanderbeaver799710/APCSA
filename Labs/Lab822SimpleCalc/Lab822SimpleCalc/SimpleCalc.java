 
/**
 * Write a description of class SimpleCalc here.
 *
 * @author (Alex)
 * @version (822)
 */
import java.lang.Math;
public class SimpleCalc
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class SimpleCalc
     */
    public SimpleCalc()
    {
        // initialise instance variables
       
    }

    public double add(int a, int b){
        return a + b;
    }
    public double subtract(int a, int b){
        return a - b;
    }
    public double multiply(int a, int b){
        return a * b;
    }
    public double divide (int a, int b){
        if (b != 0){
            return a/b;
        }
        else{
            return 0;
        }
    }
    
    public int modulo (int a, int b){
        return a % b;
    }
    
    public double sqrt(int a){
        return Math.sqrt(a);
    }
    
    public double exponent(int a, int b){
        return Math.pow(a,b);
    }
    
    public double sin(double a){
        return Math.sin(a);
    }
    public double tan(double a){
        return Math.tan(a);
    }
    public double cos(double a){
        return Math.cos(a);
    }
    public double log(double a){
        return Math.log(a);
    }
    public double hypot(double a, double b){
        return Math.hypot(a,b);
    }
}
