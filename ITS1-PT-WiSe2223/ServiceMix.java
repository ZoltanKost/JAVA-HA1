import java.util.List;
import java.util.Set;

/**
 * Ein Interface mit mehreren Dienstleister-Operationen. 
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2022/23
 */
interface ServiceMix
{
    /**
     * Liefert für eine Menge von Strings eine neue Menge mit den Strings
     * aus der Parametermenge, die so kurz sind wie der kürzeste String in 
     * der Parametermenge.
     * <br><br>
     * Beispiele: <br>
     * Die Eingabe { "a", "b", "c" } soll { "a", "b", "c" } liefern.        <br>
     * Die Eingabe { "a", "bc", "bc" } soll { "a" } liefern.                <br>
     * Die Eingabe { "a", "bc", "c" } soll { "a", "c" } liefern.            <br>
     * Die Eingabe { "ab", "bc", "cd" } soll { "ab", "bc", "cd" } liefern.  <br>
     * Die Eingabe { } soll { } liefern.  <br>
     * <br>
     * @param menge eine Menge mit beliebig langen Strings, ist garantiert nicht null.
     * @return die Menge der kürzesten Strings aus der Parametermenge
     */
    public Set<String> kuerzesteStringsIn(Set<String> menge);
    
    /**
     * Liefert die Anzahl der Unikate in der gegebenen String-Liste.
     * <br><br>
     * Beispiele: <br>
     * Die Eingabe [ "a", "b", "c" ] soll 3 liefern.       <br>
     * Die Eingabe [ "a", "a", "a" ] soll 0 liefern.       <br>
     * Die Eingabe [ "a", "b", "a" ] soll 1 liefern.       <br>
     * Die Eingabe [ "a", "b", "c", "a" ] soll 2 liefern.  <br>
     * <br>
     * @param liste eine Liste mit Zeichenketten, ist garantiert nicht null.
     * @return die Anzahl der Unikate in der Liste
     */
    public int anzahlUnikate(List<String> liste);
    
    /**
     * Liefert für einen übergebenen String die Anzahl der Auftreten
     * des ebenfalls übergebenen Zeichens innerhalb des Strings.
     * @param vonChar das Zeichen, dessen Auftreten gezählt werden soll
     * @param inString der String, in dem gezählt werden soll, garantiert nicht null
     * @return die Häufigkeit vonChar inString
     */
    public int anzahlAuftreten(char vonChar, String inString);
    
    /**
     * Liefert ein neues Array der gleichen Länge wie der aktuelle Parameter, 
     * das Ergebnis-Array enthält ausschließlich negative Zahlen (und eventuell Nullen).
     * Negative Zahlen im Eingabe-Array werden unverändert in das Ergebnis-Array übernommen,
     * positive Zahlen werden negiert. Nullen bleiben unverändert.
     * <br><br>
     * Beispiel:<br>
     * Für den Parameter {1, -3, 2} liefert diese Methode {-1, -3, -2}. <br>
     * 
     * Das Parameter-Array darf nicht verändert werden.
     * @param zahlen ein Array von int-Werten, garantiert nicht null 
     * @return negative Werte der übergebenen Zahlen, darf nicht null sein.
     */
    public int[] negativeZahlen(int[] zahlen);
    
    /**
     * Liefert für ein zweidimensionales Array von int-Werten
     * (aufgefasst als ein Array von ZEILEN) eine KOPIE der Zeile,
     * in der die Werte die größte Summe bilden.
     * int-Array-Objekte der Länge <tt>0</tt> (leere Array-Objekte) 
     * haben hier per Definition auch als Summe <tt>0</tt>. <br>
     * ACHTUNG: Einzelne Zeilen im Array können null sein, deren
     * Summe gilt immer als kleiner als die eines int-Array-Objektes.
     * <br><br>
    * Beispiele: <br>
     * Die Eingabe { { 1 } , { 2 } , { 3 } } liefert ein neues int-Array
     * der Länge 1 mit dem Wert 3 darin. <br>
     * Die Eingabe { { 1 , 5 } , { 2 , 3 } , { 4, <tt>0</tt>, -1 } } liefert ein neues int-Array
     * der Länge 2 mit den Werten 1 und 5 darin. <br>
     * Die Eingabe { { } , { -5 } } liefert ein neues int-Array
     * der Länge <tt>0</tt>. <br>
     * Die Eingabe { { Integer.MINVALUE } , null } liefert ein neues int-Array
     * der Länge 1 mit dem Wert Integer.MINVALUE darin. <br>
     * Die Eingabe { null , null } liefert null.<br>
     * Das Parameter-Array darf nicht verändert werden.
     * @param zahlen ein zweidimensionales Array von int-Werten, garantiert nicht null
     * @return eine Kopie der Array-Zeile mit der höchsten Summe
     */
    public int[] zeileMitGroessterSumme(int[][] zahlen);


    

}