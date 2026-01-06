import static org.junit.Assert.*;

import org.junit.Test;
/**
 * The test class TagTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TagTest
{
    /**
     * Testet, ob zwei Tag-Exemplare, die denselben Tag repräsentieren,
     * als gleich angesehen werden.
     */
    @Test
    public void testGleichheit()
    {
        Tag tag = new Tag(123);
        Tag tag1 = new Tag(123);
        assert(tag.equals(tag1));
    }
    
    /**
     * Testet, ob zwei Tag-Exemplare, die verschiedene Tage repräsentieren,
     * als ungleich angesehen werden.
     */
    @Test
    public void testUngleichheit()
    {
        Tag tag = new Tag(158);
        Tag tag1 = new Tag(25);
        assert(!tag.equals(tag1));
    }
}