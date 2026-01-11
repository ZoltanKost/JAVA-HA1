import java.util.Comparator;
/**
 * Write a description of class PerGeschlecht here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class PerGeschlecht implements Comparator<Person>
{
    public int compare(Person a, Person b)
    {
        return a.gibGeschlecht().compareTo(b.gibGeschlecht());
    }
}