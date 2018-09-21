//© A+ Computer Science  -  www.apluscompsci.com

import java.util.*;
import javax.swing.*;

//this example demonstrates how to to use a
//while loop to average all of the digits of a number

public class AveragingDigits
{
    //pre - num > 0
    //post - number of digits in num will be returned
    public static int countDigits( int num )
    {
        int counter = 0;
        while(num > 0){
            num /= 10;
            counter++;
          
          }
          return counter;
    }

    //pre - num > 0
    //post - sum of digits in num will be returned
    public static double sumDigits( int num )
    {
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
            
          
          }
          return sum;
    }

    //pre - none
    //post - average of digits in num will be returned
    //         unless num <= 0 then 0 is returned
    public static double averageDigits( int num )
    {
        return sumDigits(num)/countDigits(num);
    }

   public static void main(String args  [])
   {
        /*
        Scanner kb = new Scanner( System.in );
        System.out.print( "Enter a number > 0 :: " );
        int num = kb.nextInt();
        */
        
       int num = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
       
        
        //System.out.println("The digit average is " + averageDigits( num) );
        
        JOptionPane.showMessageDialog(null,"Your average is " + averageDigits(num));
    }
}
