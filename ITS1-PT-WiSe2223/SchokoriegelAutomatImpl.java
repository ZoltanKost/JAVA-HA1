import java.util.*;
/**
 * Write a description of class SchokoriegelAutomatImpl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class SchokoriegelAutomatImpl implements SchokoriegelAutomat
{
    private HashMap<Schokoriegel, Integer> _map;
    private int _money;
    private int _profit;
    public SchokoriegelAutomatImpl()
    {   
        _map = new HashMap<Schokoriegel, Integer>();
    }
    /**
     * Riegel einer Sorte bei diesem Automaten nachfüllen.
     * @param anzahl die Anzahl der nachzufüllenden Riegel, muss > 0 sein
     * @param sorte die Sorte des Schokoriegels, darf nicht null sein
     * @throws IllegalArgumentException
     */
    public void riegelNachfuellen(int anzahl, Schokoriegel sorte)
    {
        if(anzahl < 1) throw new IllegalArgumentException();
        if(sorte == null) throw new IllegalArgumentException();
        if(_map.containsKey(sorte))
        {
            _map.put(sorte, _map.get(sorte) + anzahl);
        }else
        {
            _map.put(sorte, anzahl);
        }
    }

    /**
     * Eine Handvoll (gemischte) Schokoriegel nachfüllen.
     * Jeder Eintrag in der Liste steht für einen Riegel der jeweiligen
     * Sorte.
     * @param handvoll eine Liste von Schokoriegeln, darf nicht null sein und null
     *                 nicht enthalten
     * @throws IllegalArgumentException
     */
    public void riegelNachfuellen(List<Schokoriegel> handvoll)
    {
        if(handvoll == null) throw new IllegalArgumentException();

        for(Schokoriegel r : handvoll)
        {
            riegelNachfuellen(1,r);
        }
    }

    /**
     * Die angegebene Anzahl an Riegeln eines Typs kaufen; vorher muss genügend 
     * Geld eingeworfen worden sein, sonst gibt es eine Exception zum Zustand.
     * Ein Aufruf mit mehr Riegeln als vom Typ im Automaten vorhanden
     * entfernt alle Riegel dieses Typs. Die Kosten der gelieferten
     * Riegel werden als Einnahme verbucht, der Rest wird "zurückgegeben"
     * (eingeworfenesGeld() liefert anschließend Null).
     * @param anzahl die Anzahl der zu kaufenden Riegel, muss > 0 sein
     * @param sorte die zu kaufende Riegelsorte, darf nicht null sein
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     */
    public void riegelKaufen(int anzahl, Schokoriegel sorte)
    {
        if(sorte == null) throw new IllegalArgumentException();
        if(anzahl < 1) throw new IllegalArgumentException();
        if(_money < anzahl * RIEGELPREIS) throw new IllegalStateException();
        if(!_map.containsKey(sorte))
        {
            _money = 0;
            return;
        }
        if(_map.get(sorte) < anzahl) 
        {
            anzahl = _map.get(sorte);// Math.min(.get(s,a))
        }
        _money -= anzahl * RIEGELPREIS;
        _map.put(sorte,_map.get(sorte) - anzahl);
        _profit += anzahl * RIEGELPREIS;
        _money = 0;
    }

    /**
     * Alle Riegel aus diesem Automaten kaufen;
     * üblicherweise ein Akt höchster Verzweiflung...
     * Vorher muss genügend Geld eingeworfen worden sein, 
     * sonst gibt es eine Exception zum Zustand.
     * Die Kosten der gelieferten Riegel werden als Einnahme verbucht, 
     * der Rest wird "zurückgegeben" (eingeworfenesGeld() liefert 
     * anschließend Null).
     * @throws IllegalStateException
     */
    public void leerkaufen()
    {
        int price = anzahlRiegel() * RIEGELPREIS;
        if(_money < price) throw new IllegalStateException();
        _profit += price;
        _map.clear();
        _money = 0;
    }
    
    /**
     * Geld in den Automaten einwerfen, um Schokoriegel kaufen zu können.
     * @param geldbetrag ein Geldbetrag in Eurocent, darf nicht negativ sein.
     * @throws IllegalArgumentException
     */
    public void geldEinwerfen(int geldbetrag)
    {
        if(geldbetrag < 0) throw new IllegalArgumentException();
        _money += geldbetrag;
    }
    
    /**
     * Den aktuellen Kauf abbrechen. Lässt den Automaten das eingeworfene
     * Geld zurückgeben.
     */
    public void kaufAbbrechen()
    {
        _money = 0;
    }
    
    /**
     * Liefert die Info, wie viel Geld für einen aktuellen Kauf eingeworfen wurde.
     * @return die Summe des eingeworfenen Geldes in Eurocent, größer gleich Null.
     */
    public int eingeworfenesGeld()
    {
        return _money;
    }

    /**
     * Liefert die Info, wie viel Geld bisher mit abgeschlossenen Verkäufen
     * eingenommen wurde.
     * @return die Summe des eingenommenen Geldes in Eurocent.
     */
    public int eingenommenesGeld()
    {
        return _profit;
    }

    /**
     * Die Anzahl der Schokoriegel in diesem Automaten.
     */
    public int anzahlRiegel()
    {
        int result = 0;
        for(Map.Entry<Schokoriegel, Integer> n : _map.entrySet())
        {
            result += n.getValue();
        }
        return result;
    }

    /**
     * Die Anzahl der Riegel der genannten Sorte in diesem Automaten.
     * @param sorte Riegel-Sorte, deren Anzahl geliefert werden soll, darf nicht null sein
     * @throws IllegalArgumentException
     */
    public int anzahlRiegel(Schokoriegel sorte)
    {
        if(sorte == null) throw new IllegalArgumentException();
        return _map.getOrDefault(sorte,0);
        // if(!_map.containsKey(sorte)) return 0;
        // return _map.get(sorte);
    }

}