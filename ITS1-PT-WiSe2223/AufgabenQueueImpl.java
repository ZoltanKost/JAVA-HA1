
/**
 * Diese Implementation fügt am Ende einer verketteten Liste an und entnimmt am Kopf.
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2022/23
 */
class AufgabenQueueImpl implements AufgabenQueue
{
    private AufgabenKnoten _ersterKnoten; // der Kopf-Knoten

    public AufgabenQueueImpl()
    {
        _ersterKnoten = new AufgabenKnoten(null);  // Waechterknoten
    }

    public void enqueue(Aufgabe a) 
    {
        if (a == null)
        {
            throw new IllegalArgumentException("der aktuelle Parameter von enqueue darf nicht Null sein");
        }

        AufgabenKnoten neuerKnoten = new AufgabenKnoten(a);  // null als Nachfolger

        AufgabenKnoten letzterKnoten = gibLetztenKnoten();  // niemals null
        letzterKnoten.setzeNachfolger(neuerKnoten);
    }

    public Aufgabe dequeue ()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("dequeue darf nicht bei leerer Queue aufgerufen werden");
        }
        Aufgabe ergebnis = _ersterKnoten.gibNachfolger().gibInhalt();
        _ersterKnoten = _ersterKnoten.gibNachfolger();
        return ergebnis;
    }

    public boolean isEmpty()
    {
        return _ersterKnoten.gibNachfolger() == null;
    }

    /*
     * Liefert den Waechterknoten, wenn die Queue leer ist.
     */
    private AufgabenKnoten gibLetztenKnoten()
    {
        // Queue von vorne nach hinten durchlaufen
        AufgabenKnoten aktuellerKnoten = _ersterKnoten;
        while (aktuellerKnoten.gibNachfolger() != null)
        {
            aktuellerKnoten = aktuellerKnoten.gibNachfolger();
        }
        return aktuellerKnoten;
    }
}
