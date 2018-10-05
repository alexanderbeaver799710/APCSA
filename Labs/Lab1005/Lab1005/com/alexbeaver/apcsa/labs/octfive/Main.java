package com.alexbeaver.apcsa.labs.octfive;
import com.alexbeaver.*;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
   public static void main(){
       for(int i = 0; i < 100; i++){
       SentenceBuilder sb = new SentenceBuilder();
       System.out.println(sb.getSentence());
    }
    }
}
