import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * Eine Mau-Mau-Runde besteht hier aus drei Spielern und einem Kartensatz32 (32 Karten). 
 * In einer Mau-Mau-Runde werden mehrere Spiele gespielt. <br>
 * In einem einzelnen Spiel wird bzw. werden nacheinander: <br>
 * - an jeden Spieler fünf Karten verteilt; <br>
 * - von den restlichen Karten die oberste aufgedeckt; <br>
 * - von jedem Spieler reihum eine zur obersten Karte passende Karte abgelegt, 
 *   bis ein Spieler keine Karten mehr hat. <br>
 * Eine Karte "passt", wenn sie die gleiche Kartenfarbe oder den gleichen Kartenrang 
 * wie die oberste Karte hat.<br>
 * Hat ein Spieler keine passende Karte, wenn er an der Reihe ist, muss er eine weitere 
 * Karte vom Kartenstapel ziehen.<br>
 * 
 * @author Axel Schmolitzky 
 * @version 2025
 */
class MauMauRunde
{
    private Spieler _spieler1;
    private Spieler _spieler2;
    private Spieler _spieler3;
    private Kartensatz32 _kartensatz;

    /**
     * Eine Mau-Mau-Runde besteht aus einem Kartensatz32 
     * (32 Karten) und drei Spielern.
     * Anfangs haben alle Spieler noch keine Karten.
     */
    public MauMauRunde()
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
        
        _kartensatz = new Kartensatz32();
        _spieler1 = new Spieler("Spieler1", map);
        _spieler2 = new Spieler("Spieler2", map);
        _spieler3 = new Spieler("Spieler3", map);
    }

    /**
     * ------------------------------------------------------
     * Mögliche Lösung für Aufgabe 4.4
     */
    public HashSet<Spielkarte> zieheErsteDrilling() 
    {
        Kartenstapel stapel = new Kartenstapel(); 
        
        HashMap<Kartenrang,HashSet<Spielkarte>> encounterMap = new HashMap<Kartenrang,HashSet<Spielkarte>>();
        Kartenrang letzteRang = null;
        do
        {
            Spielkarte karte = stapel.obersteKarteZiehen();
            letzteRang = karte.rang();
            if(encounterMap.get(letzteRang) != null) 
            {
                encounterMap.get(letzteRang).add(karte);
            }else 
            {
                encounterMap.put(letzteRang, new HashSet<Spielkarte>());
            }
        } while (encounterMap.get(letzteRang).size() < 3);
        return encounterMap.get(letzteRang);
    }
    
    private Spielkarte zieheNaechstesBild(Kartenstapel stapel)
    {
        Spielkarte karte = null;
        
        return karte;
    }
    
    private boolean istBild(Spielkarte karte)
    {
        return karte.rang() == Kartenrang.KOENIG 
            || karte.rang() == Kartenrang.DAME 
            || karte.rang() == Kartenrang.BUBE;
    }
    /**
     * Ende Lösung für Aufgabe 4.4
     * ------------------------------------------------------
     */

    /**
     * Karten verteilen: Jeder Spieler erhält fünf Karten.
     * Die restlichen Karten werden als Ergebnis geliefert.
     */
    public Kartenstapel kartenVerteilen()
    {
        Kartenstapel stapel = new Kartenstapel(_kartensatz);

        for (int i=0; i < 5; ++i)
        {
            _spieler1.nimmKarte(stapel.obersteKarteZiehen());
            _spieler2.nimmKarte(stapel.obersteKarteZiehen());
            _spieler3.nimmKarte(stapel.obersteKarteZiehen());
        }
        return stapel;
    }

    /**
     * Diese Methode simuliert ein Spiel in einer Mau-Mau-Runde.
     */
    public void spielenBisGewinnerErmittelt()
    {
        Kartenstapel kartenstapel = kartenVerteilen();
        Spielkarte obersteKarte = kartenstapel.obersteKarteZiehen();
        Kartenansicht ansicht = new Kartenansicht("oberste Karte");
        ansicht.zeige(obersteKarte);
        while (jederSpielerHatNochMindestensEineKarte())
        {
            obersteKarte = eineRundeSpielen(ansicht, obersteKarte,kartenstapel);
        }
        Spieler gewinner = gewinnerErmitteln();
        kartenEinsammeln();
    }

    /**
     * Jeder Spieler bekommt Gelegenheit, eine Karte abzulegen, es sei denn,
     * ein Spieler legt seine letzte Karte ab. Liefert als Ergebnis die
     * zuletzt abgelegte Spielkarte. Wenn ein Spieler nicht bedienen kann,
     * muss er eine frische Karte vom Stapel ziehen.
     * @param ablage die Kartenansicht, die die zuletzt abgelegte Karte zeigt.
     * @param obersteKarte die zuletzt abgelegte Karte.
     * @param stapel der Stapel mit den "frischen" Karten, falls ein Spieler
     *               nicht bedienen kann.
     */
    public Spielkarte eineRundeSpielen(Kartenansicht ablage,
                                       Spielkarte obersteKarte, 
                                       Kartenstapel stapel)
    {
        if(stapel.anzahlKarten() == 0)
        {
            stapel = new Kartenstapel(_kartensatz);
        }
        obersteKarte = obersteKarteDurch(_spieler1,ablage,obersteKarte,stapel);
        if (_spieler1.anzahlKarten() == 0)
        {
            return obersteKarte;  // Ausstieg, Spiel zuende
        }
        if(stapel.anzahlKarten() == 0)
        {
            stapel = new Kartenstapel(_kartensatz);
        }
        obersteKarte = obersteKarteDurch(_spieler2,ablage,obersteKarte,stapel);
        if (_spieler2.anzahlKarten() == 0)
        {
            return obersteKarte; // Ausstieg, Spiel zuende
        }
        if(stapel.anzahlKarten() == 0)
        {
            stapel = new Kartenstapel(_kartensatz);
        }
        return obersteKarteDurch(_spieler3,ablage,obersteKarte,stapel);
    }

    private Spielkarte obersteKarteDurch(Spieler spieler, Kartenansicht ansicht,
                                         Spielkarte oberste, Kartenstapel stapel)
    {
        Spielkarte neueOberste = spieler.bediene(oberste);
        if (neueOberste != oberste) // Spieler konnte bedienen
        {
            ansicht.zeige(neueOberste);
        }
        else // Spieler konnte nicht bedienen, Karte ziehen
        {
            spieler.nimmKarte(stapel.obersteKarteZiehen());
        }
        return neueOberste;
    }

    private boolean jederSpielerHatNochMindestensEineKarte()
    { 
        return _spieler1.anzahlKarten() > 0
        && _spieler2.anzahlKarten() > 0
        && _spieler3.anzahlKarten() > 0;
    }

    /**
     * Liefert während eines Spiels den Spieler, der als erster 
     * keine Karten mehr hat.
     */
    private Spieler gewinnerErmitteln()
    {
        Spieler gewinner = null;
        ArrayList<Spieler> list = new ArrayList<Spieler>();
        list.add(_spieler1);
        list.add(_spieler2);
        list.add(_spieler3);
        
        for(Spieler s: list)
        {
            if(s.anzahlKarten() == 0)
            {
                gewinner = s;
                break;
            }
        }
        list.remove(gewinner);
        Spieler loser = null;
        int highest = 0;
        for(Spieler s: list)
        {
            if(s.zaehlePunkte() > highest)
            {
                loser = s;
            }
        }
        System.out.println("gewinner: " + gewinner.toString() + " \nloser: " + loser.toString());
        return gewinner;
    }

    /**
     * Alle Karten einsammeln, damit neu verteilt werden kann.
     */
    public void kartenEinsammeln()
    {
        _spieler1.gibAlleKartenAb();
        _spieler2.gibAlleKartenAb();
        _spieler3.gibAlleKartenAb();
    }

    /**
     * Liefert Spieler 1 dieser Runde.
     */
    public Spieler spieler1()
    {
        return _spieler1;
    }

    /**
     * Liefert Spieler 2 dieser Runde.
     */
    public Spieler spieler2()
    {
        return _spieler2;
    }

    /**
     * Liefert Spieler 3 dieser Runde.
     */
    public Spieler spieler3()
    {
        return _spieler3;
    }

}
