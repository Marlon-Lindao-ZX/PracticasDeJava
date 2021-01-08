import junit.framework.TestCase;

public class PigLatinTest extends TestCase {

    public void testConvertWord() {
        System.out.println("Testing convertWord");

        PigLatin pl = new PigLatin("About");
        assertEquals("aboutway ", pl.toString());

//        pl = new PigLatin("Hello");
//        assertEquals("ellohay ", pl.toString());

    }

}
