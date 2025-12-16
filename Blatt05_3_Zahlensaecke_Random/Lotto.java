
/**
 * Write a description of class Lotto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Lotto
{
    public Lotto()
    {
    }
    public void sechsAus49()
    {
        Zahlensack sack = new Permutation(49);
        for(int i = 0; i < 6; i++)
        {
            System.out.println(String.valueOf(sack.entferneZahl()));
        }
    }
}