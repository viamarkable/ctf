package medium.mysterious-email;

import java.util.*;

public class AtbashCipher {
    static HashMap<Character, Character> lookup_table = new HashMap<Character, Character>(){{
        put('A', 'Z'); 
        put('B', 'Y'); 
        put('C', 'X'); 
        put('D', 'W'); 
        put('E', 'V'); 
        put('F', 'U');
        put('G', 'T'); 
        put('H', 'S'); 
        put('I', 'R'); 
        put('J', 'Q'); 
        put('K', 'P'); 
        put('L', 'O');
        put('M', 'N'); 
        put('N', 'M'); 
        put('O', 'L'); 
        put('P', 'K'); 
        put('Q', 'J'); 
        put('R', 'I');
        put('S', 'H'); 
        put('T', 'G'); 
        put('U', 'F'); 
        put('V', 'E'); 
        put('W', 'D'); 
        put('X', 'C');
        put('Y', 'B'); 
        put('Z', 'A');
    }};

    public static String useAtbash(String message)
    {
        String cipher = "";
        for(char letter : message.toCharArray())
        {
            // Checking for space
            if(letter != ' ')
            {
                // Adds the corresponding letter from the lookup_table
                cipher += Character.toLowerCase(lookup_table.get(Character.toUpperCase(letter)));
            }
            else
            {
                // Adds space
                cipher += ' ';
            }
        }
        return cipher;
    }

    public static void main(String[] args)
    {
        // tbd
    }
}
