/**
 * Diese Klasse implementiert das Interface TitelListe mit "wachsenden" Arrays.
 * 
 * @author Till Aust
 * @author Axel Schmolitzky
 * @author Petra Becker-Pechau
 * @author Alexander Pokahr
 * @author Christian Späh
 * @author Fredrik Winkler
 * @version 2025
 */
class ArrayTitelListe implements TitelListe
{
    // In diesem Array sind die Referenzen auf die enthaltenen Titel abgelegt.
    // Die Länge des Arrays entspricht der Kapazität der Liste und muss daher
    // nicht separat gespeichert werden.
    private Titel[] _titelArray;
    
    // Die Kapazitaet der Liste.
    private int _capacity;
    
    // Die Kardinalitaet der Liste.
    private int _anzahlTitel;

    // Die Anfangskapazität einer neuen Liste.
    private static final int ANFANGSKAPAZITAET = 10;

    /**
     * Initialisiert eine neue <code>ArrayTitelListe</code>.
     */
    public ArrayTitelListe()
    {
        _titelArray = new Titel[ANFANGSKAPAZITAET];
        _anzahlTitel = 0;
        _capacity = ANFANGSKAPAZITAET;
    }

    /**
     * Initialisiert eine neue <code>ArrayTitelListe</code>.
     */
    public ArrayTitelListe(int kapazitaet)
    {
        _titelArray = new Titel[kapazitaet];
        _anzahlTitel = 0;
        _capacity = kapazitaet;
    }
    
    /**
     * Fügt einen Titel an der Position <code>position</code> in die Titelliste
     * ein. Alle folgenden Einträge werden um eine Indexposition verschoben.
     * Wenn <code>position</code> gleich der Länge der Titelliste ist, dann
     * wird der <code>titel</code> am Ende angefügt.
     * 
     * @param titel der einzufügende Titel, darf nicht null sein.
     * @param position die Position des Titels, gültig sind Werte von 0 bis gibLaenge().
     */
    public void fuegeEin(Titel titel, int position)
    {
        darfNichtNullSein(titel);
        mussGueltigeEinfuegepositionSein(position);
        
        if(_anzahlTitel + 1 >= _capacity)
        {
            _resize();
        }
        
        for(int i = _anzahlTitel; i > position ;i--)
        {
            _titelArray[i] = _titelArray[i - 1];
        }
        
        _titelArray[position] = titel;
        _anzahlTitel ++;
    }
    
    private void _resize()
    {
        Titel[] array = new Titel[_capacity*2];
        _capacity*=2;
        for(int i = 0; i < _anzahlTitel; i++)
        {
            array[i] = _titelArray[i];
        }
        _titelArray = array;
    }

    /**
     * Prüft, ob ein Titel in der Liste enthalten ist.
     * 
     * @param titel der zu suchende Titel, darf nicht null sein.
     * @return Liefert <code>true</code> wenn der Titel in der Liste ist,
     *         ansonsten <code>false</code>.
     */
    public boolean enthaelt(Titel titel)
    {
        darfNichtNullSein(titel);

        for(int i = 0; i < _anzahlTitel; i++)
        {   
            if(titel.equals(_titelArray[i])) return true;
        }
        return false;
    }

    /**
     * Liefert den Titel an der angegebenen Position.
     * 
     * @param position Die Position des Titels, der zurückgegeben werden soll,
     *              gültig sind Werte von 0 bis gibLaenge()-1.
     * @return den Titel an der Position <code>position</code>.
     */
    public Titel gibTitel(int position)
    {
        mussGueltigePositionSein(position);
        return _titelArray[position];
    }

    /**
     * Entfernt den Titel an der angegebenen Position. Alle folgenden Einträge
     * werden um eine Indexposition verschoben.<br>
     * 
     * @param position Eine Position in der Liste, gültig sind Werte von 0 bis gibLaenge()-1.
     */
    public void entferne(int position)
    {
        mussGueltigePositionSein(position);
        _anzahlTitel--;
        for(int i = position; i < _anzahlTitel; i++)
        {
            _titelArray[i] = _titelArray[i+1];    
        }
    }

    /**
     * Liefert die Länge der Liste.
     * 
     * @return Anzahl der Titel in der Liste.
     */
    public int gibLaenge()
    {
        return _anzahlTitel;
    }

    /**
     * Entferne alle Titel aus der Liste.
     */
    public void leere()
    {
        _anzahlTitel = 0;
    }

    /**
     * Schreibt den Array-Inhalt auf die Konsole (als Debugging-Hilfe gedacht).
     */
    public void schreibeAufKonsole()
    {
        System.out.println(java.util.Arrays.toString(_titelArray));
    }

    /**
     * Liefert true für alle gültigen Positionen innerhalb der Liste.
     */
    public boolean istGueltigePosition(int position)
    {
        return (position >= 0) && (position < gibLaenge());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungültige
     * Position handelt.
     */
    private void mussGueltigePositionSein(int position)
    {
        if (!istGueltigePosition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gueltige Position");
        }
    }
    
    /**
     * Liefert true für alle gültigen Einfügepositionen innerhalb der Liste.
     */
    public boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= gibLaenge());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungültige
     * Einfügeposition handelt.
     */
    private void mussGueltigeEinfuegepositionSein(int position)
    {
        if (!istGueltigeEinfuegeposition(position))
        {
            throw new IndexOutOfBoundsException(
                position + " ist keine gueltige Einfuegeposition");
        }
    }
    
    /**
     * Wirft eine IllegalArgumentException, falls die übergebene Titel-Referenz
     * null ist.
     */
    private static void darfNichtNullSein(Titel titel)
    {
        if (titel == null)
        {
            throw new IllegalArgumentException("Die Titel-Referenz darf nicht null sein.");
        }
    }
}
