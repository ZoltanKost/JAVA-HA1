
/**
 * Prüft bei einer verketteten Struktur von AufgabenKnoten, ob diese eine Schlaufe enthält.
 * Falls sie eine Schlaufe enthält, kann ein SchlaufenPruefer auch ermitteln, wie viele 
 * Elemente die Schlaufe enthält und wie viele Elemente nicht in der Schlaufe enthalten sind.
 *  
 * @author Axel Schmolitzky 
 * @version WiSe 2022/23
 */

interface SchlaufenPruefer 
{
    /**
     * Stellt fest, ob die übergebene verkettete Struktur eine Schlaufe enthält.
     * @param kopf der Kopf der verketteten Struktur, kann null sein
     * @return true, wenn die Struktur eine Schlaufe enthält, false sonst
     */
    public boolean enthaeltSchlaufe(AufgabenKnoten kopf);
    
    /**
     * Liefert die Länge der Schlaufe in der übergebenen verketteten Struktur,
     * falls diese eine Schlaufe enthält, 0 sonst.
     * @param kopf der Kopf der verketteten Struktur, kann null sein
     * @return Anzahl der Knoten in der Schlaufe, falls vorhanden, 0 sonst
     */
    public int laengeDerSchlaufe(AufgabenKnoten kopf);
    
    /**
     * Liefert die Länge des Vorlaufs bis zur Schlaufe in der übergebenen
     * verketteten Struktur, falls diese eine Schlaufe enthält, sonst die
     * Länge der Liste.
     * @param kopf der Kopf der verketteten Struktur, kann null sein
     * @return Anzahl der Knoten vom Kopf bis zur Schlaufe, falls vorhanden,
     *         sonst die Anzahl der Knoten
     */
    public int laengeDesVorlaufs(AufgabenKnoten kopf);
}
