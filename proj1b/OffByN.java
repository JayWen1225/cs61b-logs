public class OffByN implements CharacterComparator{
    public int num;
    
    public OffByN(int n){
        num = n;
    }

    public boolean equalChars(char x, char y){
        int diff = x - y;
        if ( diff == num || diff == (-num))
        {
            return true;
        }
        return false;
    }
    
}