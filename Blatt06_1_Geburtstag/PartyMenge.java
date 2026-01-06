import java.util.HashSet;

/**
 * Write a description of class PartyMenge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class PartyMenge implements Party
{  
    private HashSet<Tag> set;
    private boolean _containsDuplicates;
    
    public PartyMenge()
    {
        set = new HashSet<Tag>();
        _containsDuplicates = false;
    }
    
    /**
     * Ein weiterer Gast hat seinen Geburtstag verraten :)
     * 
     * @param geburtstag der Geburtstag des Gasts; darf nicht null sein
     */
    public void fuegeGeburtstagHinzu(Tag geburtstag)
    {
        if(geburtstag == null)
        {
            throw new IllegalArgumentException();
        }
        if(!set.add(geburtstag))
        {
            _containsDuplicates = true;
        }
    }
    
    /**
     * Gibt an, ob mehrere Gäste am gleichen Tag Geburtstag haben.
     */
    public boolean mindestensEinGeburtstagMehrfach()
    {
        return _containsDuplicates;
    }
}