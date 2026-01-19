import java.util.List;
import java.util.Map;

/**
 * Ein Interface für Schokoriegel-Automaten. 
 * Ein Automat kann Schokoriegel verschiedener Sorten enthalten. Zur Vereinfachung
 * ist die Menge der möglichen Sorten hier als Aufzählung vorgegeben.
 * Schokoriegel können von Kunden (beispielsweise auf Bahnsteigen) gekauft 
 * und von Service-Personen nachgefüllt werden. Alle Riegel kosten
 * einheitlich 80 Eurocent.
 * 
 * Implementierende Klassen müssen einen parameterlosen Konstruktor
 * anbieten, der einen leeren Automaten (also ohne Schokoriegel) initialisiert.
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2022/23
 */
interface SchokoriegelAutomat
{    
    public static final int RIEGELPREIS = 80;
    
    /**
     * Riegel einer Sorte bei diesem Automaten nachfüllen.
     * @param anzahl die Anzahl der nachzufüllenden Riegel, muss > 0 sein
     * @param sorte die Sorte des Schokoriegels, darf nicht null sein
     * @throws IllegalArgumentException
     */
    public void riegelNachfuellen(int anzahl, Schokoriegel sorte);

    /**
     * Eine Handvoll (gemischte) Schokoriegel nachfüllen.
     * Jeder Eintrag in der Liste steht für einen Riegel der jeweiligen
     * Sorte.
     * @param handvoll eine Liste von Schokoriegeln, darf nicht null sein und null
     *                 nicht enthalten
     * @throws IllegalArgumentException
     */
    public void riegelNachfuellen(List<Schokoriegel> handvoll);

    /**
     * Die angegebene Anzahl an Riegeln eines Typs kaufen; vorher muss genügend 
     * Geld eingeworfen worden sein, sonst gibt es eine Exception zum Zustand.
     * Ein Aufruf mit mehr Riegeln als vom Typ im Automaten vorhanden
     * entfernt alle Riegel dieses Typs. Die Kosten der gelieferten
     * Riegel werden als Einnahme verbucht, der Rest wird "zurückgegeben"
     * (eingeworfenesGeld() liefert anschließend Null).
     * @param anzahl die Anzahl der zu kaufenden Riegel, muss > 0 sein
     * @param sorte die zu kaufende Riegelsorte, darf nicht null sein
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     */
    public void riegelKaufen(int anzahl, Schokoriegel sorte);

    /**
     * Alle Riegel aus diesem Automaten kaufen;
     * üblicherweise ein Akt höchster Verzweiflung...
     * Vorher muss genügend Geld eingeworfen worden sein, 
     * sonst gibt es eine Exception zum Zustand.
     * Die Kosten der gelieferten Riegel werden als Einnahme verbucht, 
     * der Rest wird "zurückgegeben" (eingeworfenesGeld() liefert 
     * anschließend Null).
     * @throws IllegalStateException
     */
    public void leerkaufen();
    
    /**
     * Geld in den Automaten einwerfen, um Schokoriegel kaufen zu können.
     * @param geldbetrag ein Geldbetrag in Eurocent, darf nicht negativ sein.
     * @throws IllegalArgumentException
     */
    public void geldEinwerfen(int geldbetrag);
    
    /**
     * Den aktuellen Kauf abbrechen. Lässt den Automaten das eingeworfene
     * Geld zurückgeben.
     */
    public void kaufAbbrechen();
    
    /**
     * Liefert die Info, wie viel Geld für einen aktuellen Kauf eingeworfen wurde.
     * @return die Summe des eingeworfenen Geldes in Eurocent, größer gleich Null.
     */
    public int eingeworfenesGeld(); 

    /**
     * Liefert die Info, wie viel Geld bisher mit abgeschlossenen Verkäufen
     * eingenommen wurde.
     * @return die Summe des eingenommenen Geldes in Eurocent.
     */
    public int eingenommenesGeld(); 

    /**
     * Die Anzahl der Schokoriegel in diesem Automaten.
     */
    public int anzahlRiegel();

    /**
     * Die Anzahl der Riegel der genannten Sorte in diesem Automaten.
     * @param sorte Riegel-Sorte, deren Anzahl geliefert werden soll, darf nicht null sein
     * @throws IllegalArgumentException
     */
    public int anzahlRiegel(Schokoriegel sorte);

}