public class Iteration 
{
 
    public int countA(String input) 
    {
        if (input == null || input.length( ) == 0) 
	    {
            return 0;
        }
 
        // for (String s: length)
        int count = 0;
        for (int i = 0; i < input.length( ); i++) 
	    {
            if(input.substring(i, i+1).equals("A"))
	    {
                count++;
            }
        }
        return count;
    }
 
    public static void main(String[ ] args) 
    {
          System.out.println(new Iteration( ).countA("AAA rating"));     // Ans.3
    }
} 
