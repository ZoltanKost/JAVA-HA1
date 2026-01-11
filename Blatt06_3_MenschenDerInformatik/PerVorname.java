
/**
 * Write a description of class PerVorname here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class PerVorname implements Vergleicher
{
    public int vergleiche(Person a, Person b)
    {
        return a.gibVorname().compareTo(b.gibVorname());
    }
}