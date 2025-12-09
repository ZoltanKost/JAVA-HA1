 

import java.util.*;

/**
 * Ein Kartensatz32 besteht aus 32 Spielkarten mit den Rängen 
 * SIEBEN bis AS. In einem Kartensatz32 kommt jedes Kartenbild 
 * nur genau einmal vor.
 * <br><br>
 * Beispiele für Kartenspiele, die einen Kartensatz32 verwenden, 
 * sind MauMau und Skat. 
 * 
 * @author Axel Schmolitzky 
 * @version 2025
 */
class Kartensatz32 implements Iterable<Spielkarte>
{
    private Set<Spielkarte> _karten;
    
    /**
     * Initialisiert einen Kartensatz32 mit 32 neuen Spielkarten.
     */
    public Kartensatz32()
    {
        _karten = new HashSet<Spielkarte>();
        _karten.add(new Spielkarte(Kartenbild.HERZ_7));
        _karten.add(new Spielkarte(Kartenbild.HERZ_8));
        _karten.add(new Spielkarte(Kartenbild.HERZ_9));
        _karten.add(new Spielkarte(Kartenbild.HERZ_10));
        _karten.add(new Spielkarte(Kartenbild.HERZ_BUBE));
        _karten.add(new Spielkarte(Kartenbild.HERZ_DAME));
        _karten.add(new Spielkarte(Kartenbild.HERZ_KOENIG));
        _karten.add(new Spielkarte(Kartenbild.HERZ_AS));

        _karten.add(new Spielkarte(Kartenbild.KARO_7));
        _karten.add(new Spielkarte(Kartenbild.KARO_8));
        _karten.add(new Spielkarte(Kartenbild.KARO_9));
        _karten.add(new Spielkarte(Kartenbild.KARO_10));
        _karten.add(new Spielkarte(Kartenbild.KARO_BUBE));
        _karten.add(new Spielkarte(Kartenbild.KARO_DAME));
        _karten.add(new Spielkarte(Kartenbild.KARO_KOENIG));
        _karten.add(new Spielkarte(Kartenbild.KARO_AS));

        _karten.add(new Spielkarte(Kartenbild.PIK_7));
        _karten.add(new Spielkarte(Kartenbild.PIK_8));
        _karten.add(new Spielkarte(Kartenbild.PIK_9));
        _karten.add(new Spielkarte(Kartenbild.PIK_10));
        _karten.add(new Spielkarte(Kartenbild.PIK_BUBE));
        _karten.add(new Spielkarte(Kartenbild.PIK_DAME));
        _karten.add(new Spielkarte(Kartenbild.PIK_KOENIG));
        _karten.add(new Spielkarte(Kartenbild.PIK_AS));

        _karten.add(new Spielkarte(Kartenbild.KREUZ_7)); 
        _karten.add(new Spielkarte(Kartenbild.KREUZ_8));
        _karten.add(new Spielkarte(Kartenbild.KREUZ_9));
        _karten.add(new Spielkarte(Kartenbild.KREUZ_10));
        _karten.add(new Spielkarte(Kartenbild.KREUZ_BUBE));
        _karten.add(new Spielkarte(Kartenbild.KREUZ_DAME));
        _karten.add(new Spielkarte(Kartenbild.KREUZ_KOENIG));
        _karten.add(new Spielkarte(Kartenbild.KREUZ_AS));
    }
    
    public Iterator<Spielkarte> iterator()
    {
        return _karten.iterator();
    }
    
}
     