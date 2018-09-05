import java.io.*;
import java.util.*;

public class MainClass 
{
    public static void main(String[] args) 
    throws FileNotFoundException
    {
        Scanner sc;
    	if(args.length != 0) {
    		File file = new File(args[0]);
    		sc = new Scanner(file);
    	} else {
        	sc = new Scanner(System.in);
		}
		
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }

        WordChessImp word = new WordChessImp();
        String[] output = word.findPath(arr, "DRY", "WET");

        for(int i=0; i<output.length; i++) {
            System.out.println(output[i]);
        }

        sc.close();
    }
}