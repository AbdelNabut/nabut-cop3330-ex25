/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Abdel Nabut
 */

package ex25;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App 
{
    public static boolean isNumeric(String password) {
        try {
            Integer.parseInt(password);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean hasOnlyCharacters(String password) {
        char[] letters = password.toCharArray();
        for(char letter: letters) {
            if(!Character.isLetter(letter))
                return false;
        }
        return true;
    }
    public static boolean hasSpecialCharacter(String password) {
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

    public static void main( String[] args )
    {
        //Scanner input = new Scanner(System.in);
        //System.out.print("Input a password: ");
        //password = input.next();
        String password = args[0];
        if(passwordValidator(password) == 0)
            System.out.println("The password '" + password + "' is a very weak password");
        if(passwordValidator(password) == 1)
            System.out.println("The password '" + password + "' is a weak password");
        if(passwordValidator(password) == 2)
            System.out.println("The password '" + password + "' is a strong password");
        if(passwordValidator(password) == 3)
            System.out.println("The password '" + password + "' is a very strong password");

    }
}
