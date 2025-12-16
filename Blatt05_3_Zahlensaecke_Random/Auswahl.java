import java.util.Random;

/**
 * Diese Klasse implementiert den Zahlensack mittels eines Arrays.
 * Die Zahlen werden erst bei Bedarf zufällig herausgepickt.
 * 
 * @author Fredrik Winkler, Christian Späh
 * @version 2025
 */
class Auswahl implements Zahlensack
{
    private final String _string;
    private final Random _zufall;
    private final int[] _sack;
    private int _anzahl;
    
    /**
     * @param groesse die Groesse des Zahlensacks, muss >= 2 sein.
     * @throws IllegalArgumentException
     */
    public Auswahl(int groesse)
    {
        if (groesse < 2)
        {
            throw new IllegalArgumentException();
        }
        _string = "Auswahl (" + groesse + ")";
        _zufall = new Random();
        _sack = new int[groesse];
        _anzahl = 0;
    }
    
    /**
     * @return die Groesse des Zahlensacks
     */
    public int gibGroesse()
    {
        return _sack.length;
    }

    /**
     * @return die Anzahl der Zahlen, die sich momentan im Zahlensack befinden
     */
    public int gibAnzahl()
    {
        return _anzahl;
    }
    
    /**
     * @return true, falls der Zahlensack leer ist
     */
    public boolean istLeer()
    {
        return _anzahl == 0;
    }
    
    /**
     * Fuellt den Zahlensack mit gibGroesse() verschiedenen Zufallszahlen
     * im halboffenen Intervall [0, gibGroesse)
     */
    private void fuelleSack()
    {
        _anzahl = _sack.length;
        for (int i=0; i<_anzahl; ++i)
        {
            _sack[i] = i;
        }
    }
    
    /**
     * Entfernt eine Zahl aus dem Zahlensack und liefert sie zurück.
     * Danach ist der Zahlensack um ein Element kleiner.
     * Ausnahme: Falls der Zahlensack vor dem Aufruf leer ist,
     * wird er zuerst gefüllt, und nach dem Aufruf ist gibAnzahl() == gibGroesse()-1.
     * 
     * @return eine zufällige Zahl im halboffenen Intervall [0, gibGroesse)
     */
    public int entferneZahl()
    {
        if (istLeer())
        {
            fuelleSack();
        }
        final int i = _zufall.nextInt(_anzahl);
        final int zahl = _sack[i];
        _sack[i] = _sack[--_anzahl];
        return zahl;
    }
    
    /**
     * Verwirft alle übrig gebliebenen Zahlen aus dem Zahlensack.
     * istLeer() liefert anschließend true zurück, und gibAnzahl() liefert 0.
     */
    public void leereSack()
    {
        _anzahl = 0;
    }
    
    /**
     * @return der verwendete Algorithmus sowie die Größe des Zahlensacks
     */
    public String toString()
    {
        return _string;
    }
}
