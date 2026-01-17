/**
 * Eine Schnittstelle für Titel-Listen. Eine Titel-Liste enthält eine Reihe von 
 * Musiktiteln in einer benutzerdefinierten Reihenfolge.
 * <br>
 * Da die Reihenfolge von Musiktiteln sehr wichtig ist, stehen indexbezogene
 * Operationen zur Verfügung. Duplikate sind zugelassen, weil in einer Titel-Liste
 * derselbe Titel durchaus mehrfach gewünscht sein kann.
 * 
 * @author Till Aust, Axel Schmolitzky, Petra Becker-Pechau, Christian Späh
 * @version 2025
 */
interface TitelListe
{
    /**
     * Fügt einen Titel an der Position <code>position</code> in die Titelliste
     * ein. Alle folgenden Einträge werden um eine Indexposition verschoben.
     * Wenn <code>position</code> gleich der Länge der Titelliste ist, dann
     * wird der <code>titel</code> am Ende angefügt.
     * 
     * @param titel der einzufügende Titel, darf nicht null sein.
     * @param position die Position des Titels, gültig sind Werte von 0 bis gibLaenge().
     */
    public void fuegeEin(Titel titel, int position);

    /**
     * Entfernt den Titel an der angegebenen Position. Alle folgenden Einträge
     * werden um eine Indexposition verschoben.<br>
     * 
     * @param position Eine Position in der Liste, gültig sind Werte von 0 bis gibLaenge()-1.
     */
    public void entferne(int position);

    /**
     * Prüft, ob ein Titel in der Liste enthalten ist.
     * 
     * @param titel der zu suchende Titel, darf nicht null sein.
     * @return Liefert <code>true</code> wenn der Titel in der Liste ist,
     *         ansonsten <code>false</code>.
     */
    public boolean enthaelt(Titel titel);

    /**
     * Liefert den Titel an der angegebenen Position.
     * 
     * @param position Die Position des Titels, der zurückgegeben werden soll,
     *              gültig sind Werte von 0 bis gibLaenge()-1.
     * @return den Titel an der Position <code>position</code>.
     */
    public Titel gibTitel(int position);

    /**
     * Liefert die Länge der Liste.
     * 
     * @return Anzahl der Titel in der Liste.
     */
    public int gibLaenge();

    /**
     * Entfernt alle Titel aus der Liste.
     */
    public void leere();
}
