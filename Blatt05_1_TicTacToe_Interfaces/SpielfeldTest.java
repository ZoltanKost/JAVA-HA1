import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Eine Testklasse für Spielfeld-Klassen.
 *
 * @author Christian Späh, Fredrik Winkler, Axel Schmolitzky
 * @version 2025
 */
public class SpielfeldTest
{
    private Spielfeld _spielfeldGeflecht;
    private Spielfeld _spielfeldString;
    private Spielfeld _spielfeldGeflechtEnum;

    /**
     * Jede Testmethode arbeitet auf einem frisch erzeugten Test-Exemplar. 
     * Im Konstruktor kann man also den erforderlichen Ausgangszustand 
     * für die einzelnen Testmethoden herstellen, in diesem Fall ein neues Spielfeld.
     */
    public SpielfeldTest()
    {
        _spielfeldGeflecht = new SpielfeldGeflecht();
        _spielfeldString = new SpielfeldString();
        _spielfeldGeflechtEnum = new SpielfeldGeflechtEnum();
    }

    /**
     * Wenn alle Positionen besetzt sind, solle das Spielfeld voll sein. 
     * Vorher sollte es immer eine freie Position geben.
     */
    @Test
    public void testBefuelleSpielfeldKomplett()
    {
        for (int zeile = 0; zeile < 3; ++zeile)
        {
            for (int spalte = 0; spalte < 3; ++spalte)
            {
                assertFalse(_spielfeldGeflecht.istVoll());
                _spielfeldGeflecht.besetzePosition(zeile, spalte, 1);
            }
        }
        assertTrue(_spielfeldGeflecht.istVoll());
        for (int zeile = 2; zeile >= 0; --zeile)
        {
            for (int spalte = 2; spalte >= 0; --spalte)
            {
                assertEquals(1, _spielfeldGeflecht.gibBesitzer(zeile, spalte));
            }
        }
    }
    
    /**
     * Wenn alle Positionen besetzt sind, solle das Spielfeld voll sein. 
     * Vorher sollte es immer eine freie Position geben.
     */
    @Test
    public void testBefuelleSpielfeldKomplettString()
    {
        for (int zeile = 0; zeile < 3; ++zeile)
        {
            for (int spalte = 0; spalte < 3; ++spalte)
            {
                assertFalse(_spielfeldString.istVoll());
                _spielfeldString.besetzePosition(zeile, spalte, 1);
            }
        }
        assertTrue(_spielfeldString.istVoll());
        for (int zeile = 2; zeile >= 0; --zeile)
        {
            for (int spalte = 2; spalte >= 0; --spalte)
            {
                assertEquals(1, _spielfeldString.gibBesitzer(zeile, spalte));
            }
        }
    }
    
    /**
     * Wenn alle Positionen besetzt sind, solle das Spielfeld voll sein. 
     * Vorher sollte es immer eine freie Position geben.
     */
    @Test
    public void testBefuelleSpielfeldKomplettEnum()
    {
        for (int zeile = 0; zeile < 3; ++zeile)
        {
            for (int spalte = 0; spalte < 3; ++spalte)
            {
                assertFalse(_spielfeldGeflechtEnum.istVoll());
                _spielfeldGeflechtEnum.besetzePosition(zeile, spalte, 1);
            }
        }
        assertTrue(_spielfeldGeflechtEnum.istVoll());
        for (int zeile = 2; zeile >= 0; --zeile)
        {
            for (int spalte = 2; spalte >= 0; --spalte)
            {
                assertEquals(1, _spielfeldGeflechtEnum.gibBesitzer(zeile, spalte));
            }
        }
    }

    /**
     * Wenn alle Positionen besetzt sind, solle das Spielfeld voll sein. 
     * Vorher sollte es immer eine freie Position geben. Dieser Test 
     * befüllt das Spielfeld von hinten nach vorne.
     */
    @Test
    public void testBefuelleSpielfeldKomplettRueckwaerts()
    {
        for (int zeile = 2; zeile >= 0; --zeile)
        {
            for (int spalte = 2; spalte >= 0; --spalte)
            {
                assertFalse(_spielfeldGeflecht.istVoll());
                _spielfeldGeflecht.besetzePosition(zeile, spalte, 1);
            }
        }
        assertTrue(_spielfeldGeflecht.istVoll());
    }
    
    /**
     * Wenn alle Positionen besetzt sind, solle das Spielfeld voll sein. 
     * Vorher sollte es immer eine freie Position geben. Dieser Test 
     * befüllt das Spielfeld von hinten nach vorne.
     */
    @Test
    public void testBefuelleSpielfeldKomplettRueckwaertsString()
    {
        for (int zeile = 2; zeile >= 0; --zeile)
        {
            for (int spalte = 2; spalte >= 0; --spalte)
            {
                assertFalse(_spielfeldString.istVoll());
                _spielfeldString.besetzePosition(zeile, spalte, 1);
            }
        }
        assertTrue(_spielfeldString.istVoll());
    }

    /**
     * Wenn neun Mal dieselbe Position besetzt wird, 
     * sollte das Spielfeld nicht voll sein.
     */
    @Test
    public void testBesetzeNeunMalDieselbePosition()
    {
        for (int i = 0; i < 9; ++i)
        {
            _spielfeldGeflecht.besetzePosition(0, 0, 1);
        }
        assertFalse(_spielfeldGeflecht.istVoll());
    }

    /**
     * Schreibt in diesen Kommentar, was diese Methode testet:
     * 
     * 
     */
    @Test
    public void test3()
    {
        for (int zeile = 0; zeile < 3; ++zeile)
        {
            for (int spalte = 0; spalte < 3; ++spalte)
            {
                assertEquals(0, _spielfeldGeflecht.gibBesitzer(zeile, spalte));

                _spielfeldGeflecht.besetzePosition(zeile, spalte, 1);
                assertEquals(1, _spielfeldGeflecht.gibBesitzer(zeile, spalte));

                _spielfeldGeflecht.besetzePosition(zeile, spalte, 2);
                assertEquals(2, _spielfeldGeflecht.gibBesitzer(zeile, spalte));

                _spielfeldGeflecht.besetzePosition(zeile, spalte, 0);
                assertEquals(0, _spielfeldGeflecht.gibBesitzer(zeile, spalte));
            }
        }
    }
}
