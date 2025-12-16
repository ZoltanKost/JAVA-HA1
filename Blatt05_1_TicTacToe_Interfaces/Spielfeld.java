
/**
 * Write a description of interface Spielfeld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
interface Spielfeld
{
    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte);
    /**
     * Besetzt die angegebene Position auf dem Spielfeld für einen Spieler.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int zeile, int spalte, int spieler);
    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll();
}