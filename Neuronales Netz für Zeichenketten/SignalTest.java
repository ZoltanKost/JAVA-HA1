
import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class SignalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SignalTest
{
    HashSet<Neuron> set = new HashSet<Neuron>();
    /**
     * constructor: initialisations for each test case
     */
    public SignalTest()
    {
        set = new HashSet<Neuron>(); 
    }

    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void TestEquals()
    {
        set = new HashSet();
        // add source code that manipulates an instance of the class under test
        Neuron neuron = new Signal("signal");
        set.add(neuron);
        assert(!set.add(neuron));
        
    }
    @Test
    public void TestSameString()
    {
        set = new HashSet();
        // add source code that manipulates an instance of the class under test
        Neuron neuron = new Signal("signal");
        set.add(neuron);
        assert(!set.add(new Signal("signal")));
    }
    @Test
    public void TestOtherString()
    {
        set = new HashSet();
        // add source code that manipulates an instance of the class under test
        Neuron neuron = new Signal("signal");
        set.add(neuron);
        assert(set.add(new Signal("abc")));
    }
}