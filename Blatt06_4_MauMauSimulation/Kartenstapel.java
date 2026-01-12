import java.util.Stack;
import java.util.Collections;



/**
 * Ein Kartenstapel hält bis zu 32 Spielkarten eines Kartensatz32 
 * auf einem Stapel.
 * 
 * @author Axel Schmolitzky 
 * @version 2025
 */
class Kartenstapel
{
    private Stack<Spielkarte> _stapel;
    
    /**
     * Initialisiert einen neuen Stapel mit allen Spielkarten des übergebenen Kartensatzes in 
     * einer zufälligen Reihenfolge.
     * @param kartensatz der Kartensatz, dessen Spielkarten gemischt auf den Stapel kommen 
     */
    public Kartenstapel(Kartensatz32 kartensatz)
    {
        _stapel = new Stack<Spielkarte>();
        for (Spielkarte k : kartensatz)
        {
            _stapel.push(k);
        }
        Collections.shuffle(_stapel);
    }
    
    /**
     * Ein neuer Stapel hält alle Spielkarten eines neu erzeugten Kartensatz32 in 
     * einer zufälligen Reihenfolge.
     */
    public Kartenstapel()
    {
        Kartensatz32 satz = new Kartensatz32();
        _stapel = new Stack<Spielkarte>();
        for (Spielkarte k : satz)
        {
            _stapel.push(k);
        }
        Collections.shuffle(_stapel);
    }
    
    /**
     * Zieht die oberste Spielkarte von diesem Stapel, falls dieser nicht leer ist.
     * Anschließend enthält dieser Stapel eine Karte weniger.
     * @return die oberste Spielkarte
     * @throws IllegalStateException
     */
    public Spielkarte obersteKarteZiehen()
    {
        if (anzahlKarten() == 0)
        {
            throw new IllegalStateException();
        }
        return _stapel.pop();
    }

    /**
     * Zeige die oberste Spielkarte von diesem Stapel, falls dieser nicht leer ist.
     * Der Stapel wird nicht verändert.
     * @return die oberste Spielkarte
     * @throws IllegalStateException
     */
    public Spielkarte zeigeObersteKarte()
    {
        if (anzahlKarten() == 0)
        {
            throw new IllegalStateException();
        }
        return _stapel.peek();
    }

    /**
     * Liefert die Anzahl der noch auf diesem Stapel verfügbaren Spielkarten.
     */
    public int anzahlKarten()
    {
        return _stapel.size();
    }
}
