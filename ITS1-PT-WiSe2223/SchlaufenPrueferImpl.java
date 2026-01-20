import java.util.*;
/**
 * Write a description of class SchlaufenPrueferImpl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class SchlaufenPrueferImpl implements SchlaufenPruefer
{
    public SchlaufenPrueferImpl()
    {
    
    }
    /**
     * Stellt fest, ob die übergebene verkettete Struktur eine Schlaufe enthält.
     * @param kopf der Kopf der verketteten Struktur, kann null sein
     * @return true, wenn die Struktur eine Schlaufe enthält, false sonst
     */
    public boolean enthaeltSchlaufe(AufgabenKnoten kopf)
    {
        // laengederschlaufe !=0;
        if(kopf == null) return false;
        HashSet<AufgabenKnoten> contains = new HashSet<AufgabenKnoten>();
        AufgabenKnoten current = kopf.gibNachfolger();
        while(current != null)
        {
            if(contains.contains(current)) return true;
            contains.add(current);
            current = current.gibNachfolger();
        }
        return false;
    }
    
    /**
     * Liefert die Länge der Schlaufe in der übergebenen verketteten Struktur,
     * falls diese eine Schlaufe enthält, 0 sonst.
     * @param kopf der Kopf der verketteten Struktur, kann null sein
     * @return Anzahl der Knoten in der Schlaufe, falls vorhanden, 0 sonst
     */
    public int laengeDerSchlaufe(AufgabenKnoten kopf)
    {
        if(kopf == null) return 0;
        HashSet<AufgabenKnoten> contains = new HashSet<AufgabenKnoten>(); // hashmap<kn,index>
        AufgabenKnoten current = kopf.gibNachfolger();
        while(current != null) // kn.gibNach();
        {
            if(contains.contains(current)) return countSchlaufe(current);
            contains.add(current);
            current = current.gibNachfolger();
        }
        return 0;
    }
    
    private int countSchlaufe(AufgabenKnoten kopf)
    {
        if(kopf == null) return 0;
        AufgabenKnoten current = kopf.gibNachfolger();
        int counter = 1;
        while(true)
        {
            if(current == kopf) return counter;
            counter++;
            current = current.gibNachfolger();
        }
    }
    
    
    
    /**
     * Liefert die Länge des Vorlaufs bis zur Schlaufe in der übergebenen
     * verketteten Struktur, falls diese eine Schlaufe enthält, sonst die
     * Länge der Liste.
     * @param kopf der Kopf der verketteten Struktur, kann null sein
     * @return Anzahl der Knoten vom Kopf bis zur Schlaufe, falls vorhanden,
     *         sonst die Anzahl der Knoten
     */
    public int laengeDesVorlaufs(AufgabenKnoten kopf)
    {
        if(kopf == null) return 0;
        HashSet<AufgabenKnoten> checked = new HashSet<AufgabenKnoten>();
        checked.add(kopf);
        int counter = 1;
        AufgabenKnoten current = kopf.gibNachfolger();
        System.out.println("kopf " + kopf + " nachfolger: " + counter + " " + current);
        while(current != null)
        {
            System.out.println("nachfolger: " + counter + " " + current);
            if(checked.contains(current)) return counter - laengeDerSchlaufe(kopf);
            counter++;
            checked.add(current);
            current = current.gibNachfolger();
        }
        System.out.println("Liste durchgegangen");
        return counter;
    }
}