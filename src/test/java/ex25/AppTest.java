package ex25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AppTest 
{

    @org.junit.jupiter.api.Test
    void isNumeric() {
        String password = "12345";
        assertEquals(Integer.parseInt(password), 12345);
    }

    @org.junit.jupiter.api.Test
    void hasOnlyCharacters() {
        String correctPassword = "thatDudeAbdel";
        String incorrectPassword = "thatDudeAbdel95";
        boolean foundNonLetter = false;
        char[] letters = correctPassword.toCharArray();
        for(char letter: letters) {
            if (!Character.isLetter(letter))
                foundNonLetter = true;
        }
        assertEquals(false, foundNonLetter);

        char[] incorrectPasswordLetters = incorrectPassword.toCharArray();
        foundNonLetter = false;
        for(char letter: incorrectPasswordLetters) {
            if (!Character.isLetter(letter))
                foundNonLetter = true;
        }
        assertTrue(foundNonLetter);

    }

    @org.junit.jupiter.api.Test
    void hasSpecialCharacter() {
        String password = "Abdel95$$!!";
        String incorrectPassword = "Abdel95";
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(password);
        assertTrue(m.find());
        Matcher n = p.matcher(incorrectPassword);
        assertEquals(false, n.find());
    }

    @org.junit.jupiter.api.Test
    void testPasswordValidator() {
        //wrapper function
    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}
