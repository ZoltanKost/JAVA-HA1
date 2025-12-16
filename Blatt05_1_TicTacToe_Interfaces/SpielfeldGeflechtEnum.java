
/**
 * Write a description of class SpielfeldGeflechtEnum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class SpielfeldGeflechtEnum implements Spielfeld
{
    private SpielfeldZeileEnum _zeile0;
    private SpielfeldZeileEnum _zeile1;
    private SpielfeldZeileEnum _zeile2;

    /**
     * Initialisiert ein neues, leeres Spielfeld.
     */
    public SpielfeldGeflechtEnum()
    {
        _zeile0 = new SpielfeldZeileEnum();
        _zeile1 = new SpielfeldZeileEnum();
        _zeile2 = new SpielfeldZeileEnum();
    }

    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        Besitzer besitzer;
        switch (zeile)
        {
        case 0:
            besitzer = _zeile0.gibBesitzer(spalte);
            break;

        case 1:
            besitzer = _zeile1.gibBesitzer(spalte);
            break;

        case 2:
            besitzer = _zeile2.gibBesitzer(spalte);
            break;

        default:
            throw new IllegalArgumentException(String.valueOf(zeile));
        }
        switch(besitzer)
        {
            case Besitzer.LEER:
            return 0;
            case Besitzer.FIRST:
            return 1;
            case Besitzer.SECOND:
            return 2;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Besetzt die angegebene Position auf dem Spielfeld für einen Spieler.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int zeile, int spalte, int spieler)
    {
        Besitzer besitzer = Besitzer.LEER;
        switch(spieler)
        {
            case 0: break;
            case 1:
                besitzer = Besitzer.FIRST;
            break;
            case 2:
                besitzer = Besitzer.SECOND;
            break;
            default: throw new IllegalArgumentException();
        }
        if(spalte < 0 || spalte > 3) throw new IllegalArgumentException("spalte is " + String.valueOf(spalte));
        switch (zeile)
        {
        case 0:
            _zeile0.setBesitzer(spalte, besitzer);
            break;

        case 1:
            _zeile1.setBesitzer(spalte, besitzer);
            break;

        case 2:
            _zeile2.setBesitzer(spalte, besitzer);
            break;

        default:
            throw new IllegalArgumentException(String.valueOf(zeile));
        }
    }

    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        return _zeile0.istVoll() && _zeile1.istVoll() && _zeile2.istVoll();
    }
}