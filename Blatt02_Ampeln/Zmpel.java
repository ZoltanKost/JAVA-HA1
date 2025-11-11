/**
 * Eine Zmpel besteht aus drei Lampen in den Farben rot, gelb und grün.
 * Sie durchläuft periodisch vier Phasen: grün, gelb, rot, rot/gelb.
 * In den ersten drei Phasen leuchtet also nur jeweils eine Lampe,
 * während in der vierten Phase zwei Lampen gleichzeitig leuchten.
 * Der Zustand der einzelnen Lampen kann abgefragt werden,
 * und die Ampel kann in die nächste Phase geschaltet werden.
 * Die Schaltung geschieht explizit durch einen Methodenaufruf
 * (und nicht etwa durch einen automatischen Timer).
 * 
 * @author Fredrik Winkler
 * @version 2025
 */
class Zmpel
{
    private boolean _rot;
    private boolean _gelb;
    private boolean _gruen;

    /**
     * Initialisiert eine neue Zmpel auf die erste Phase (gruen).
     */
    public Zmpel()
    {
        _rot = false;
        _gelb = false;
        _gruen = true;
    }
    
    /**
     * Gibt an, ob die rote Lampe leuchtet.
     */
    public boolean leuchtetRot()
    {
        return _rot;
    }
    
    /**
     * Gibt an, ob die gelbe Lampe leuchtet.
     */
    public boolean leuchtetGelb()
    {
        return _gelb;
    }
    
    /**
     * Gibt an, ob die gruene Lampe leuchtet.
     */
    public boolean leuchtetGruen()
    {
        return _gruen;
    }

    /**
     * Schaltet die Zmpel in die naechste Phase (gruen -> gelb -> rot -> rot/gelb -> gruen).
     */
    public void schalteWeiter()
    {
        _gruen = _rot && _gelb;
        // _gruen darf jetzt nicht mehr ausgelesen werden,
        // weil der alte Wert nicht mehr bekannt ist!
        
        _rot = _gelb && !_rot || _rot && !_gelb;
        
        // Wovon hängt es ab, ob die gelbe Lampe in der nächsten Phase leuchten wird?
        _gelb = !_gelb;
    }
}
