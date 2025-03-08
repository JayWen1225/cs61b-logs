public class Palindrome{
    public Deque<Character> wordToDeque(String word){
        Deque<Character> temp = new LinkedListDeque<>();
        for( int i = 0; i < word.length(); i ++ ){
            char ch = word.charAt(i);
            temp.addLast(ch);
        }

        return temp;
    }
    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        StringBuilder actual = new StringBuilder();

        while (!d.isEmpty()) {
            actual.append(d.removeLast()); // Reverse the word
        }

        return actual.toString().equals(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        boolean isOdd = (word.length() % 2 == 1);
        Deque<Character> d = wordToDeque(word);
        
        if (word.length() <= 1){
            return true;
        }
        
        for ( int i = 0; i < (word.length()) / 2; i ++){
            if ( !cc.equalChars(d.get(i), d.get(word.length() - 1 - i))){
                return false;
            }
        }

        return true;
    }

    

}

