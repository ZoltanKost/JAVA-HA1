/**
 * Auf einer Party werden Gäste nach ihren Geburtstagen gefragt. 
 * Falls irgendwann ein Geburtstag mehrfach vorkommt, liefert 
 * mindestensEinGeburtstagMehrfach ab dem Zeitpunkt immer true 
 * (und vorher immer false).
 *  
 * @author Fredrik Winkler
 * @author Axel Schmolitzky
 * 
 * @version 2025
 */
interface Party
{
    /**
     * Ein weiterer Gast hat seinen Geburtstag verraten :)
     * 
     * @param geburtstag der Geburtstag des Gasts; darf nicht null sein
     */
    public void fuegeGeburtstagHinzu(Tag geburtstag);
    
    /**
     * Gibt an, ob mehrere Gäste am gleichen Tag Geburtstag haben.
     */
    public boolean mindestensEinGeburtstagMehrfach();
}
