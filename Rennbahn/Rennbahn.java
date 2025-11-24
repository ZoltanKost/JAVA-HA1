
/**
 * Write a description of class Rennbahn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Rennbahn
{
    private float _length;
    private int _streckenCount;
    private Rennauto _auto1;
    private Rennauto _auto2;
    private Rennauto _auto3;
    private Rennauto _auto4;
    
    public Rennbahn(float laenge)
    {
        _length = laenge;
        _streckenCount = 0;
    }

    public void setzeAufSpur(Rennauto auto)
    {
        if(auto == null)
        {
            return;
        }
        if(_auto1 == null)
        {
            _auto1 = auto;
            auto.SetStrecke(1);
            return;
        }
        if(_auto2 == null)
        {
            _auto2 = auto;
            auto.SetStrecke(2);
            return;
        }
        if(_auto3 == null)
        {
            _auto3 = auto;
            auto.SetStrecke(3);
            return;
        }
        if(_auto4 == null)
        {
            _auto4 = auto;
            auto.SetStrecke(4);
            return;
        }
    }
    Rennauto liefereSieger()
    {
        float highest = 0;
        Rennauto winner = null;
        if(_auto1 != null && _auto1.GetPosition() > highest)
        {
            highest = _auto1.GetPosition();
            winner = _auto1;
        }
        if(_auto2 != null && _auto2.GetPosition() > highest)
        {
            highest = _auto2.GetPosition();
            winner = _auto2;
        }
        if(_auto3 != null && _auto3.GetPosition() > highest)
        {
            highest = _auto3.GetPosition();
            winner = _auto3;
        }
        if(_auto4 != null && _auto4.GetPosition() > highest)
        {
            winner = _auto4;
        }
        if(highest < _length)
        {
            return null;
        }
        return winner;
    }
    public void simuliereZeitabschnitt(float time)
    {
        while(liefereSieger() == null)
        {
            if(_auto1 != null)
            {
                _auto1.fahre(time);
            }            
            if(_auto2 != null)
            {
                _auto2.fahre(time);
            }
            if(_auto3 != null)
            {
                _auto3.fahre(time);
            }
            if(_auto4 != null)
            {
                _auto4.fahre(time);
            }
        }
    }
    void entferne(Rennauto auto)
    {
        if(auto == null)
        {
            return;
        }
        switch(auto.GetStrecke())
        {
            case 1:
                _auto1 = null;
            break;
            case 2:
                _auto2 = null;
            break;
            case 3:
                _auto3 = null;
            case 4:
                _auto4 = null;
            break;
        }
    }
}