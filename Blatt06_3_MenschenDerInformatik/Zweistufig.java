import static java.util.Objects.requireNonNull;
import java.util.Comparator;

/**
 * Vergleicht zwei Personen anhand eines primären Vergleichers. 
 * Wenn die beiden Personen laut diesem primären Vergleicher gleich sind, 
 * dann werden die Personen anhand eines sekundären Vergleichers verglichen.
 * 
 * @author Fredrik Winkler
 * @version 2025
 */
class Zweistufig implements Comparator<Person>
{
    private final Comparator<Person> _primaer;
    private final Comparator<Person> _sekundaer;
    
    /**
     * @param primaer der primäre Vergleicher; darf nicht null sein
     * @param sekundaer der sekundäre Vergleicher; darf nicht null sein
     */
    public Zweistufig(Comparator<Person> primaer, Comparator<Person> sekundaer)
    {
        _primaer = requireNonNull(primaer);
        _sekundaer = requireNonNull(sekundaer);
    }

    /**
     * @see Vergleicher.vergleiche
     */
    public int compare(Person a, Person b)
    {
        int ergebnis = _primaer.compare(a, b);
        if (ergebnis == 0)
        {
            ergebnis = _sekundaer.compare(a, b);
        }
        return ergebnis;
    }
}
