package com.alexbeaver.prime;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static ArrayList<Boolean> a = new ArrayList<Boolean>();

    public static ArrayList<Boolean> expn (ArrayList<Boolean> x){
        ArrayList<Boolean> out = new ArrayList<Boolean>();
        System.out.println();
        for(long i = 0; i < Math.pow(2,x.size())-1; i++){
            out.add(true);
        }
        System.out.println();

        return out;
    }
    public static void main(String[] args) {
	// write your code here
        a.add(Boolean.TRUE);
        a.add(Boolean.TRUE);
        a.add(Boolean.TRUE);
        while(true){
            a = expn(a);
            System.out.println(convertToLong(a));
        }


    }
    public static long convertToLong(ArrayList<Boolean> a){
        long place = 1;
        long result = 0;
        for(int i = 0; i < a.size(); i++){
            short val = 0;
            if(a.get(a.size()-1-i) == true){
                val = 1;
            }
            result += val*place;
            place = (long)Math.pow(place,2);

        }
        return result;
    }
}
