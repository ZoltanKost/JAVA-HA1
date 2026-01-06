import java.util.HashSet;

/**
 * Write a description of class Signal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class PalindromNeuron implements Neuron
{
    private HashSet<Neuron> _eingaenge;
    private boolean _toLower;
    
    public PalindromNeuron(boolean toLower)
    {
        _toLower = toLower;
        _eingaenge = new HashSet<Neuron>();
    }
    public String getAusgangswert()
    {
        String palindrom = null;
        for(Neuron n : _eingaenge)
        {
            String s = n.getAusgangswert();
            String d = s;
            if(_toLower) d = d.toLowerCase();
            if(isPalindrom(d))
            {
                if(palindrom == null) palindrom = s;
                else 
                {
                    palindrom = 
                        palindrom.length() < s.length()
                            ? s
                            :palindrom;
                }
            }
        }
        return palindrom;
    }
    public void eingangHinzufuegen(Neuron neuron)
    {
        _eingaenge.add(neuron);
    }
    public boolean isPalindrom(String s)
    {
        if(s.length() < 2) return true;
        if(s.charAt(0) == s.charAt(s.length() - 1))
        {
            return isPalindrom(
                    s.substring(1,s.length() - 1));
        }else return false;
    }
}