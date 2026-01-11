import java.util.Comparator;
import static java.util.Objects.requireNonNull;

/**
 * Vergleicht zwei Personen anhand eines primären Comparator<Person>s. 
 * Wenn die beiden Personen laut diesem primären Comparator<Person> gleich sind, 
 * dann werden die Personen anhand eines sekundären Comparator<Person>s verglichen.
 * 
 * @author Fredrik Winkler
 * @version 2025
 */
class Zweistufig implements Comparator<Person>
{
    private final Comparator<Person> _primaer;
    private final Comparator<Person> _sekundaer;
    
    /**
     * @param primaer der primäre Comparator<Person>; darf nicht null sein
     * @param sekundaer der sekundäre Comparator<Person>; darf nicht null sein
     */
    public Zweistufig(Comparator<Person> primaer, Comparator<Person> sekundaer)
    {
        _primaer = requireNonNull(primaer);
        _sekundaer = requireNonNull(sekundaer);
    }

    /**
     * @see Comparator<Person>.compare
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
