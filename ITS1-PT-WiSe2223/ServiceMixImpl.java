import java.util.*;

/**
 * Eine Klasse mit mehreren Dienstleister-Methoden.
 * Die Rümpfe sind sinnvoll zu füllen!
 * 
 * @author (Dein Name, Deine Matrikelnummer)
 * @version 2022/23
 */
class ServiceMixImpl implements ServiceMix
{
    public ServiceMixImpl()
    {
        // Diesen Konstruktor unbedingt stehen lassen!
    }

    public Set<String> kuerzesteStringsIn(Set<String> menge)
    {
        Set<String> result = new HashSet<String>();
        int smallest = Integer.MAX_VALUE;
        for(String s : menge)
        {
            if(s.length() > smallest)
            {
                continue;
            }else if(s.length() < smallest)
            {
                result.clear();
            }
            smallest = s.length();
            result.add(s);
        }
        return result;
    }

    public int anzahlAuftreten(char vonChar, String inString)
    {
        if(inString.isEmpty())
        {
            return 0;
        }
        int res = 0;
        if(inString.charAt(0) == vonChar) res++;
        return res + anzahlAuftreten(vonChar, inString.substring(1));
    }

    public int anzahlUnikate(List<String> liste)
    {
        int result = 0;
        for(String s: liste)
        {
            if(liste.indexOf(s) != liste.lastIndexOf(s))
            {
                continue;
            }
            result++;
        }
        return result;
    }

    public int[] negativeZahlen(int[] zahlen)
    {
        int[] result = zahlen.clone();
        for(int i = 0; i < zahlen.length; i++)
        {
            if(result[i] > 0) 
            {
                result[i] = -result[i];
                continue;
            }
            
        }
        return result;
    }

    public int[] zeileMitGroessterSumme(int[][] zahlen)
    {
        int biggestSum = -1;
        int resultIndex = -1;//  if -1 return null
        int width = zahlen.length;
        for(int x = 0; x < width; x++)
        {
            if(zahlen[x] == null)
            {
                // if(zahlen[resultIndex] == null)
                // {
                    // resultIndex = x;
                // }
                continue;
            }
            int summ = 0;
            for(int n : zahlen[x])
            {
                summ += n;
            }
            if(summ >= biggestSum || resultIndex == -1)
            {
                biggestSum = summ;
                resultIndex = x;
            }
        }
        if(resultIndex == -1) return null;
        int[] result = new int[zahlen[resultIndex].length];
    
        for(int i = 0; i < result.length; i++) //.clone
        {
            result[i] = zahlen[resultIndex][i];
            System.out.println(result[i]);
        }
        if(result == null) System.out.println("result is null! ");
        return result;
    }

}
