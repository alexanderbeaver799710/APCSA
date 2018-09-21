//© A+ Computer Science  -  www.apluscompsci.com

//this example demonstrates how to to use a
//while loop to access all of the digits of a number

public class AccessingDigits
{
   public static void main(String args[])
   {
		int number = 9154;
		int total = 0;
		while( number > 0 )
		{
		   System.out.println( number % 10 );
		   total = total+ number % 10;
		   
		   number = number / 10;
		}
		System.out.println(total);
	}
}
