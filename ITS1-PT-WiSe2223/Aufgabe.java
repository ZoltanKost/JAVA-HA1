
/**
 * Eine Klasse für einfache priorisierte Aufgaben.
 * Eine Aufgabe besteht aus einer Beschreibung und einer
 * Priorität. Die niedrigste Priorität ist 0, 1 bedeutet
 * mittlere Priorität und 2 ist die höchste Priorität.
 * 
 * @author Axel Schmolitzky 
 * @version WiSe 2022/23
 */
class Aufgabe implements Comparable<Aufgabe>  // Rauswerfen für Prüfung
{
    private String _beschreibung;
    private int _prio;
    
    /**
     * Initialisiert eine neue Aufgabe.
     * @param beschreibung die Beschreibung der Aufgabe, darf nicht null sein.
     * @param prioritaet die Priorität der Aufgabe; muss 0,1 oder 2 sein.
     * @throws IllegalArgumentException
     */
    public Aufgabe(String beschreibung, int prioritaet)
    {
        if (beschreibung == null || prioritaet < 0 || prioritaet > 2)
        {
            throw new IllegalArgumentException();
        }
        _beschreibung = beschreibung;
        _prio = prioritaet;
    }
    
    public int compareTo(Aufgabe other)  // Rauswerfen für Prüfung
    {
        return other._prio - this._prio;
    }
    
    /**
     * Liefert die Beschreibung dieser Aufgabe
     */
    public String gibBeschreibung()
    {
        return _beschreibung;
    }
    
    public int gibPrioritaet()
    {
        return _prio;
    }
    
    public String toString()
    {
        return _beschreibung + ", Prio " + _prio;
    }
}
