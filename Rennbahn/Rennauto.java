
/**
 * Write a description of class Rennauto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Rennauto
{
    private String _fahrerin;
    private int _fahrzeugtyp;
    private float _maximalgeschwindigkeit; 
    private int _strecke;
    private float _position;
    public Rennauto(String fahrerin, 
                    int fahrzeugtyp,
                    int maximalgeschwindigkeit,
                    int strecke)
    {
        _fahrerin = fahrerin;
        _fahrzeugtyp = fahrzeugtyp;
        _maximalgeschwindigkeit = maximalgeschwindigkeit;
        _strecke = strecke;
        _position = 0;
    }
    
    public Rennauto(String fahrerin)
    {
        _fahrerin = fahrerin;
        _fahrzeugtyp = 0;
        _maximalgeschwindigkeit = 60;
        _strecke = 0;
    }
    
    public void fahre(float time)
    {
        _position += time * Math.random() 
        * _maximalgeschwindigkeit;
    }
    
    public void SetStrecke(int strecke)
    {
        _strecke = strecke;
    }
    
    public int GetStrecke()
    {
        return _strecke;
    }
    
    public float GetPosition()
    {
        return _position;
    }
}