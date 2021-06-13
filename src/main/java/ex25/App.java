/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Abdel Nabut
 */

package ex25;


public class App 
{
    public static void main( String[] args )
    {
        //Scanner input = new Scanner(System.in);
        //System.out.print("Input a password: ");
        //password = input.next();
        String password = args[0];
        if(PasswordValidator.passwordValidator(password) == 0)
            System.out.println("The password '" + password + "' is a very weak password");
        if(PasswordValidator.passwordValidator(password) == 1)
            System.out.println("The password '" + password + "' is a weak password");
        if(PasswordValidator.passwordValidator(password) == 2)
            System.out.println("The password '" + password + "' is a strong password");
        if(PasswordValidator.passwordValidator(password) == 3)
            System.out.println("The password '" + password + "' is a very strong password");

    }
}
