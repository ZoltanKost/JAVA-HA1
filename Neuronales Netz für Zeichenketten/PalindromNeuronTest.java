

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class PalindromNeuronTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PalindromNeuronTest
{
    /**
     * constructor: initialisations for each test case
     */
    public PalindromNeuronTest()
    {
    }

    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testPalindrom()
    {
        PalindromNeuron p = new PalindromNeuron(true);
        p.eingangHinzufuegen(new Signal("ada"));
        p.eingangHinzufuegen(new Signal("add"));
        assertTrue(p.getAusgangswert().equals("ada"));
    }
    @Test
    public void testLongestPal()
    {
        PalindromNeuron p = new PalindromNeuron(true);
        p.eingangHinzufuegen(new Signal("ada"));
        p.eingangHinzufuegen(new Signal("adda"));
        assertTrue(p.getAusgangswert().equals("adda"));
    }
    @Test
    public void testNoPalindrom()
    {
        PalindromNeuron p = new PalindromNeuron(true);
        p.eingangHinzufuegen(new Signal("adab"));
        p.eingangHinzufuegen(new Signal("addb"));
        assertTrue(p.getAusgangswert() == null);
    }
    @Test
    public void testNullReturn()
    {
        PalindromNeuron p = new PalindromNeuron(true);
        p.eingangHinzufuegen(new Signal("adab"));
        p.eingangHinzufuegen(new Signal("addb"));
        assertTrue(p.getAusgangswert() == null);
    }
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testPalindromCaseSensitive()
    {
        PalindromNeuron p = new PalindromNeuron(false);
        p.eingangHinzufuegen(new Signal("ada"));
        p.eingangHinzufuegen(new Signal("adadA"));
        assertTrue(p.getAusgangswert().equals("ada"));
    }
    @Test
    public void testLongestPalCaseSensitive()
    {
        PalindromNeuron p = new PalindromNeuron(false);
        p.eingangHinzufuegen(new Signal("adDaD"));
        p.eingangHinzufuegen(new Signal("adda"));
        assertTrue(p.getAusgangswert().equals("adda"));
    }
    @Test
    public void testNoPalindromCaseSensitive()
    {
        PalindromNeuron p = new PalindromNeuron(false);
        p.eingangHinzufuegen(new Signal("adA"));
        p.eingangHinzufuegen(new Signal("add"));
        assertTrue(p.getAusgangswert() == null);
    }
    @Test
    public void testNullReturnCaseSensitive()
    {
        PalindromNeuron p = new PalindromNeuron(false);
        p.eingangHinzufuegen(new Signal("adA"));
        p.eingangHinzufuegen(new Signal("adD"));
        assertTrue(p.getAusgangswert() == null);
    }

}