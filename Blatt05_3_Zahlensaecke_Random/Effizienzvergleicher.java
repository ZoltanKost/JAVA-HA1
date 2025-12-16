/**
 * Diese Klasse vergleicht die Effizienz verschiedener Implementationen 
 * von Zahlensack.
 *
 * Implementiere in der Methode vermesse(Zahlensack) den fehlenden Code!
 *
 * @author Fredrik Winkler, Christian M. Späh
 * @version 2025
 */
class Effizienzvergleicher
{
    /**
     * Vergleicht die Effizienz verschiedener Implementationen von Zahlensack.
     * Alle Zahlensäcke werden mit der gleichen Größe erzeugt.
     * 
     * @param groesse die Größe der Zahlensäcke
     */
    public void vergleiche(int groesse)
    {
        if (groesse < 1)
        {
            throw new IllegalArgumentException("groesse < 1");
        }
        
        Zahlensack zs = new Naiv(groesse);
        vermesse(zs);
        
        zs = new Permutation(groesse);
        vermesse(zs);
        
        zs = new Auswahl(groesse);
        vermesse(zs);
    }

    /**
     * Misst die Zeit, die für das Entfernen von sehr vielen Zahlen aus dem
     * Zahlensack benötigt wird. Das Ergebnis wird auf der Konsole ausgegeben.
     * 
     * @param sack der zu vermessende Zahlensack
     */
    private void vermesse(Zahlensack sack)
    {
        long time = System.nanoTime();

        for(int i = 0 ; i < 1000000; i++)
        {
            sack.entferneZahl();
        }
        time = (System.nanoTime() - time) / 1000000;
        System.out.print(sack); // Beschreibung des Zahlensacks ausgeben
        System.out.print(" : "); // gefolgt von einem Doppelpunkt
        System.out.println(time);
        // Gib das Ergebnis auf der Konsole aus
        
    }
}
