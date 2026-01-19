import static java.util.Objects.*;

/**
 * Ein Knoten fuer eine einfach verkettete Struktur. Der Inhalt
 * eines Knotens ist eine Aufgabe, jeder Knoten kann auf einen
 * weiteren Knoten verweisen.
 * 
 * @author Axel Schmolitzky 
 * @version WiSe 2022/23
 */
class AufgabenKnoten 
{
    private Aufgabe _inhalt;
    private AufgabenKnoten _nachfolger;
    
    /**
     * Initialisiert einen neuen Knoten mit seinem Inhalt,
     * der Nachfolger ist null.
     * @param inhalt der Inhalt des neuen Knotens, darf nicht null sein
     * @throws NullPointerException
     */
    public AufgabenKnoten(Aufgabe inhalt)
    {
        _inhalt = requireNonNull(inhalt);
        _nachfolger = null;
    }
        
    /**
     * Liefert den Inhalt dieses Knotens.
     * @return den Inhalt, garantiert ungleich null
     */
    public Aufgabe gibInhalt()
    {
        return _inhalt;
    }
    
    /**
     * Setzt den übergebenen StringKnoten als Nachfolger
     * dieses Knotens.
     * @param ein beliebiger StringKnoten, kann null sein
     */
    public void setzeNachfolger(AufgabenKnoten knoten)
    {
        _nachfolger = knoten;
    }

    /**
     * Liefert den Nachfolger dieses Knotens.
     * @return den Nachfolger, kann null sein
     */
    public AufgabenKnoten gibNachfolger()
    {
        return _nachfolger;
    }
}