
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Main
{
    private String[] s;
    public static void main(String[] args)
    {
        //s = args;
        for(String s : args)
        {
            System.out.println(s);
        }
    }
    
    public static int[] analiziereText(String text)
    {
        int[] result = new int[26];
        text = text.toLowerCase();
        int l = text.length();
        for(int i = 0; i < l; i++)
        {
            char c = text.charAt(i);
            if(c < 'a' || c > 'z') continue;
            result[c - 'a'] ++; 
        }
        for(int i = 0; i < 26; i++)
        {
            System.out.println(result[i]); 
        }
        return result;
    }
}