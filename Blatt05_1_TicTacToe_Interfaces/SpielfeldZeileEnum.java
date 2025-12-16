
/**
 * Write a description of class SpielfeldZeileEnum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class SpielfeldZeileEnum
{
    private Besitzer _celle0;
    private Besitzer _celle1;
    private Besitzer _celle2;
    
    public SpielfeldZeileEnum()
    {
        _celle0 = Besitzer.LEER;
        _celle1 = Besitzer.LEER;
        _celle2 = Besitzer.LEER;
    }
    
    public Besitzer gibBesitzer(int num)
    {
        switch(num)
        {
            case 0:
                return _celle0;
            case 1:
                return _celle1;
            case 2:
                return _celle2;
            default: throw new IllegalArgumentException();
        }
    }
    
    public void setBesitzer(int num, Besitzer besitzer)
    {
        switch(num)
        {
            case 0:
                _celle0 = besitzer;
                break;
            case 1:
                _celle1= besitzer;
                break;
            case 2:
                _celle2= besitzer;
                break;
            default: throw new IllegalArgumentException(" num is " + String.valueOf(num));
        }
    }
    
    public boolean istVoll()
    {
        return _celle0 != Besitzer.LEER && _celle1 != Besitzer.LEER && _celle2 != Besitzer.LEER;
    }
}