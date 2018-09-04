import java.io.*;
import java.util.*;

/**
 * A common form of word puzzle is so-called “word chess”.
 * Starting from an English word w, and changing only one letter at a time,
 * derive a second word w’. All intermediate stages must also be valid English
 * words.
 * So given e.g. SICK and WELL, one solution would be:
 * SICK, SILK, SILL, SELL, WELL
 *
 * @author Joshua Ng
 */
public class WordChessImp implements WordChess
{
    /**
     * Finds a shortest sequence of words in the dictionary such that the first word is the startWord, 
     * the last word is the endWord, and each word is equal to the previous word with one letter changed.
     * All words in the sequence are the same length. If no sequence is possible, an empty array is returned.
     * It is assumed that both startWord and endWord are elements of the dictionary.
     * @param dictionary The set of words that can be used in the sequence; all words in the dictionary are capitalised.
     * @param startWord the first word on the sequence.
     * @param endWord the last word in the sequence.
     * @return an array containing a shortest sequence from startWord to endWord, in order, 
     * using only words from the dictionary that differ by a single character.
     **/
    public String[] findPath(String[] dictionary, String startWord, String endWord)
    {
        ArrayDeque stack = new ArrayDeque<Integer>();
        int start = lookUp(dictionary, startWord);
        stack.push(start);
        boolean[] visited = new boolean[dictionary.length];
        
        
        while(stack.isEmpty() == false)
        {
            int current = (int) stack.pop();
            if( visited[current] == false ) {
                visited[current] = true;
                
                return null;
            }
        }
        
        return null;
    }
    
    
    
    /**
     * lookUp does a binary seach on dictionary looking for the word. 
     *
     * @param dictionary The set of words that can be used in the sequence
     * @param word A parameter
     * @return The return value
     */
    private int lookUp(String[] dictionary, String word) {
        int left = 0;
        int right = dictionary.length - 1;
        while(left <= right)
        {
            int m = (left+right)/2;
            int compare = dictionary[m].compareTo(word);
            if(compare < 0) {
                left = m + 1;
            } else if(compare > 0) {
                right = m - 1;
            } else {
                return m;
            }  
        }
        return -1;
    }

    public static void main(String args[]) throws FileNotFoundException
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
    }
}
