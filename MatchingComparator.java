import java.lang.*;

/**
 * MatchingComparator compares how closely matching a string is to a target word.
 */
public class MatchingComparator implements Comparator<Integer>
{
    private String[] dictionary;
    private String target;

    public MatchingComparator(String[] dictionary, String target)
    {
        this.dictionary = dictionary;
        this.target = target;
    }

    @Override
    public int compare(int a, int b)
    {
        int anum = numCharMatch(dictionary[a], target);
        int bnum = numCharMatch(dictionary[b], target);
        if(anum > bnum) {
            return -1;
        } else if(anum < bnum) {
            return 1;
        } else {
            return 0;
        }
    }

    private int numCharMatch(String a, String b) 
    {
        int length;
        if(a.length() < b.length()) {
            length = a.length();
        } else {
            length = b.length();
        }

        int count = 0;
        for(int i=0; i < length; i++) {
            if(a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}