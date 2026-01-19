import java.util.List;
import java.util.Set;

/**
 * Ein Interface mit einer Dienstleister-Operation. 
 * 
 * @author Axel Schmolitzky
 * @version WiSe 2022/23
 */
interface ServiceMix2
{
    /**
     * Liefert für einen einfachen deutschen Satz eine Übersetzung in PermuBabbel.
     * PermuBabbel ist eine Permutation der Anfangsbuchstaben der Wörter eines Satzes.
     * <br><br>
     * Als Vereinfachung gilt: Wörter werden voneinander durch ein Leerzeichen getrennt.
     * Als Anfangsbuchstaben gelten alle Konsonanten bis zum ersten Vokal eines 
     * Wortes. Umlaute gelten als Vokale.
     * Die Anfangsbuchstaben des ersten Wortes wandern vor das zweite Wort,
     * die des zweiten Wortes vor das dritte, ..., die des letzten Wortes vor das erste.
     * Die Groß-Kleinschreibung soll dabei erhalten bleiben, außer bei großen
     * Anfangsvokalen, die Konsonanten vorgesetzt bekommen.
     * Wörter ohne Vokale sind von allen Verschiebungen ausgeschlossen!
     * <br><br>
     * Beispiele: <br>
     * Die Eingabe "Hallo, wie gehts?" soll "gallo, Hie wehts?" liefern.   <br>
     * "Döner wie immer?" --> "öner Die wimmer?"                           <br>
     * "Ich atme einfach aus." --> "Ich atme einfach aus."                 <br>
     * "Hallo." --> "Hallo."                 <br>
     * "Ich hab keinen Schimmer!" --> "Schich ab heinen kimmer!"           <br>
     * "Ich auch nicht." --> "nich auch icht."                             <br>
     * "In PR1 ist viel zu tun." -> "tin PR1 ist iel vu zun."              <br>
     * "Wir schaffen PR1 und PM2 mühelos!" --> mir Waffen PR1 schund PM2 ühelos!"
     * <br>
     * @param original ein einfacher deutscher Satz, garantiert nicht null.
     */
    public String uebersetzeNachPermuBabbel(String original);
    
}