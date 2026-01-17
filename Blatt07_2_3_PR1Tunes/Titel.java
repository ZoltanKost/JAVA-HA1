/**
 * Die Klasse Titel beschreibt Musiktitel für eine Musikdatenbank. Ein Titel
 * hat einen Namen, einen Interpreten, stammt aus einem Album, aus einem Jahr
 * und ist einem Genre zugeordnet.
 * 
 * @author Axel Schmolitzky, Petra Becker-Pechau
 * @version 2025
 */
class Titel
{
    private String _name;
    private String _interpret;
    private String _album;
    private int _jahr;
    private String _genre;
    private int _dauer; // die Spieldauer dieses Titels in Sekunden

    /**
     * Initialisiert einen Titel mit allen Details.
     */
    public Titel(String name, String interpret, String album, int jahr,
            String genre, int dauer)
    {
        _name = name;
        _interpret = interpret;
        _album = album;
        _jahr = jahr;
        _genre = genre;
        _dauer = dauer;
    }

    /**
     * Liefert den Namen dieses Titels
     * @return den Namen dieses Titels
     */
    public String gibTitelname()
    {
        return _name;
    }

    /**
     * Liefert den Interpreten dieses Titels
     * @return den Interpreten dieses Titels
     */
    public String gibInterpret()
    {
        return _interpret;
    }

    /**
     * Liefert das Album dieses Titels
     * @return das Album dieses Titels
     */
    public String gibAlbum()
    {
        return _album;
    }

    /**
     * Liefert die Spieldauer dieses Titels in Sekunden
     * @return die Spieldauer dieses Titels in Sekunden
     */
    public int gibLaenge()
    {
        return _dauer;
    }
    
    /**
     * Zwei Titel sind gleich, wenn alle ihre Eigenschaften gleich sind: 
     * Name, Interpret, Album, Jahr, Genre und Dauer.
     */
    public boolean equals(Object object)
    {
        boolean result = false;
        if (object instanceof Titel)
        {
            Titel titel = (Titel) object;
            result = (_name.equals(titel._name) &&  _interpret.equals(titel._interpret) 
                      && _album.equals(titel._album)  &&  _jahr == titel._jahr 
                      &&  _genre.equals(titel._genre) && _dauer == titel._dauer);
        }
        return result;
    }
    
    /**
     * hashCode dieses Titels. 
     */
    public int hashCode()
    {
        return toString().hashCode();
    }


    /**
     * Erzeugt eine Stringrepräsentation für diesen Titel mit 
     * Interpret, Name, Album und Jahr.
     */
    public String toString()
    {
        return _interpret + ": " + _name + " (" + _album + ", " + _jahr + ")";
    }
}
