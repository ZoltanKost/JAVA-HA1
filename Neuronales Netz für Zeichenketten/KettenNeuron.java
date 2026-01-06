import java.util.ArrayList;
/**
 * Write a description of class KettenNeuron here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class KettenNeuron implements Neuron
{
    private ArrayList<Neuron> list;
    public KettenNeuron()
    {
        list = new ArrayList<Neuron>();
        
    }
    public void eingangHinzufuegen(Neuron neuron)
    {
        list.add(neuron);
    }
    public String getAusgangswert()
    {
        String result = "";
        for(Neuron n: list)
        {
            if(n.getAusgangswert() == null) continue;
            result += (n.getAusgangswert() + " ");
        }
        return result.substring(0, result.length());
    }
}