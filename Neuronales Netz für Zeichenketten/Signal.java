/**
 * Write a description of class Signal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Signal implements Neuron
{
    private String _wert;
    public Signal(String ausgangswert)
    {
        assert(ausgangswert != null);
        _wert = ausgangswert;
    }
    public String getAusgangswert()
    {
        return _wert;
    }
    public boolean equals(Object neuron)
    {
        if(!(neuron instanceof Signal))
        {
            return false;
        }
        Signal compare = (Signal) neuron;
        return _wert.compareTo(compare.getAusgangswert()) == 0;
    }
    public int hashCode()
    {
        return _wert.hashCode();
    }
}