/**
 * Vergleicht zwei Personen anhand ihres Nachnamens.
 * 
 * @author Fredrik Winkler
 * @version 2025
 */
class PerNachname implements Vergleicher
{
    /**
     * @see Vergleicher.vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        return a.gibNachname().compareTo(b.gibNachname());
    }
}
