import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offBy3 = new OffByN(3);

    @Test
    public void TestequalChars(){
        assertTrue(offBy3.equalChars('a', 'd'));
        assertTrue(offBy3.equalChars('q', 't'));
        assertTrue(offBy3.equalChars('o', 'r'));
    }

    // Your tests go here.
} /*Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/