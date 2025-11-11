
/**
 * Write a description of class Waage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Waage
{
    // instance variables - replace the example below with your own
    private int _letztesGewicht;
    private int _maxGewicht;
    private int _minGewicht;
    private int _total;
    private int _count;
    private int _trend;
    
    /**
     * Waage. 
     * 
     * @param gewicht Gewicth in kg.
     */
    public Waage(int gewicht)
    {
        // initialise instance variables
        _letztesGewicht = gewicht;
        _minGewicht = gewicht;
        _maxGewicht = gewicht;
        _total = gewicht;
        _count = 1;
    }
    /**
     * Registrieren neues Gewicht
     * @param neuesGewicht Ergebnis der physischen
     * Messung der Waage
     */
    void registriere(int neuesGewicht)
    {
        if(_letztesGewicht < neuesGewicht)
        {
            _trend = 1;
        }else if(_letztesGewicht > neuesGewicht)
        {
            _trend = -1;
        }
        else{
            _trend = 0;
        }
        _letztesGewicht = neuesGewicht;
        _total += _letztesGewicht;
        _count++;
        if(_letztesGewicht > _maxGewicht)
        {
            _maxGewicht = _letztesGewicht;
        }else if(_letztesGewicht < _minGewicht)
        {
            _minGewicht = _letztesGewicht;
        }
    }
    
    int gibMinimalgewicht()
    {
        return _minGewicht;
    }
    
    int gibMaximalgewicht()
    {
        return _maxGewicht;
    }
    
    int gibDurchschnittsgewicht()
    {
        return _total/_count;
    }
}