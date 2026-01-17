/**
 * Diese Klasse implementiert das Interface TitelListe mit einer doppelt
 * verketteten Liste.
 * 
 * @author Till Aust
 * @author Axel Schmolitzky
 * @author Petra Becker-Pechau
 * @author Alexander Pokahr
 * @author Christian Späh
 * @author Fredrik Winkler
 * @version WiSe 2025
 */
class LinkedTitelListe implements TitelListe
{
    // Der Kopf der verketteten Liste
    private DoppellinkKnoten _listenkopf;

    // Das Ende der verketteten Liste
    private DoppellinkKnoten _listenende;

    // Die logische Laenge der Liste (Kardinalitaet).
    private int _anzahlTitel;

    /**
     * Initialisiert eine neue LinkedTitelListe.
     */
    public LinkedTitelListe()
    {
        // Diese Implementierung verwendet zwei Wächter-Knoten,
        // einen für den Listenanfang, einen für das Ende.
        // Sie markieren technisch die Grenzen der Liste und enthalten keine Titel.
        // Sie erleichtern das Einfügen und Entfernen von Titeln,
        // weil viele Sonderfälle entfallen.
        _listenkopf = new DoppellinkKnoten();
        _listenende = new DoppellinkKnoten();
        _listenkopf.setzeNachfolger(_listenende);
        _listenende.setzeVorgaenger(_listenkopf);
        _anzahlTitel = 0;
    }

    /**
     * Fügt einen Titel an der Position <code>position</code> in die Titelliste
     * ein. Alle folgenden Einträge werden um eine Indexposition verschoben.
     * Wenn <code>position</code> gleich der Länge der Titelliste ist, dann
     * wird der <code>titel</code> am Ende angefügt.
     * 
     * @param titel der einzufügende Titel, darf nicht null sein.
     * @param position die Position des Titels, gültig sind Werte von 0 bis gibLaenge().
     */
    public void fuegeEin(Titel titel, int position)
    {
        darfNichtNullSein(titel);
        mussGueltigeEinfuegepositionSein(position);
        
        DoppellinkKnoten current = _listenkopf.gibNachfolger();
        DoppellinkKnoten prev = _listenkopf; 
        int counter = 0;
        while(counter != position)
        {
            prev = current;
            current = current.gibNachfolger();
            counter ++;
        }
        
        DoppellinkKnoten newKnoten = 
            new DoppellinkKnoten(titel, prev,current);
        prev.setzeNachfolger(newKnoten);
        current.setzeVorgaenger(newKnoten);
        
        _anzahlTitel++;

    }

    /**
     * Prüft, ob ein Titel in der Liste enthalten ist.
     * 
     * @param titel der zu suchende Titel, darf nicht null sein.
     * @return Liefert <code>true</code> wenn der Titel in der Liste ist,
     *         ansonsten <code>false</code>.
     */
    public boolean enthaelt(Titel titel)
    {
        darfNichtNullSein(titel);
        
        int counter = 0;
        DoppellinkKnoten current = _listenkopf.gibNachfolger();
        while(current != null)
        {
            if(current.gibTitel() != null && current.gibTitel().equals(titel))
            {
                return true;
            }
            current = current.gibNachfolger();
        }

        return false;
    }

    /**
     * Liefert den Titel an der angegebenen Position.
     * 
     * @param position Die Position des Titels, der zurückgegeben werden soll,
     *              gültig sind Werte von 0 bis gibLaenge()-1.
     * @return den Titel an der Position <code>position</code>.
     */
    public Titel gibTitel(int position)
    {
        mussGueltigePositionSein(position);

        DoppellinkKnoten knoten = _listenkopf;
        for (int i = 0; i <= position; ++i)
        {
            knoten = knoten.gibNachfolger();
        }

        return knoten.gibTitel();
    }

    /**
     * Entfernt den Titel an der angegebenen Position. Alle folgenden Einträge
     * werden um eine Indexposition verschoben.<br>
     * 
     * @param position Eine Position in der Liste, gültig sind Werte von 0 bis gibLaenge()-1.
     */
    public void entferne(int position)
    {
        mussGueltigePositionSein(position);
        
        DoppellinkKnoten current = _listenkopf.gibNachfolger();
        DoppellinkKnoten prev = _listenkopf;
        int counter = 0;
        while(counter != position)
        {
            counter++;
            prev = current;
            current = current.gibNachfolger();            
        } 
        
        current = current.gibNachfolger();
        prev.setzeNachfolger(current);
        current.setzeVorgaenger(prev);
        _anzahlTitel--;
    }

    /**
     * Liefert die Länge der Liste.
     * 
     * @return Anzahl der Titel in der Liste.
     */
    public int gibLaenge()
    {
        return _anzahlTitel;
    }

    /**
     * Entfernt alle Titel aus der Liste.
     */
    public void leere()
    {
        _listenkopf.setzeNachfolger(_listenende);
        _listenende.setzeVorgaenger(_listenkopf);
        _anzahlTitel = 0;
    }

    /**
     * Liefert true für alle gültigen Positionen innerhalb der Liste.
     */
    public boolean istGueltigePosition(int position)
    {
        return (position >= 0) && (position < gibLaenge());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungültige
     * Position handelt.
     */
    private void mussGueltigePositionSein(int position)
    {
        if (!istGueltigePosition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gültige Position");
        }
    }
    
    /**
     * Liefert true für alle gültigen Einfügepositionen innerhalb der Liste.
     */
    public boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= gibLaenge());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungültige
     * Einfügeposition handelt.
     */
    private void mussGueltigeEinfuegepositionSein(int position)
    {
        if (!istGueltigeEinfuegeposition(position))
        {
            throw new IndexOutOfBoundsException(
                  position + " ist keine gültige Einfuegeposition");
        }
    }
    
    /**
     * Wirft eine IllegalArgumentException, falls die übergebene Titel-Referenz null ist.
     */
    private static void darfNichtNullSein(Titel titel)
    {
        if (titel == null)
        {
            throw new IllegalArgumentException("Die Titel-Referenz darf nicht null sein.");
        }
    }
}
