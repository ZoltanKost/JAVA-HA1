import java.util.Comparator;
/**
 * Vergleicht zwei Personen anhand ihres Nachnamens.
 * 
 * @author Fredrik Winkler
 * @version 2025
 */
class PerNachname implements Comparator<Person>
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int compare(Person a, Person b)
    {
        return a.gibNachname().compareTo(b.gibNachname());
    }
}
