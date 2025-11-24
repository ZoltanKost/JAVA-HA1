/**
 * Diese Klasse bietet die Möglichkeit, Texte zu analysieren.
 * Sie dient als Einstieg in Schleifenkonstrukte und zeigt in
 * der Methode istFrage beispielhaft einige Methodenaufrufe an
 * einem Objekt der Klasse String.
 * 
 * @author Fredrik Winkler, Jörg Rathlev, Petra Becker-Pechau
 * @version 2025
 */
class TextAnalyse
{
    /**
     * Ermittelt, ob es sich bei dem übergebenen Text um eine Frage
     * handelt. Eine Frage erkennt man am abschließenden Fragezeichen.
     * 
     * @param text der zu analysierende Text
     * @return true, wenn es sich um eine Frage handelt, false sonst
     */
    public boolean istFrage(String text)
    {
        int anzahlZeichen = text.length();
        if(anzahlZeichen < 1) return false;
        int letztePosition = anzahlZeichen - 1;

        char letztesZeichen = text.charAt(letztePosition);

        boolean endetAufFragezeichen = (letztesZeichen == '?');
        
        return endetAufFragezeichen;
    }

    /**
     * Ermittelt, ob es sich bei dem übergebenen Text um eine Frage
     * handelt. Eine Frage erkennt man am abschließenden Fragezeichen.
     * 
     * @param text der zu analysierende Text
     * @return true, wenn es sich um eine Frage handelt, false sonst
     */
    public boolean istFrageKompakt(String text)
    {
        int l = text.length(); 
        return l > 0 && text.charAt(l - 1) == '?';
    }
    
    
    public int zaehleVokale(String text)
    {
        int l = text.length();
        int vocalCount = 0;
        for(int i = 0; i < l; i++)
        {
            switch(text.charAt(i))
            {
                case 'a':
                    vocalCount++;
                    break;
                case 'e':
                    vocalCount++;
                    break;
                case 'y':
                    vocalCount++;
                    break;
                case 'u':
                    vocalCount++;
                    break;
                case 'i':
                    vocalCount++;
                    break;
                case 'o':
                    vocalCount++;
                    break;
            }
        }
        return vocalCount;
    }
    /**
     * Ermittelt, ob ein String ein Palindrom ist.
     * 
     * @param s analysierende string
     * @return true, wenn es sich um eine Palindrom handelt, false sonst
     */
    public boolean isPalindrom(String s)
    {
        int l = s.length();
        s = s.toLowerCase();
        if(l < 1) return false;
        
        for(int i = 0; i < l / 2; i++)
        {
            if(!(s.charAt(i) == s.charAt(l - i - 1))) return false;
        }
        
        return true;
    }
    /**
     * Ermittelt, welche substring von string das grosste palindrom ist. Leerzeichen werden dabei als 
     * normale buchstaben betrachtet.
     * 
     * @param s analysierende String
     * @return das groesste Palindrom, leere string wenn keine vorhanden sind
     */
    public String longestPalidrom(String s)
    {
        String res = new String();
        s = s.toLowerCase();
        int l = s.length();
        int checkingIndex = 0;
        int longest = 0;
        String temp = new String();
        
        while(checkingIndex < l - 1)
        {
            char left = s.charAt(checkingIndex);
            
            int checkingRight = checkingIndex + 1;
            boolean isPalindrom = true;
            char right = ' ';
            while(checkingRight < l)
            {
                right = s.charAt(checkingRight);
                if(right != left || (checkingRight - checkingIndex) + 1 < longest )
                {
                    checkingRight++;
                    continue;
                }
                temp = s.substring(checkingIndex, checkingRight + 1);
                if(!this.isPalindrom(temp)) 
                {
                    checkingRight++;
                    continue;
                }
                longest = (checkingRight - checkingIndex) + 1;
                res = temp;
                checkingRight++;
            }
            checkingIndex++;
        }
        
        return res;
    }
    
}
