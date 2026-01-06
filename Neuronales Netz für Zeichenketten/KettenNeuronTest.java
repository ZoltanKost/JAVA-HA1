
import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class KettenNeuronTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class KettenNeuronTest
{
    /**
     * constructor: initialisations for each test case
     */
    public KettenNeuronTest()
    {
        
    }
    @Test
    public void testKlassenArbeit()
    {
        Signal s1 = new Signal("axa");
        Signal s2 = new Signal("Hallo");
        Signal s3 = new Signal("Regallager");
        
        PalindromNeuron pn1 = new PalindromNeuron(true);
        PalindromNeuron pn2 = new PalindromNeuron(true);
        
        pn1.eingangHinzufuegen(s1);
        pn1.eingangHinzufuegen(s2);
        
        pn2.eingangHinzufuegen(s2);
        pn2.eingangHinzufuegen(s3);
        
        KettenNeuron kn = new KettenNeuron();
        
        kn.eingangHinzufuegen(pn1);
        kn.eingangHinzufuegen(pn2);
        
        assertTrue(kn.getAusgangswert().equals("axa Regallager "));
    }

    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testConcat()
    {
        KettenNeuron neuron = new KettenNeuron();
        neuron.eingangHinzufuegen(new Signal("abc"));
        neuron.eingangHinzufuegen(new Signal("bca"));
        neuron.eingangHinzufuegen(new Signal("malla"));
        assertTrue(neuron.getAusgangswert().equals("abc bca malla "));
    }
    @Test
    public void testEmpty()
    {
        KettenNeuron neuron = new KettenNeuron();
        //neuron.eingangHinzufuegen(new Signal("abc"));
        //neuron.eingangHinzufuegen(new Signal("bca"));
        //neuron.eingangHinzufuegen(new Signal("malla"));
        assertTrue(neuron.getAusgangswert().equals(""));
    }

}