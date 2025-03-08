/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator offByOne = new OffByOne();

        System.out.println("The palindrome:");
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
            if( word.length() >= minLength && palindrome.isPalindrome(word, offByOne)){
                boolean flag = (palindrome.isPalindrome(word, offByOne));
                System.out.println(word + " is OffByOne!");
            }
            
            
        }

        // System.out.println("The offbyone :");
        // while (!in.isEmpty()){
        //     String word = in.readString();
        //     if( word.length() >= minLength && palindrome.isPalindrome(word, offByOne)){
        //         System.out.println(word);
        //     }
        // }
    }
} /*Uncomment this class once you've written isPalindrome. */