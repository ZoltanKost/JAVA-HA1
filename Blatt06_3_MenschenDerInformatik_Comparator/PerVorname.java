import java.util.Comparator;
/**
 * Write a description of class PerVorname here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class PerVorname implements Comparator<Person>
{
    public int compare(Person a, Person b)
    {
        return a.gibVorname().compareTo(b.gibVorname());
    }
}