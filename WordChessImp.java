import java.io.*;
import java.util.*;

/**
 * A common form of word puzzle is so-called "word chess".
 * Starting from an Enlish word w, and changing only one letter at a time,
 * derive a second word w'. All intermediate stages must also be valid Enlish
 * words.
 * So given e.g. SICK and WELL, one solution would be:
 * SICK, SILK, SILL, SELL, WELL
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
        ArrayDeque<Integer> queuebackup = new ArrayDeque<>();
        MatchingComparator comp = new MatchingComparator(dictionary, endWord);
        PriorityQueue<Integer> queue = new PriorityQueue<>(comp);
        int start = lookUp(dictionary, startWord);
        int end = lookUp(dictionary, endWord);
        queue.add(start);
        boolean[] visited = new boolean[dictionary.length];
        int[] parent = new int[dictionary.length];
        visited[start] = true;
        for(int i=0; i<parent.length; i++) {parent[i] = -1;}
        boolean found = false;

        while(found == false && queue.isEmpty() == false)
        {
            int pop = (int) queue.poll();
            for(int i=0; i<dictionary.length; i++) {
                if(visited[i]==false && nextTo(dictionary, pop, i)) {
                    parent[i] = pop;
                    if(i == end) {
                        found = true;
                        break;
                    }
                    
                    visited[i] = true;
                    queuebackup.add(i);
                }
            }
            refill(queuebackup, queue);
        }

        int j = end;
        String[] stages = new String[getDepth(parent, j)];
        for(int i=0; i<stages.length; i++) {
            stages[stages.length-1-i] = dictionary[j];
            j = parent[j];
        }
        return stages;
    }

    /**
     * refill makes sure the priority queue only reorders items in the added layers.
     * After priority queue finishes a layer then queuebackup refills it up again.
     * @param queuebackup A normal ArrayDeque queue of index words from dictionary
     * @param queue A priority queue of index words
     */
    private void refill(ArrayDeque queuebackup, PriorityQueue queue) {
        if(queue.isEmpty()) {
            while(!queuebackup.isEmpty())
            {
                queue.add(queuebackup.pop());
            }
        }
    }

    /**
     * getDepth finds the depth of the child to the parent
     *
     * @param parent A parameter
     * @param child A parameter
     * @return Depth number
     */
    private int getDepth(int[] parent, int child) {
        int count = 0;
        int i = child;
        while(i != -1) {
            count++;
            i = parent[i];
        }
        return count;
    }

    /**
     * nextTo checkes if word1 is adjacent to word2 by one letter.
     *
     * @param dictionary The set of words that can be used in the sequence
     * @param word1 A parameter
     * @param word2 A parameter
     * @return The return value
     */
    private boolean nextTo(String[] dictionary, int word1, int word2) {
        if(dictionary[word1].length() != dictionary[word2].length()) {
            return false;
        }

        String a = dictionary[word1];
        String b = dictionary[word2];
        int changes=0;
        for(int i=0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                changes++;
                if(changes > 1) {
                    return false;
                }
            }
        }
        return changes==1;
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

}
