/**
 * Die Methoden in dieser Klasse haben keine besonders aussagekräftigen Namen.
 * Schaue dir den Quelltext an, führe die Methoden aus und dokumentiere sie.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2025
 */
class Konsumieren
{
    /**
     * Liefert die führende Ziffer einer Zahl.
     * 
     *    a(5678)
     * -> a(567)
     * -> a(56)
     * -> a(5)
     * -> 5
     */
    public int a(int x)
    {
        int result;
        if (x < 10)     // wenn die Zahl nur aus einer Ziffer besteht...
        {
            result = x;   // ...dann ist diese Ziffer das Ergebnis
        }
        else
        {               // ansonsten wird die rechte Ziffer abgeschnitten...
            result = a(x / 10);
        }               // ...und die Funktion erneut ausgeführt
        return result;
    }

    /**
     * Liefert die Anzahl Ziffern einer Zahl.
     * 
     *   b(5678)
     * -> 1 + b(567)
     * -> 1 + (1 + b(56))
     * -> 1 + (1 + (1 + b(5)))
     * -> 1 + (1 + (1 + 1))
     * -> 1 + (1 + 2)
     * -> 1 + 3
     * -> 4
     */
    public int b(int x)
    {
        int result;
        if (x < 10)     // wenn die Zahl nur aus einer Ziffer besteht...
        {
            result = 1;   // ...dann ist die Anzahl Ziffern 1
        }
        else
        {               // ansonsten ist das Ergebnis um 1 höher...
            result = 1 + b(x / 10);
        }               // ...als die Anzahl Ziffern in der Zahl ohne die rechte Ziffer
        return result;
    }

    /**
     * Liefert die Quersumme einer Zahl.
     *
     *   c(5678)
     * -> 567 -- 8
     * -> 56 -- 7 + 8
     * -> 5 -- 15 + 6
     * -> 0 -- 21 + 5 = 26
     */   
    public int c(int x)
    {
        int result;
        if (x < 10)
        {
            result = x;
        }
        else
        {
            result = (x % 10) + c(x / 10);
        }
        return result;
    }

    /**
     * Wandelt integer in String.
     * 
     *   d(5678)
     * -> d(567) + '8'
     * -> (d(56) + '7') + '8'
     * -> ((d(5) + '6') + '7') + '8'
     * -> (( "5" + '6') + '7') + '8'
     * -> (  "56        + '7') + '8'
     * ->    "567"             + '8'
     * ->    "5678"
     */
    public String d(int x)
    {
        String result;
        if (x < 10)
        {
            result = "" + zifferAlsZeichen(x);
        }
        else
        {
            result = d(x / 10) + zifferAlsZeichen(x % 10);
        }
        return result;
    }

    /**
     * Wandelt eine Ziffer (0 bis 9) in ein Zeichen ('0' bis '9') um.
     * @param x eine ganze Zahl aus dem Bereich 0 bis 9
     */
    private char zifferAlsZeichen(int ziffer)
    {
        return (char)('0' + ziffer);
    }

    /**
     * Spiegelt x. Gibt ein integer.
     * 
     * e(5678)
     * -> 
     */
    public int e(int x)
    {
        return e2(x, 0);
    }

    /**
     *  Hilfsmethode fuer x spiegeln. Spiegelt x und fuegt y am anfang. Gibt ein integer.
     * e2(5678, 0)
     * -> e2(5678), 0 
     * -> e2(567 ), 8
     * -> e2(56  ), 87
     * -> e2(5   ), 876
     * -> e2(    ), 8765
     */
    private int e2(int x, int y)
    {
        int result;
        if (x < 10)
        {
            result = (y * 10) + x;
        }
        else
        {
            result = e2(x / 10, (y * 10) + (x % 10));
        }
        return result;
    }

    /**
     * Sucht nach bestimmter char c in der string s. Gibt index von erster getroffener zurück.
     * 
     * f("Rosen", 'e')
     * -> e2("Rosen", 'e') result + 1
     * -> e2(" osen", 'e') result + 1
     * -> e2("  sen", 'e') result + 1
     * -> e2("   en", 'e') result = 0
     */
    public int f(String s, char c)
    {
        int result;
        if (s.isEmpty())
        {
            result = -1;
        }
        else
        {
            if (s.charAt(0) == c)
            {
                result = 0;
            }
            else
            {
                int ergebnis = f(s.substring(1), c);
                if(ergebnis == -1){
                    result = ergebnis;
                }
                else
                {
                    result = 1 + ergebnis;
                }
            }
        }
        return result;
    }

    /**
     * Sucht nach bestimmter char c in der string s. Gibt index von erster getroffener zurück. 
     */
    public int g(String s, char c)
    {
        return g2(s, c, 0);
    }

    /**
     * Sucht nach bestimmter char c in der string s. Gibt index von erster getroffener zurück.
     * -> g2("Rosen", 'e',0) c != e; i++
     * -> g2(" osen", 'e',1) c != e; i++ 
     * -> g2("  sen", 'e',2) c != e; i++
     * -> g2("   en", 'e',3) c != e; i++
     * -> 
     */
    private int g2(String s, char c, int i)
    {
        int result;
        if (i == s.length())
        {
            result = -1;
        }
        else
        {
            if (s.charAt(i) == c)
            {
                result = i;
            }
            else
            {
                result = g2(s, c, i + 1);
            }
        }
        return result;
    }

    /**
     * Hier finden die Aufrufe statt, die in den Diagrammen
     * auf dem Aufgabenblatt veranschaulicht werden (sollen).
     */
    public void testeAlleMethoden()
    {
        System.out.println(a(5678));
        System.out.println(b(5678));
        System.out.println(c(5678));
        System.out.println(d(5678));
        System.out.println(e(5678));
        System.out.println(f("Rosen", 'e'));
        System.out.println(g("Rosen", 'e'));
    }
}
