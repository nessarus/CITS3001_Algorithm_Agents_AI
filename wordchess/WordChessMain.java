package wordchess;

import java.io.*;
import java.util.*;

public class WordChessMain 
{
    public static void main(String[] args) 
    throws FileNotFoundException
    {
    	// WordChess
        Scanner sc;
        if(args.length != 0) {
            File file = new File(args[0]);
            sc = new Scanner(file);
        } else {
        	System.out.println("Requires a dictionary");
            return;
        }
        if(!sc.hasNextInt())
        {
        	System.out.println("Place number of lines at top of dictionary");
        	sc.close();
        	return;
        }
        
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        sc.close();
        
        Scanner userin = new Scanner(System.in);
        
        WordChessImp word = new WordChessImp();
        while(userin.hasNext())
        {
        	//long time1 = System.nanoTime();
        	String[] output = word.findPath(arr, userin.next().toUpperCase(), userin.next().toUpperCase());
        	
        	//time1 = System.nanoTime() - time1;
        	//System.out.println("" + time1/1000000 + "ms");
        	for(int i=0; i<output.length; i++) {
        		System.out.println(output[i]);
        	}
        }
        
        userin.close();
    }
}