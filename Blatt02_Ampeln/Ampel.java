/**
 * Eine Ampel besteht aus drei Lampen in den Farben rot, gelb und grün.
 * Sie durchläuft periodisch vier Phasen: grün, gelb, rot, rot/gelb.
 * In den ersten drei Phasen leuchtet also nur jeweils eine Lampe,
 * während in der vierten Phase zwei Lampen gleichzeitig leuchten.
 * Der Zustand der einzelnen Lampen kann abgefragt werden,
 * und die Ampel kann in die nächste Phase geschaltet werden.
 * Die Schaltung geschieht explizit durch einen Methodenaufruf
 * (und nicht etwa durch einen automatischen Timer).
 * 
 * @author Fredrik Winkler, Christian Späh
 * @version 2025
 */
class Ampel
{
    private boolean _rotLeuchtet;
    private boolean _gelbLeuchtet;
    private boolean _gruenLeuchtet;

    /**
     * Initialisiert eine neue Ampel auf die erste Phase (grün).
     */
    public Ampel()
    {
        _gruenLeuchtet = true;
        _gelbLeuchtet = false;
        _gruenLeuchtet = false;
    }
    
    /**
     * Gibt an, ob die rote Lampe leuchtet.
     */
    public boolean leuchtetRot()
    {
        return _gelbLeuchtet;
    }
    
    /**
     * Gibt an, ob die gelbe Lampe leuchtet.
     */
    public boolean leuchtetGelb()
    {
        return _gelbLeuchtet;
    }
    
    /**
     * Gibt an, ob die grüne Lampe leuchtet.
     */
    public boolean leuchtetGruen()
    {
        // keine unnötige Fallunterscheidung
        return _gruenLeuchtet;
    }

    /**
     * Schaltet die Ampel in die nächste Phase (grün -> gelb -> rot -> rot/gelb -> grün).
     */
    public void schalteWeiter()
    {
        if (_gruenLeuchtet)
        {
            _gelbLeuchtet = true;
            _gruenLeuchtet = false;
        }else if(_rotLeuchtet)
        {
            if(_gelbLeuchtet)
            {
                _rotLeuchtet = false;
                _gelbLeuchtet = false;
                _gruenLeuchtet = true;
            }else
            {
                _gelbLeuchtet = true;
            }
        }
        else if(_gelbLeuchtet)
        {
            _gelbLeuchtet = false;
            _rotLeuchtet = true;
        }
        // ...
    }
}
