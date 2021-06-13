package ex25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static boolean isNumeric(String password) {
        try {
            Integer.parseInt(password);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean hasOnlyCharacters(String password) {
        char[] letters = password.toCharArray();
        for(char letter: letters) {
            if(!Character.isLetter(letter))
                return false;
        }
        return true;
    }
    private static boolean hasSpecialCharacter(String password) {
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(password);
        return m.find();
    }

    public static int passwordValidator(String password) {
        if(!hasOnlyCharacters(password) && hasSpecialCharacter(password) && password.length() >= 8)
            return 3;
        else if(!hasOnlyCharacters(password) && password.length() >= 8)
            return 2;
        else if(hasOnlyCharacters(password) && password.length() < 8)
            return 1;
        else if(isNumeric(password) && password.length() < 8)
            return 0;
        return 0;
    }
}
