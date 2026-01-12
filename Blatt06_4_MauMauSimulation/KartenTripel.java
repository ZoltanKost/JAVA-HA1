/**
 * Ein KartenTripel besteht aus drei Spielkarten.
 * Ein Exemplar dieser Klasse liefert eine starke Garantie:
 * die drei sondierenden Methoden liefern garantiert Referenzen
 * auf drei verschiedene Karten, niemals null!
 * 
 * @author Axel Schmolitzky 
 * @version 2025
 */
class KartenTripel implements DreiKarten
{
    private Spielkarte _karte1;
    private Spielkarte _karte2;
    private Spielkarte _karte3;

    /**
     * Initialisiert ein Kartentripel mit drei Karten.
     * Die übergebenen Karten dürfen paarweise nicht gleich sein.
     * @param k1 die erste Spielkarte; darf nicht null sein
     * @param k2 die zweite Spielkarte; darf nicht null sein
     * @param k3 die dritte Spielkarte; darf nicht null sein
     * @throws IllegalArgumentException
     */
    public KartenTripel(Spielkarte k1, Spielkarte k2, Spielkarte k3)
    {
        if (k1 == null || k2 == null || k3 == null
         || k1 == k2   || k2 == k3   || k1 == k3)
        {
            throw new IllegalArgumentException();
        }
        _karte1 = k1;
        _karte2 = k2;
        _karte3 = k3;
    }
    
    /**
     * Lieferte die erste Spielkarte des Tripels.
     * @return eine Referenz auf die erste Spielkarte (ungleich null).
     */
    public Spielkarte karte1()
    {
        return _karte1;
    }

    /**
     * Lieferte die zweite Spielkarte des Tripels.
     * @return eine Referenz auf die zweite Spielkarte (ungleich null).
     */
    public Spielkarte karte2()
    {
        return _karte2;
    }

    /**
     * Lieferte die dritte Spielkarte des Tripels.
     * @return eine Referenz auf die dritte Spielkarte (ungleich null).
     */
    public Spielkarte karte3()
    {
        return _karte3;
    }
    
}
