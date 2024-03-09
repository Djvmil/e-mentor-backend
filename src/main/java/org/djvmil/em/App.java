package org.djvmil.em;

import org.djvmil.em.controler.AuthentificationController;
import org.djvmil.em.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        AuthentificationController controller = context.getBean(AuthentificationController.class);
        Scanner scanner = new Scanner(System.in);
        User user = new User();
/*
        System.out.println( "Veuillez saisir votre prenom" );
        user.setFirstname(scanner.nextLine());

        System.out.println( "Veuillez saisir votre nom" );
        user.setFirstname(scanner.nextLine());

        System.out.println( "Veuillez saisir votre genre" );
        user.setGenre(scanner.nextLine());
*/
        System.out.println( "Veuillez saisir votre email: " );
        user.setEmail(scanner.nextLine());

        System.out.println( "Veuillez saisir votre password: " );
        user.setPasswors(scanner.nextLine());

        System.out.println( "Veuillez saisir votre birthDate: " );
        user.setBirthDate(scanner.nextLine());

        controller.register(user);
    }

}
