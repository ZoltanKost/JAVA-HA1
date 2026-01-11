
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
    public void testKlassenArbeit2()
    {
        Signal s1 = new Signal("axa");
        Signal s2 = new Signal("Hallo");
        Signal s3 = new Signal("Regallager");
        Signal s4 = new Signal("man");
        Signal s5 = new Signal("nam");
        PalindromNeuron pn1 = new PalindromNeuron(true);
        PalindromNeuron pn2 = new PalindromNeuron(true);
        PalindromNeuron pn3 = new PalindromNeuron(true);
        PalindromNeuron pn4 = new PalindromNeuron(true);
        
        pn1.eingangHinzufuegen(s1);
        pn1.eingangHinzufuegen(s2);
        
        pn2.eingangHinzufuegen(s2);
        pn2.eingangHinzufuegen(s3);
        
        pn3.eingangHinzufuegen(s3);
        pn3.eingangHinzufuegen(s4);
        
        pn4.eingangHinzufuegen(s4);
        pn4.eingangHinzufuegen(s1);
        
        KettenNeuron kn = new KettenNeuron();
        
        kn.eingangHinzufuegen(pn1);
        kn.eingangHinzufuegen(pn2);
        
        KettenNeuron kn1 = new KettenNeuron();
        
        kn1.eingangHinzufuegen(pn3);
        kn1.eingangHinzufuegen(pn4);
        
        PalindromNeuron n = new PalindromNeuron(true);
        
        n.eingangHinzufuegen(kn);
        n.eingangHinzufuegen(kn1);
        n.eingangHinzufuegen(pn3);
        
        System.out.println(n.getAusgangswert());
        assertTrue(kn.getAusgangswert().equals("axa Regallager"));
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
        
        assertTrue(kn.getAusgangswert().equals("axa Regallager"));
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
        assertTrue(neuron.getAusgangswert().equals("abc bca malla"));
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