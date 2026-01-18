
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
        int[] result = new int[26];
        if(args.length > 0)
         {
            analiziereText(args[0], result);
        }
        
        for(int i = 0; i < 26; i++)
        {
            System.out.println(result[i]); 
        }
    }
    
    public static void analiziereText(String text, int[] result)
    {
        if(result == null || result.length < 1)
        {
            throw new IllegalArgumentException();
        }
        text = text.toLowerCase();
        int l = text.length();
        for(int i = 0; i < l; i++)
        {
            char c = text.charAt(i);
            if(c < 'a' || c > 'z') continue;
            result[c - 'a'] ++; 
        }
    }
}