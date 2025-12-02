/**
 * In dieser Klasse sind rekursive Algorithmen umzusetzen.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2025
 */
class Produzieren
{
    public void testeAlleMethoden()
    {
        if(120 != fak(5)) System.out.println("fak " + fak(120));        
        if(3 != modulo(13,5)) System.out.println("mod " + modulo(13,5));
        if(enthaeltVokal("rghjcx") || !enthaeltVokal("rghejcx")) System.out.println("vokal " + enthaeltVokal("rghjcx") + " " + enthaeltVokal("rghejcx"));
        if(!istPalindrom("mamam") || istPalindrom("mamar")) System.out.println("palindrom  " + istPalindrom("mamam") + " " + istPalindrom("mamar"));
        if(!(anzahlLeerzeichen(" ") == 1)) System.out.println("space num " + anzahlLeerzeichen(" "));
        String test = "rom";
        if(!test.equals(umgedreht("mor"))) System.out.println("reversed " + umgedreht("mor"));
    }
    /**
    * Liefert die Fakultät von n, also das Produkt aller natürlichen Zahlen bis n.
    * Die Fakultät von 0 ist per mathematischer Definition 1.
    *
    * Beispielauswertung:
    * 
    *   fak(4)
    * -> 4 * fak(3)
    * -> 4 * (3 * fak(2))
    * -> 4 * (3 * (2 * fak(1)))
    * -> 4 * (3 * (2 * (1 * fak(0))))
    * -> 4 * (3 * (2 * (1 * 1)))
    * -> 4 * (3 * (2 * 1))
    * -> 4 * (3 * 2)
    * -> 4 * 6
    * -> 24
    */
    public int fak(int n)
    {
        return 0;
    }
    
    /**
     * Berechnet n modulo m, also den Rest der ganzzahligen Division n/m.
     * 
     * modulo(14,3) -> modulo(11,3) -> modulo(8,3) -> modulo(5,3) -> modulo(2,3) -> 2
     * 
     * @param n ein beliebiger Wert >= 0
     * @param m ein beliebiger Wert > 0
     */
    public int modulo(int n, int m)
    {
        if(n < 0) n = -n;
        if(m < 0) m = -m;
        if(n < m)
        {
            return n;
        }
        n -= m;
        return modulo(n,m);
    }
    
    /**
    * Gibt an, ob die Zeichenkette einen Vokal enthält. Auswertungen:
    * 
    * enthaeltVokal("brei") -> enthaeltVokal("rei") -> enthaeltVokal("ei") -> true
    * enthaeltVokal("xyz") -> enthaeltVokal("yz") -> enthaeltVokal("z") -> enthaeltVokal("") -> false
    * @param s ein beliebiger String ungleich null
    */
    public boolean enthaeltVokal(String s)
    {
        if(s.length() == 0) return false;
        s = s.toLowerCase();
        switch(s.charAt(0))
        {
        case 'a': case 'e': case 'i': case 'o': case 'u':
            return true;
            default: return enthaeltVokal(s.substring(1,s.length()));
        }
    }
    
    /**
    * Gibt an, ob die Zeichenkette ein Palindrom ist. Auswertungen:
    * 
    * istPalindrom("anna") -> istPalindrom("nn") -> istPalindrom("") -> true
    * istPalindrom("asta") -> istPalindrom("st") -> false
    * istPalindrom("axa") -> istPalindrom("x") -> true
    * istPalindrom("xyz") -> false
    * @param s ein beliebiger String ungleich null
    */
    public boolean istPalindrom(String s)
    {
        if(s.length() == 1 || s.length() == 0) return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
        {
            return istPalindrom(s.substring(1,s.length()-1));
        }
        return false;
    }
    
    /**
    * Berechnet die Anzahl Leerzeichen in der Zeichenketten. Auswertung:
    * 
    * anzahlLeerzeichen("a bc d")
    * -> 0 + anzahlLeerzeichen(" bc d")
    * -> 0 + (1 + anzahlLeerzeichen("bc d"))
    * -> 0 + (1 + (0 + anzahlLeerzeichen("c d")))
    * -> 0 + (1 + (0 + (0 + anzahlLeerzeichen(" d"))))
    * -> 0 + (1 + (0 + (0 + (1 + anzahlLeerzeichen("d")))))
    * -> 0 + (1 + (0 + (0 + (1 + (0 + anzahlLeerzeichen(""))))))
    * -> 0 + (1 + (0 + (0 + (1 + (0 + 0)))))
    * -> 0 + (1 + (0 + (0 + (1 + 0))))
    * -> 0 + (1 + (0 + (0 + 1)))
    * -> 0 + (1 + (0 + 1))
    * -> 0 + (1 + 1)
    * -> 0 + 2
    * -> 2
    * @param s ein beliebiger String ungleich null
    */
    public int anzahlLeerzeichen(String s)
    {
        int result=0;
        if(s.length() == 0) return result;
        if(s.charAt(0) == ' ') result = 1;
        return result + anzahlLeerzeichen(s.substring(1,s.length()));
    }
    
    /**
    * Liefert die umgedrehte Zeichenkette. Auswertung:
    * 
    *   umgedreht("regal")
    * -> umgedreht("egal") + 'r'
    * -> (umgedreht("gal") + 'e') + 'r'
    * -> ((umgedreht("al") + 'g') + 'e') + 'r'
    * -> (((umgedreht("l") + 'a') + 'g') + 'e') + 'r'
    * -> (((          "l"  + 'a') + 'g') + 'e') + 'r'
    * -> ((           "la"        + 'g') + 'e') + 'r'
    * -> (            "lag"              + 'e') + 'r'
    * ->              "lage"                    + 'r'
    * ->              "lager"
    * @param s ein beliebiger String ungleich null
    */
    public String umgedreht(String s)
    {
        if(s.length() < 1) return "";
        return umgedreht(s.substring(1,s.length())) + s.charAt(0);
    }
}
