import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashMap;

/**
 * The test class SpielerTest.
 *
 * @author  mihail costenco
 * @version 1.0
 */
public class SpielerTest
{
    private Spieler _spieler;
    /**
     * constructor: initialisations for each test case
     */
    public SpielerTest()
    {
        HashMap<Kartenrang, Integer> map = new HashMap<Kartenrang,Integer>();
        
        map.put(Kartenrang.SIEBEN,3);
        map.put(Kartenrang.ACHT,3);
        map.put(Kartenrang.NEUN,3);
        map.put(Kartenrang.ZEHN,4);
        map.put(Kartenrang.BUBE,2);
        map.put(Kartenrang.DAME,6);
        map.put(Kartenrang.KOENIG,6);
        map.put(Kartenrang.AS,11);
        
        _spieler = new Spieler("name", map);
    }
    /*
     * Testen: 
     * zaehlePunkte:
     *      - leeres hand
     *      - hand mit vier buben
     *      - hand mit 7,8,9
     *      - hand mit dame und koenig
     *      - hand mit 2xas
     *      - hand mit 2x10
     * AnzahlBuben:
     *      - keine karten da
     *      - keine buben da, aber alle andere karten da
     *      - nur die buben da
     *      - buben und andere karten da
     */
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testZaelePunkteLeeresHand()
    {
       assert(_spieler.zaehlePunkte() == 0);
    }
    
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testzaehlePunkte4Buben()
    {
        Spielkarte k = new Spielkarte(Kartenbild.KARO_BUBE);
        Spielkarte k1 = new Spielkarte(Kartenbild.KREUZ_BUBE);
        Spielkarte k2 = new Spielkarte(Kartenbild.HERZ_BUBE);
        Spielkarte k3 = new Spielkarte(Kartenbild.PIK_BUBE);
        _spieler.nimmKarte(k);
        _spieler.nimmKarte(k1);
        _spieler.nimmKarte(k2);
        _spieler.nimmKarte(k3);
        assert(_spieler.zaehlePunkte() == 2 * 4);
    }
    
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testZahlen789()
    {
        Spielkarte k = new Spielkarte(Kartenbild.KARO_7);
        Spielkarte k1 = new Spielkarte(Kartenbild.KREUZ_8);
        Spielkarte k2 = new Spielkarte(Kartenbild.HERZ_9);
        _spieler.nimmKarte(k);
        _spieler.nimmKarte(k1);
        _spieler.nimmKarte(k2);
        assert(_spieler.zaehlePunkte() == 3 * 3);
    }
    
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testZahlen10()
    {
        Spielkarte k = new Spielkarte(Kartenbild.KARO_KOENIG);
        Spielkarte k1 = new Spielkarte(Kartenbild.KREUZ_DAME);
        _spieler.nimmKarte(k);
        _spieler.nimmKarte(k1);
        assert(_spieler.zaehlePunkte() == 2 * 6);
    }
    
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testZahlen2AS()
    {
        Spielkarte k = new Spielkarte(Kartenbild.KARO_AS);
        Spielkarte k1 = new Spielkarte(Kartenbild.KREUZ_AS);
        _spieler.nimmKarte(k);
        _spieler.nimmKarte(k1);
        assert(_spieler.zaehlePunkte() == 2 * 11);
    }
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testZahlen2_10()
    {
        Spielkarte k = new Spielkarte(Kartenbild.KARO_10);
        Spielkarte k1 = new Spielkarte(Kartenbild.KREUZ_10);
        _spieler.nimmKarte(k);
        _spieler.nimmKarte(k1);
        assert(_spieler.zaehlePunkte() == 2 * 4);
    }
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testBuben_leeresHand()
    {
        Spielkarte k = new Spielkarte(Kartenbild.KARO_10);
        Spielkarte k1 = new Spielkarte(Kartenbild.KREUZ_10);
        assert(_spieler.anzahlBuben()== 0);
    }
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testBuben_noBuben()
    {
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_10));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_7));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_8));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_9));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_DAME));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_KOENIG));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_AS));
        assert(_spieler.anzahlBuben() == 0);
    }
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testBuben_Buben()
    {
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        assert(_spieler.anzahlBuben() == 7);
    }
    /**
     * One method per test case, annotated with @Test
     */
    @Test
    public void testBuben_AlleDa()
    {
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_10));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_7));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_8));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_9));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_DAME));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_KOENIG));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_AS));
        _spieler.nimmKarte(new Spielkarte(Kartenbild.KARO_BUBE));
        assert(_spieler.anzahlBuben() == 3);
    }
}