

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class PerGeschlechtTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PerGeschlechtTest
{
    /**
     * constructor: initialisations for each test case
     */
    public PerGeschlechtTest()
    {
    }

    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testMethod()
    {
        Vergleicher test = new PerGeschlecht();
        Person p1 = new Person("Jade", "Raymond", 1975, Geschlecht.WEIBLICH);
        Person p2 = new Person("Jade", "Raymond", 1975, Geschlecht.MAENNLICH);
        assert(test.vergleiche(p1,p2) < 0);
        
        Person p3 = new Person("Jade", "Raymond", 1975, Geschlecht.DIVERS);
        assert(test.vergleiche(p1,p3) < 0);
        assert(test.vergleiche(p3,p2) < 0);
    }

}