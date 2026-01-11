
/**
 * Write a description of class Umgekehrt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Umgekehrt implements Vergleicher
{
    private Vergleicher _vergleicher;
    
    public Umgekehrt(Vergleicher vergleicher)
    {
        _vergleicher = vergleicher;    
    }
    /**
     * Vergleicht zwei Personen miteinander und gibt Auskunft darüber, in welcher
     * Beziehung sie zueinander stehen.
     * Wenn die beiden Personen (gemessem am Vergleichskriterium) gleich sind, dann
     * wird 0 geliefert.
     * Wenn a in einer geordneten Liste vor b stehen würde, dann wird irgendeine
     * negative Zahl geliefert.
     * Ansonsten wird irgendeine positive Zahl geliefert.
     */
    public int vergleiche(Person a, Person b)
    {
        return -_vergleicher.vergleiche(a,b);
    }
    
    
}