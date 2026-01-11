
/**
 * Write a description of class PerGeschlecht here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class PerGeschlecht implements Vergleicher
{
    public int vergleiche(Person a, Person b)
    {
        return a.gibGeschlecht().compareTo(b.gibGeschlecht());
    }
}