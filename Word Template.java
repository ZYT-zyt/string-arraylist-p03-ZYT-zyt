import java.util.ArrayList;
import java.util.List;

public class Word{
    /** Scrambles a given word.
     *  @param word the word to be scrambled
     *  @return the scrambled word (possibly equal to word)
     *  Precondition: word is either an empty string or contains only uppercase letters
     *  Postcondition: the string returned was created from word as follows:
     *  - the word was scrambled, beginning at the first letter and continuing from left to right
     *  - two consecutive letters consisting of "A" followed by a letter that was not "A" was swapped
     *  - letters were swapped at most one
     */
    public static String scrambleWord(String word)
    {
        /* part (a) */
        int i = 0;
        while(i < word.length() - 1){
            String front = word.substring(i,i + 1);
            String behind = word.substring(i + 1,i + 2);
            if(front.equals("A") && !behind.equals("A")){
                word = word.substring(0,i) + behind + "A" + word.substring(i + 2);
                i += 2;
            }
            else
               i++;          
        }
        return word;         
    }
    /** Modifies wordList by replacing each word with its scrambled
     *  version, removing any words that are unchanged as a result of scrambling.
     *  @param wordList the list of words
     *  Precondition: wordList contains only non-null objects
     *  Postcondition:
     *  - all words unchanged by scrambling have been removed from wordList
     *  - each of the remaining words has been replaced by its scrambled version
     *  - the relative ordering of the entries in wordList is the same as it was 
     *    before the method was called
     */
    public static void scrambleOrRemove(List<String> wordList){
        /* part (b) */
        for(int i = 0; i < wordList.size(); i++){
            String scrambled = scrambleWord(wordList.get(i));
            if(scrambled.equals(wordList.get(i))){
                wordList.remove(i);
                i--;
            }
            else{
               wordList.set(i,scrambled);
            }
        
        }
    }

    public static void main(String[] args)
    {
      
    }
}
