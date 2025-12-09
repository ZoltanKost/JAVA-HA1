/**
 * Triple von Karten.
 *
 * @author (Mihail Costenco)
 * @version (09.12.2025)
 */
class KartenTripel
{
    private Spielkarte karte1;
    private Spielkarte karte2;
    private Spielkarte karte3;
    
    public void KartenTriple()
    {
        karte1 = null;
        karte2 = null;
        karte3 = null;
    }
    
    public boolean istVollstaendig()
    {
        return karte1 != null && karte2 != null && karte3 != null;
    }
    
    public boolean tryAdd(Spielkarte karte)
    {
        Kartenrang rang = karte.rang();
        if(!(rang == Kartenrang.BUBE || rang == Kartenrang.DAME || rang == Kartenrang.KOENIG)) 
        {
            return false;
        }
        if(karte1 == null) karte1 = karte;
        else if(karte2 == null) karte2 = karte;
        else if(karte3 == null) karte3 = karte;
        else return false;
        return true;
    }
}