
/**
 * Write a description of class SpielfeldString here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class SpielfeldString implements Spielfeld
{
    private String feldValues;

    /**
     * Initialisiert ein neues, leeres Spielfeld.
     */
    public SpielfeldString()
    {
        feldValues = "000000000";
    }

    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        int besitzer;
        if(zeile < 0 || zeile >= 3 || spalte < 0 || spalte >= 3) 
            throw new IllegalArgumentException(String.valueOf(zeile * 3 + spalte));
        switch (feldValues.charAt(zeile * 3 + spalte))
        {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        default:
            throw new IllegalArgumentException(feldValues.charAt(zeile * 3 + spalte) + " ");
        }
    }

    /**
     * Besetzt die angegebene Position auf dem Spielfeld für einen Spieler.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int zeile, int spalte, int spieler)
    {
        int index = zeile * 3 + spalte;
       if(index >= 9) 
            throw new IllegalArgumentException(String.valueOf(zeile * 3 + spalte));
       feldValues = feldValues.substring(0,index) + String.valueOf(spieler) 
           + feldValues.substring(index,9);
    }

    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        for(int i = 0; i < 9; i++)
        {
            if(feldValues.charAt(i) == '0') return false;
        }
        return true;
    }   
}