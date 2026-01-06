import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Diese Klasse modelliert einen Tag in einem unbestimmten Jahr, d.h. ohne 
 * Angabe des Jahres selbst (z.B. den 1. April oder den 29. Februar).
 * 
 * @author Axel Schmolitzky
 * @version 2025
 */
class Tag
{
    public final int TAGE_PRO_JAHR = 366;
    private final int _tagNummer;    
    private final Random ZUFALL = new Random();    

    
    /**
     * Initialisiert ein neues Tag-Objekt.
     * 
     * @param tagNummer der Tag des Jahres aus dem Intervall [0,365]. 
     * 0 steht dabei für den 1. Januar, 365 für den 31. Dezember.
     */
    public Tag(int tagNummer)
    {
        if ((tagNummer < 0) || (tagNummer >= TAGE_PRO_JAHR))
        {
            throw new IllegalArgumentException("Ungültige Tagnummer: " + tagNummer);
        }
        _tagNummer = tagNummer;
    }
    
    public boolean equals(Object other)
    {
        if (!(other instanceof Tag))
        {
            return false;
        }
        Tag otherTag = (Tag)other;
        return this._tagNummer == otherTag._tagNummer;
    }
    
    public int hashCode()
    {
        return _tagNummer;
    }

    /**
     * Liefert eine lesbare Darstellung dieses Tag-Objektes. 
     * @return eine lesbare Darstellung dieses Tag-Objektes
     */
    public String toString()
    {
        List<Integer> tpm = new ArrayList<Integer>();
        // Jan           Feb         Mar          Apr         Mai           Jun
        tpm.add(31); tpm.add(29); tpm.add(31); tpm.add(30); tpm.add(31); tpm.add(30); 
        tpm.add(31); tpm.add(31); tpm.add(30); tpm.add(31); tpm.add(30); tpm.add(31);
        // Jul           Aug          Sep         Okt         Nov           Dez
        List<Integer> tageProMonat = tpm;
        
        List<String> monatsname = new ArrayList<String>();
        monatsname.add("Januar"); monatsname.add("Februar"); monatsname.add("März"); 
        monatsname.add("April"); monatsname.add("Mai"); monatsname.add("Juni"); 
        monatsname.add("Juli"); monatsname.add("August"); monatsname.add("September"); 
        monatsname.add("Oktober"); monatsname.add("November"); monatsname.add("Dezember"); 

        int monatsnummer = 0;
        int tagNummer = _tagNummer;
        while (tagNummer >= tageProMonat.get(monatsnummer))
        {
            tagNummer -= tageProMonat.get(monatsnummer);
            ++monatsnummer;
        }
        return (tagNummer + 1) + ". " + monatsname.get(monatsnummer);
    }
    
    /**
     * Liefert einen zufälligen anderen Tag im Jahr 
     * @return einen zufälligen anderen Tag im Jahr
     */
    public Tag gibZufaelligenTag()
    {
        int tagNummer;
        do
        {
            tagNummer = ZUFALL.nextInt(TAGE_PRO_JAHR);
        }
        while (tagNummer == 59 && ZUFALL.nextInt(400) >= 97); 
        // Der Tag mit der Nummer 59 ist der 29. Februar. Er darf nur 
        // mit einer Wahrscheinlichkeit von 97/400 erzeugt werden, 
        // da er in 400 Jahren genau 97x vorkommt. 
        return new Tag(tagNummer);
    }
    

}