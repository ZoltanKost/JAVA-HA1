/**
 * Diese Klasse modelliert doppelt verkettbare Knoten, die jeweils ein Element
 * vom Typ Titel enthalten können.
 * 
 * @author Till Aust, Petra Becker-Pechau, Axel Schmolitzky
 * @version 2025
 */
class DoppellinkKnoten
{
    // Der vorherige Knoten
    private DoppellinkKnoten _vorgaenger;

    // Der nachfolgende Knoten
    private DoppellinkKnoten _nachfolger;

    // Das Element des Knotens, ein Titel
    private Titel _element;

    /**
     * Initialisiert einen neuen Knoten ohne Element und Verkettungsinformationen.
     */
    public DoppellinkKnoten()
    {
    }

    /**
     * Initialisiert einen neuen Knoten mit Vorgänger, Nachfolger und Element.
     * 
     * @param element
     *            Das Element, das der Knoten tragen soll
     * @param vorgaenger
     *            Der vorherige Knoten
     * @param nachfolger
     *            Der nächste Knoten
     */
    public DoppellinkKnoten(Titel element, DoppellinkKnoten vorgaenger,
            DoppellinkKnoten nachfolger)
    {
        _element = element;
        _vorgaenger = vorgaenger;
        _nachfolger = nachfolger;
    }

    /**
     * Liefert den nachfolgenden Knoten.
     * 
     * @return den Nachfolgerknoten
     */
    public DoppellinkKnoten gibNachfolger()
    {
        return _nachfolger;
    }

    /**
     * Setzt den nachfolgenden Knoten.
     * 
     * @param nachfolger der Nachfolgerknoten.
     */
    public void setzeNachfolger(DoppellinkKnoten nachfolger)
    {
        _nachfolger = nachfolger;
    }

    /**
     * Liefert den vorherigen Knoten.
     * 
     * @return den Vorgänger dieses Knotens
     */
    public DoppellinkKnoten gibVorgaenger()
    {
        return _vorgaenger;
    }

    /**
     * Setzt den Vorgänger dieses Knotens.
     * 
     * @param vorgaenger der Vorgängerknoten.
     */
    public void setzeVorgaenger(DoppellinkKnoten vorgaenger)
    {
        _vorgaenger = vorgaenger;
    }

    /**
     * Liefert das (Daten-)Element dieses Knotens.
     * 
     * @return den gespeicherten Titel dieses Knotens.
     */
    public Titel gibTitel()
    {
        return _element;
    }

    /**
     * Setzt das (Daten-)Element dieses Knotens.
     * 
     * @param element Ein Titel.
     */
    public void setzeTitel(Titel element)
    {
        _element = element;
    }
    
    /**
     * Diese Methode fängt einen typischen Fehler ab, der auftritt,
     * wenn in der Klasse LinkedTitelListe versehentlich ein Kettenglied
     * mit einem Element verglichen wird.
     */
    public boolean equals(Titel titel)
    {
        throw new IllegalArgumentException("Fehler: DoppellinkKnoten mit Titeln zu vergleichen ist nicht sinnvoll!");
    }
}
