import java.util.*;
/**
 * Write a description of class ServiceMix2Impl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class ServiceMix2Impl implements ServiceMix2
{
    public ServiceMix2Impl()
    {
    }
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
    public String uebersetzeNachPermuBabbel(String original)
    {
        List<String> list = new ArrayList<String>();
        System.out.println("==================================new case==================================");
        System.out.println(original + " length: " + original.length());
        List<String> array = new ArrayList<String>();
        
        int start = 0;
        for(int i = 1; i <= original.length(); i ++)
        {
            if(i == original.length() || original.charAt(i) == ' ') 
            {
                array.add(original.substring(start,i));    
                start = i+1;
            }
        }
        // = original.split(" ");
        System.out.println('[' + " " + 'ü');
        for(int x = 0; x < array.size(); x++)
        {
            String s = array.get(x);
            System.out.println(s);
            boolean separated = false;
            for(int i = 0; i < s.length(); i++)
            {
                char c = s.toLowerCase().charAt(i);
                switch(c)
                {
                    case 'a':case 'e':case 'u':case 'i':case 'o':
                    case 'ü': case 'ä':case 'ö':
                        System.out.println(s.substring(0,i));
                        list.add(s.substring(0,i)); // add all the consonants to the List
                        array.set(x,s.substring(i));
                        separated = true;
                        break;
                    default:
                        if(i == s.length() - 1) 
                        {
                            list.add(s);
                            array.set(x,"");
                        }
                        break;
                }
                if(separated) break;
            }
        }
        
        for(int i = array.size()-1; i > 0; i--)
        {
            String current = array.get(i);
            current = list.get(i - 1) + current;
        }
        array.set(0,list.get(array.size() - 1) + array.get(0));
        
        String result = "";
        for(String s: array)
        {
            result += s + " ";
        }
        result.strip();
        
        return result;
    }
}